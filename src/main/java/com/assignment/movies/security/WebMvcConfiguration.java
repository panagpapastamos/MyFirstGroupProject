package com.assignment.movies.security;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebMvcConfiguration extends WebSecurityConfigurerAdapter{
     
    @Autowired
    DataSource dataSource;
    
    //The BCrypt encoder when the user writes his password so it will be encrypted on the db
    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //We use this code for the authentication of the users and we use password encoder
    //to make sure the correct encryption will be used and in our case we used BCrypt encryption
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder());
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Unregistered users have access to the homepage and the pages related to the users like the login page
        http.authorizeRequests().antMatchers("/", "/home","/users/**").permitAll().
                //Registered Users and Admin have access to every page but the ones related to the admin
                antMatchers("/movies/**","/payment/**").hasAnyRole("USER","ADMIN").
                //Admin has access to some views under the admin/ url
                antMatchers("/admin/**").hasRole("ADMIN").and().      
                formLogin().loginPage("/users/signIn").permitAll().and().logout().permitAll();

        http.csrf().disable();
    }
    

    //We use jdbUserDetailsManager to store and retrieve the user information from the db
    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager() throws Exception {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
        jdbcUserDetailsManager.setDataSource(dataSource);
        return jdbcUserDetailsManager;
    }
    

    
}
