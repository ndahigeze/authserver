package com.example.authsever;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    public void init(AuthenticationManagerBuilder auth)throws Exception{
        /**
         * Using in memory user
         */
//        auth.inMemoryAuthentication().withUser("ellen").password("{noop}pass").roles("USER").and()
//                .withUser("ben").password("{noop}pass").roles("ADMIN");

        /**
         * Using datasource
         */

        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from system_user where username=?")
                .authoritiesByUsernameQuery("select username, role from system_user where username=?");


    }




}
