package dev.codeio.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
    public PasswordEncoder passwordEncoder() throws Exception{
        return new BCryptoPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JwtFilter jwtfilter) throws Exception{
        http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests((auth)      ->  auth.requestMatchers("/auth/**").permitAll().anyRequest().authenticated())
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
