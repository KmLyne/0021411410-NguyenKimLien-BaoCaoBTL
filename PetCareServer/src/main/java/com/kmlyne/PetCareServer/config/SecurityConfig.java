package com.kmlyne.PetCareServer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // Vô hiệu hóa CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin/**").hasRole("Admin") // Chỉ cho phép quản trị viên
                        .requestMatchers("/user/**", "/auth/login", "/auth/register").permitAll()
                        .requestMatchers("/products/**").permitAll() // Các yêu cầu khác được phép
                        .requestMatchers("/categories/**").permitAll()
                        .requestMatchers("/animals/**").permitAll()
                        .requestMatchers("/orders/**").permitAll()
                        .requestMatchers("/customers").permitAll()

                        .anyRequest().authenticated() // Các yêu cầu còn lại cần xác thực
                );
        return http.build();
    }


}
