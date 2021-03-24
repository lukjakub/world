<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quiz</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">
</head>
<body>

<c:choose>
    <c:when test="${requestScope.sizeCondition}">
        <h1>Pytanie nr ${requestScope.index}</h1>
        <form method="post">
        <p>${requestScope.question.get().questionContent}</p>
        <input type="submit" name="answer-action" value="${requestScope.question.get().answerOptionA}">
        <input type="submit" name="answer-action" value="${requestScope.question.get().answerOptionB}">
        <input type="submit" name="answer-action" value="${requestScope.question.get().answerOptionC}">
        <input type="submit" name="answer-action" value="${requestScope.question.get().answerOptionD}">
        </form>
    </c:when>
    <c:otherwise>
        <h1>Koniec</h1>
        <br>
        <form action="res" method="post">
            <input type="submit" value="Sprawdź wynik">
        </form>
    </c:otherwise>
</c:choose>

</body>
</html>
