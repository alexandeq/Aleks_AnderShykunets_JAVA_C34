package org.example.congig;
import org.example.domain.Horse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class HorseConfiguration {

    @Bean
    public List<Horse> horsesList() {
        return List.of(
                new Horse("1"),
                new Horse("2"),
                new Horse("3")
        );
    }
}


