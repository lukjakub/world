package com.example.world;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/quiz")
public class QuizController extends HttpServlet {
    QuestionService questionService = new QuestionService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        Object count = context.getAttribute("count");
        request.setAttribute("count", count);
        request.getRequestDispatcher("/WEB-INF/quest.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String answer= request.getParameter("answer-action");
        ServletContext context = getServletContext();
        int count = questionService.count(answer);
        context.setAttribute("count", count);
        request.setAttribute("count", count);
        request.setAttribute("question", questionService.getQuestion());
        request.setAttribute("index", (questionService.index + 1));
        request.setAttribute("sizeCondition", questionService.sizeCondition());
        request.getRequestDispatcher("/WEB-INF/quest.jsp").forward(request, response);
    }
}