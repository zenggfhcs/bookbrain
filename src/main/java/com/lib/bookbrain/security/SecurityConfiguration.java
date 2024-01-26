package com.lib.bookbrain.security;

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
   System.out.println('1');
   http
         .csrf(Customizer.withDefaults())                // 调用 csrfFilter 防止 csrf 攻击
         .authorizeHttpRequests(authorize -> authorize
               .requestMatchers("/**").hasRole("admin")
               .anyRequest().authenticated()
         )
//         .formLogin(formLogin -> formLogin
//               .loginPage("/login")
//               .permitAll()
//         )
         .rememberMe(Customizer.withDefaults());
   
   return http.build();
}
}