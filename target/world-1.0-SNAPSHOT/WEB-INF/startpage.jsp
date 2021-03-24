<%--
  Created by IntelliJ IDEA.
  User: Łukasz
  Date: 10.03.2021
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Strona startowa</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">
</head>
<body>
<main>

    <form action="quiz" method="post">
            <input type="submit" value="ROZPOCZNIJ QUIZ">
    </form>
    <form action="list" method="post">
        <input type="submit" value="MODYFIKUJ LISTĘ PYTAŃ">
    </form>





</main>

</body>
</html>
