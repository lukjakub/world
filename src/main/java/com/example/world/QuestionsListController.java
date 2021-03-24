package com.example.world;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/list")
public class QuestionsListController extends HttpServlet {
    QuestionService questionService = new QuestionService();

    @Override
    public void init() {
        getServletContext().setAttribute("questionsList", questionService.questionsList);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionAdd = request.getParameter("action-add");
        String actionShow = request.getParameter("action-show");
        boolean addButtonClicked = questionService.isSButtonClicked(actionAdd, "DODAJ PYTANIE");
        boolean showButtonClicked = questionService.isSButtonClicked(actionShow, "POKAŻ LISTĘ");
        request.setAttribute("addButtonClicked",addButtonClicked);
        request.setAttribute("showButtonClicked",showButtonClicked);
        request.getRequestDispatcher("/WEB-INF/qblist.jsp").forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String questionContent = request.getParameter("questionContent");
        String correctAnswer = request.getParameter("correctAnswer");
        String answerOptionA = request.getParameter("answerOptionA");
        String answerOptionB = request.getParameter("answerOptionB");
        String answerOptionC = request.getParameter("answerOptionC");
        String answerOptionD = request.getParameter("answerOptionD");

        String save = request.getParameter("save");
        boolean saveButtonClicked = questionService.isSButtonClicked(save, "ZAPISZ");
        request.setAttribute("saveButtonClicked",saveButtonClicked);

        Question question = new Question(questionContent,correctAnswer,answerOptionA,answerOptionB,answerOptionC,answerOptionD);
        questionService.checkIfPresentAndSave(question,questionService.questionsList);
        request.getRequestDispatcher("/WEB-INF/qblist.jsp").forward(request, response);
    }
}