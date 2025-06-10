package org.example.service;

import org.example.config.DataBaseConfig;
import org.example.dto.QuizDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class QuizService {

    private final DataBaseConfig dataBaseConfig;

    public QuizService() {
        dataBaseConfig = new DataBaseConfig();
    }

    public void save(QuizDto quizDto) {

        try {
            quizDto.setId(UUID.randomUUID());

            Connection connection = DataBaseConfig.getConection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into quizs (id, question, answer) values (?, ?, ?)");

            preparedStatement.setObject(1, quizDto.getId());
            preparedStatement.setString(2, quizDto.getQuestion());
            preparedStatement.setString(3, quizDto.getAnswer());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public QuizDto getById(UUID id) {
        try {
            Connection connection = DataBaseConfig.getConection();
            var statement = connection.prepareStatement("select * from quizs where id = ?");
            statement.setObject(1, id);
            var resultSet = statement.executeQuery();

            while (resultSet.next()) {

                var question = resultSet.getString("question");
                var answer = resultSet.getString("answer");

                return new QuizDto(id, question, answer);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return new QuizDto();
    }

    public List<QuizDto> getAll() {

        List<QuizDto> quizs = new ArrayList<>();

        try {

            Connection connection = DataBaseConfig.getConection();
            Statement statement = connection.createStatement();
            var resultSet = statement.executeQuery("select * from quizs");

            while (resultSet.next()) {
                var id = resultSet.getObject("id", UUID.class);
                var question = resultSet.getString("question");
                var answer = resultSet.getString("answer");

                var quiz = new QuizDto(id, question, answer);

                quizs.add(quiz);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return quizs;
    }
    public List<QuizDto> getAllAnswers() {

        List<QuizDto> answers = new ArrayList<>();
        try {

            Connection connection = DataBaseConfig.getConection();
            Statement statement = connection.createStatement();
            var resultSet = statement.executeQuery("select * from quizs");

            while (resultSet.next()) {
                var id = resultSet.getObject("id", UUID.class);
                var question = resultSet.getString("question");
                var answer = resultSet.getString("answer");

                var quiz = new QuizDto(id, question, answer);

                answers.add(quiz);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return answers;
    }

    public void update(UUID id, QuizDto dto) {
        try {
            Connection connection = DataBaseConfig.getConection();
            PreparedStatement preparedStatement = connection.prepareStatement("update quizs set question = ? where id = ?");

            preparedStatement.setString(1, dto.getQuestion());
            preparedStatement.setObject(2, id);

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public  QuizDto edit(){
        return null;
    }

    public void delete(UUID id){

        try {
            Connection connection = DataBaseConfig.getConection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from quizs where id = ?");

            preparedStatement.setObject(1, id);

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}







