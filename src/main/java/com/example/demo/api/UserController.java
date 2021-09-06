package com.example.demo.api;

import com.example.demo.Entity.User;
import com.example.demo.repository.UsersRepository;
import com.example.demo.security.JWT.JwtProvider;
import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;
import com.example.demo.vo.request.LoginForm;
import com.example.demo.vo.response.JwtResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@RequestMapping("api/v1/user")
@RestController
public class UserController {

    private final String jwtSecret = "me.zhulin";
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping(path = "{email}")
    public User getUser(@PathVariable("email") String email) {
        return userService.findOne(email);
    }


    @Autowired
    UsersRepository usersRepository;


    @Autowired
    UserService userService;


    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginForm loginForm) {
        // throws Exception if authentication failed

        logger.info(usersRepository.findByEmail(loginForm.getUsername()).toString());
        User user = usersRepository.findByEmail(loginForm.getUsername());
        // check if the user exist or not
        if (user == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        //check if the password matches
        if(!(user.getPwd().equals(loginForm.getPassword()))) {
            logger.info("WRONG\n");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // generate tokens for user
        String jwt = getJWTToken(loginForm.getUsername());

        // return the jwt token
        return ResponseEntity.ok(new JwtResponse(jwt, user.getEmail(), user.getName(), user.getRole()));

    }


    private String getJWTToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + 1000 * 1000L))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    @PostMapping("/register")
    public ResponseEntity<User> save(@RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.save(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    /*
    @DeleteMapping(path = "{name}")
    public int deleteUser(@PathVariable("name") String name) {
        userService.delete(name);
        return 1;
    }

     */
    @GetMapping
    @CrossOrigin(origins = "http://localhost:8080")
    public List<User> getAllUser() throws SQLException {
        return userService.getAllUser();
    }


    @GetMapping("/profile/{email}")
    public ResponseEntity<User> getProfile(@PathVariable("email") String email, Principal principal) {
        if (principal.getName().equals(email)) {
            return ResponseEntity.ok(userService.findOne(email));
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

}
