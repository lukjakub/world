<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modyfikacja listy</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">
</head>
<body>
<main>

    <form method="post" action="list">
        <input type="submit" name="action-add" value="DODAJ PYTANIE">
    </form>
    <form method="post" action="list">
        <input type="submit" name="action-show" value="POKAŻ LISTĘ">
    </form>

    <c:if test="${requestScope.showButtonClicked}">
        <c:forEach var="q" items="${applicationScope.questionsList}">
            <p>${q}</p>
        </c:forEach>
    </c:if>

    <c:if test="${requestScope.addButtonClicked}">
        <form method="get">
            <p>Podaj dane</p>
            <fieldset>
                <div>
                    <label for="questionContent">Treść pytania</label>
                    <input name="questionContent" id="questionContent">
                </div>
                <div>
                    <label for="answerOptionA">odpowiedź A</label>
                    <input name="answerOptionA" id="answerOptionA">
                </div>
                <div>
                    <label for="answerOptionB">odpowiedź B</label>
                    <input name="answerOptionB" id="answerOptionB">
                </div>
                <div>
                    <label for="answerOptionC">odpowiedź C</label>
                    <input name="answerOptionC" id="answerOptionC">
                </div>
                <div>
                    <label for="answerOptionD">odpowiedź D</label>
                    <input name="answerOptionD" id="answerOptionD">
                </div>
                <div>
                    <label for="correctAnswer">Właściwa odpowiedź</label>
                    <input name="correctAnswer" id="correctAnswer">
                </div>
            </fieldset>
            <input type="submit" name="save" value="ZAPISZ">
        </form>
    </c:if>

    <c:if test="${requestScope.saveButtonClicked}">
            <p>Pytanie dodano do listy</p>

    </c:if>




</main>

</body>
</html>
