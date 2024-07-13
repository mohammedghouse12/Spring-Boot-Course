package com.luv2code.springboot.demosecurity.secuirty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource datasource){
        JdbcUserDetailsManager userDetailsManager =  new JdbcUserDetailsManager(datasource);
        userDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");
        userDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");
        return userDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/leaders/**").hasRole("MANAGER")
                        .requestMatchers("/systems/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
        )
        .formLogin(form->
                form.loginPage("/showMyLoginPage")
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll()
        )
        .logout(logout->logout.permitAll()
        )
        .exceptionHandling(configurer->
                configurer.accessDeniedPage("/access-denied"));

        return http.build();
    }
}
