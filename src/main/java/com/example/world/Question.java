package com.example.world;

import java.util.Objects;

public class Question {

    private String questionContent;
    private String correctAnswer;
    private String answerOptionA;
    private String answerOptionB;
    private String answerOptionC;
    private String answerOptionD;



    public Question(String questionContent, String correctAnswer, String answerOptionA, String answerOptionB, String answerOptionC, String answerOptionD) {
        this.questionContent = questionContent;
        this.correctAnswer = correctAnswer;
        this.answerOptionA = answerOptionA;
        this.answerOptionB = answerOptionB;
        this.answerOptionC = answerOptionC;
        this.answerOptionD = answerOptionD;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getAnswerOptionA() {
        return answerOptionA;
    }

    public void setAnswerOptionA(String answerOptionA) {
        this.answerOptionA = answerOptionA;
    }

    public String getAnswerOptionB() {
        return answerOptionB;
    }

    public void setAnswerOptionB(String answerOptionB) {
        this.answerOptionB = answerOptionB;
    }

    public String getAnswerOptionC() {
        return answerOptionC;
    }

    public void setAnswerOptionC(String answerOptionC) {
        this.answerOptionC = answerOptionC;
    }

    public String getAnswerOptionD() {
        return answerOptionD;
    }

    public void setAnswerOptionD(String answerOptionD) {
        this.answerOptionD = answerOptionD;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionContent='" + questionContent + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", answerOptionA='" + answerOptionA + '\'' +
                ", answerOptionB='" + answerOptionB + '\'' +
                ", answerOptionC='" + answerOptionC + '\'' +
                ", answerOptionD='" + answerOptionD + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(questionContent, question.questionContent) && Objects.equals(correctAnswer, question.correctAnswer) && Objects.equals(answerOptionA, question.answerOptionA) && Objects.equals(answerOptionB, question.answerOptionB) && Objects.equals(answerOptionC, question.answerOptionC) && Objects.equals(answerOptionD, question.answerOptionD);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionContent, correctAnswer, answerOptionA, answerOptionB, answerOptionC, answerOptionD);
    }
}
