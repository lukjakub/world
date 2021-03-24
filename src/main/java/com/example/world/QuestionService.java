package com.example.world;

import java.util.*;

public class QuestionService {

    private static final QuestionDao questionDao = new QuestionDao();
    public int clickCounter = 0;
    public int index = -1;
    private static final Set<String > correctAnswersSet = new HashSet<>();
    public List<Question> questionsList = questionDao.getAllQuestions(getDefaultQuestionsList());

    private List<Question> getDefaultQuestionsList() {
        List<Question> defaultQuestionsList = new ArrayList<>();
        QuestionsBase questionsBase = new QuestionsBase();
        defaultQuestionsList.add(questionsBase.question1);
        defaultQuestionsList.add(questionsBase.question2);
        defaultQuestionsList.add(questionsBase.question3);
        return defaultQuestionsList;
    }


    public int count(String action) {
        for (Question question : questionsList) {
            String correctAnswer = question.getCorrectAnswer();
            if (!correctAnswersSet.contains(correctAnswer) &&
                    correctAnswer.equals(action)) {
                correctAnswersSet.add(correctAnswer);
                clickCounter++;
            }
        }
        return clickCounter;
    }

    public void checkIfPresentAndSave(Question questionToCheck, List<Question> list) {
        boolean noneMatch = list.stream().noneMatch(question -> question.equals(questionToCheck));
        if (noneMatch) {
            questionDao.save(questionToCheck);
        }
    }






    public boolean isSButtonClicked(String action, String value) {
        boolean equals = false;
        if(action != null && value != null) {
            equals = action.equals(value);
        }
        return equals;
    }



    public Optional<Question> getQuestion() {
        Question question = null;
        index++;
        if (sizeCondition()) {
            question = questionsList.get(index);
        }
        return Optional.ofNullable(question);
    }

    public boolean sizeCondition() {
        return index < questionsList.size();
    }
}
