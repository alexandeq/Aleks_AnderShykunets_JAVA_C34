package org.example.web.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
    public class PersonDto {

        @NotBlank(message = "must be not empty")
        private String login;
        @NotBlank(message = "must be not empty")
        private String email;
        private Integer age;

    }

