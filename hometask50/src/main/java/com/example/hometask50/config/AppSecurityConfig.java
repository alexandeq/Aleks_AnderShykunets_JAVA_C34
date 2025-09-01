package com.example.hometask50.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(registry ->
                {
                    registry.requestMatchers("/").permitAll()                   //доступ для всех
                            .requestMatchers("/auth").authenticated()           //для авторизованных
                            .requestMatchers("/user").hasAuthority("read")      //с полномочием - read
                            .requestMatchers("/support").hasRole("SUPPORT")     //с ролью - SUPPORT
                            .requestMatchers("/removed").denyAll();             //запрещен для всех

                })
                .formLogin(Customizer.withDefaults())
                .build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(PasswordEncoder encoder) {
        return new InMemoryUserDetailsManager(
                User.withUsername("user1")
                        .password(encoder.encode("1122"))
                        .authorities("read")
                        .roles("USER")
                        .build(),
                User.withUsername("user2")
                        .password(encoder.encode("1122"))
                        .authorities("write")
                        .roles("SUPPORT")
                        .build()
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(5);
    }
}