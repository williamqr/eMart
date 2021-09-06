package com.example.demo.service;

import com.example.demo.repository.UsersRepository;
import com.example.demo.security.SpringSecurityConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    UsersRepository usersRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserDetailService.class);

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        logger.info("USER " + ((UserDetails) usersRepository.findByEmail(s)).toString());
        return (UserDetails) usersRepository.findByEmail(s);

    }
}
