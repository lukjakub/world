package com.example.world;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.world.db.DataSourceProvider.getDataSource;

class QuestionDao {
    private static DataSource dataSource;

    public final String SQL1OptionsCode = "SELECT Name FROM city ORDER BY Population DESC limit 4";
    public final String SQL2OptionsCode = "SELECT Name FROM country WHERE Continent='Africa'ORDER BY SurfaceArea DESC LIMIT 4";
    public final String SQL3OptionsCode = "SELECT Language FROM countrylanguage WHERE CountryCode='CHE' ORDER BY Percentage DESC LIMIT 4";
//    String sql = "CREATE TABLE world_quiz(question_id int, questionContent varchar(250), correctAnswer varchar(45), answerOptionA varchar(45), answerOptionB varchar(45), answerOptionC varchar(45), answerOptionD varchar(45))";

    public QuestionDao() {

        try {
            dataSource = getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    void save(Question question) {
        String sql = String.format("INSERT INTO world.world_quiz(questionContent, correctAnswer, answerOptionA, answerOptionB, answerOptionC, answerOptionD) VALUES('%s', '%s', '%s', '%s', '%s', '%s')",
                question.getQuestionContent(), question.getCorrectAnswer(), question.getAnswerOptionA(), question.getAnswerOptionB(), question.getAnswerOptionC(), question.getAnswerOptionD());
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    List<Question> getAllQuestions(List<Question> list) {
        String sql = "SELECT questionContent, correctAnswer, answerOptionA, answerOptionB, answerOptionC, answerOptionD FROM world.world_quiz";
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String questionContent = resultSet.getString("questionContent");
                String correctAnswer = resultSet.getString("correctAnswer");
                String answerOptionA = resultSet.getString("answerOptionA");
                String answerOptionB = resultSet.getString("answerOptionB");
                String answerOptionC = resultSet.getString("answerOptionC");
                String answerOptionD = resultSet.getString("answerOptionD");
                list.add(new Question(questionContent,correctAnswer,answerOptionA,answerOptionB,answerOptionC,answerOptionD));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list.stream().distinct().collect(Collectors.toList());
    }








    public String getCorrectAnswer(String sql, String columnName) {
        return getAnswerOptions(sql, columnName).get(0);
    }

    public List<String> getAnswerOptions(String sql, String columnName) {
        List<String> answerOptionsList = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String answerOption = resultSet.getString(columnName);
                answerOptionsList.add(answerOption);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return answerOptionsList;
    }

}