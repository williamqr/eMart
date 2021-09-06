package com.example.demo.security;

import com.example.demo.security.JWT.JwtFilter;
import com.example.demo.service.UserDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
@DependsOn("passwordEncoder")
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


    private static final Logger logger = LoggerFactory.getLogger(SpringSecurityConfig.class);
    @Autowired
    private JwtFilter jwtFilter;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    @Autowired
    private UserDetailService userDetailService;
    /*
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .jdbcAuthentication()
                .usersByUsernameQuery(this.usersQuery)
                .authoritiesByUsernameQuery(this.rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder);
    }
    */




    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder);
    }



    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception{
       http.cors().and().csrf().disable()
               .authorizeRequests()
               .antMatchers("/user/**").authenticated()

               .antMatchers("/profile/**").authenticated()
                .antMatchers("/cart/**").access("hasAnyRole('CUSTOMER')")
               .antMatchers("/order/finish/**").access("hasAnyRole('EMPLOYEE', 'MANAGER')")
              .antMatchers("/order/**").authenticated()
               .antMatchers("/profiles/**").authenticated()
               .antMatchers("/seller/product/new").access("hasAnyRole('MANAGER')")




               .antMatchers("/seller/**/delete").access("hasAnyRole( 'MANAGER')")

                .antMatchers("/seller/**").access("hasAnyRole('EMPLOYEE', 'MANAGER')")

                .anyRequest().permitAll()


                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }







}
