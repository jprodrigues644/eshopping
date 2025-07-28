package com.eshopping.eshopping_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable) // Alternative moderne à csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/home", "/products", "/product/**", "/api/auth/**").permitAll()
                        .requestMatchers("/api/cart/**", "/api/orders/confirm", "/api/orders/history", "/api/user/profile").authenticated()
                        .anyRequest().denyAll() // Facultatif, mais bonne pratique : tout ce qui n'est pas listé est interdit
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }


}
