package org.example.dto;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter

public class QuizDto {

    private UUID id;
    private String question;
    private String answer;

    public QuizDto(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public QuizDto(String answer) {

    }
}






