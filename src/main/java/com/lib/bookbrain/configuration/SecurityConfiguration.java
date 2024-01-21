package com.lib.bookbrain.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * security config
 *
 * @author yunxia
 */
@Configuration
public class SecurityConfiguration {
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
   http.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
         .oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()));
   return http.build();
}
}