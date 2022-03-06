<%--
  Created by IntelliJ IDEA.
  User: liyijian
  Date: 2022/3/6
  Time: 00:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<div style = "text-align: center">
    <form action="${pageContext.request.contextPath}/login" method="post">
        UserName: <input type = "text" name = "username"> <br>
        Password: <input type = "password" name = "password"> <br>
        Hobbit:
        <input type="checkbox" name  = "hobby" value = "Girl">Girl
        <input type="checkbox" name  = "hobby" value = "Sing">Sing
        <input type="checkbox" name  = "hobby" value = "Coding">Coding
        <input type="checkbox" name  = "hobby" value = "Movie">Movie
        <br>

        <input type="submit">
    </form>
</div>

</body>
</html>
