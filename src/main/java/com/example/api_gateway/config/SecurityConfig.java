package com.example.api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        // http.cors(Customizer.withDefaults()).authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
        //         .oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()));
        // return http.build();


        http
        .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF
        .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()); // Permitir todas las solicitudes
    
        return http.build();
    } 
    

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
