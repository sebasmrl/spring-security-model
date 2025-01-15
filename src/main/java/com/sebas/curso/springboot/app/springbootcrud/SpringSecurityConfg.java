package com.sebas.curso.springboot.app.springbootcrud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringSecurityConfg {

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(); //Bcript es una implementacion
    }
}
