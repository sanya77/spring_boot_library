package ru.travin.spring_boot_library.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity // моделирования авторизации на уровне методов
public class SecurityConfig {

    // создаем учетки пользователей
//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
//        UserDetails admin = User.builder().username("admin").password(encoder.encode("admin")).roles("ADMIN").build();
//        UserDetails user = User.builder().username("user").password(encoder.encode("user")).roles("USER").build();
//        UserDetails sanya55 = User.builder().username("sanya55").password(encoder.encode("sanya55")).roles("ADMIN", "USER").build();
//
//        return new InMemoryUserDetailsManager(admin, user, sanya55);
//    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/v2/books").permitAll()
//                        .anyRequest().authenticated().requestMatchers("api/v1/**"))
//                .exceptionHandling(excep -> excep.authenticationEntryPoint(((request, response, authException) -> {
//                    response.sendRedirect("http://localhost8080/error.html");
//                }))).build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
