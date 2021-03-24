package com.example.world;

import java.util.ArrayList;
import java.util.List;

public class QuestionsBase {

    private final QuestionDao questionDao = new QuestionDao();

    final Question question1 = getQuestion(
            "Które miasto na świecie posiada największą populację?",
            questionDao.getCorrectAnswer(questionDao.SQL1OptionsCode, "Name"),
            questionDao.getAnswerOptions(questionDao.SQL1OptionsCode,"Name")
    );

    final Question question2 = getQuestion(
            "Które miasto w Afryce posiada największą powierzchnię?",
            questionDao.getCorrectAnswer(questionDao.SQL2OptionsCode, "Name"),
            questionDao.getAnswerOptions(questionDao.SQL2OptionsCode,"Name")
    );

    final Question question3 = getQuestion(
            "Który z języków jest najpopularniejszy w Szwajcarii?",
            questionDao.getCorrectAnswer(questionDao.SQL3OptionsCode, "Language"),
            questionDao.getAnswerOptions(questionDao.SQL3OptionsCode,"Language")
    );




    private Question getQuestion(String questionContent, String correctAnswer, List<String> answerOptions) {
        return new Question(
                questionContent,
                correctAnswer,
                answerOptions.get(0),
                answerOptions.get(1),
                answerOptions.get(2),
                answerOptions.get(3)
        );
    }
}


