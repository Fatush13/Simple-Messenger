package com.example.pmster.config;

import com.example.pmster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {   //enables spring security
    @Autowired
    private UserService userService;

    @Autowired PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder(8);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception { //method defines which URL paths should be secured
        http
                .authorizeRequests()
                    .antMatchers("/", "/registration", "/static/**", "/activate/*").permitAll()     //dlja dannogo puti - polnyj dostup
                 .anyRequest().authenticated()                                                              //dlja vseh prochih - trebuem autentifikacii
                .and()
                    .formLogin()        //vkljuchaem form login
                    .loginPage("/login")        //ukazyvaem dlja nego mapping
                 .permitAll()                     //razrewaem pol'zovatsja loginom vsem
                .and()
                    .rememberMe()
                .and()
                    .logout()
                    .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(passwordEncoder);
    }
}
