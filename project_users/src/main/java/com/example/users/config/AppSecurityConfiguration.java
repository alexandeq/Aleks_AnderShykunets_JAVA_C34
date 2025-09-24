package com.example.users.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class AppSecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(registry -> { registry
                        .requestMatchers("/register", "/login/**", "/person/**").permitAll()
                        .requestMatchers("/movie/admin/**").hasAuthority("ADMIN")
                        .requestMatchers("/movie/user/**").hasAuthority("USER")
                        .requestMatchers("/movie/**").authenticated()
                        .anyRequest().authenticated();
                })
                .formLogin(form -> form
                        .loginPage("/login")  // кастомная форма логина
                        .defaultSuccessUrl("/movie", true)
                        .permitAll()
                )
                .logout(cust -> cust
                        .invalidateHttpSession(true)
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                )
                .build();

    }



        @Bean
        public PasswordEncoder passwordEncoder () {
            return NoOpPasswordEncoder.getInstance();
        }


    }

