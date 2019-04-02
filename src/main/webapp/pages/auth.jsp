<%--
  Created by IntelliJ IDEA.
  User: pavelsklyar
  Date: 2019-03-25
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    <link rel="stylesheet" href="/css/style.css" type="text/css">--%>
    <%@include file="/WEB-INF/jspf/style.jspf"%>
    
    <title>Авторизация</title>
</head>
<body>
<div class="d-flex flex-row justify-content-center align-items-center w-100 h-100">
    <form action="/" class="auth-form d-flex flex-column mb-2" method="post">
        <h2>Авторизация</h2>
        <input type="email" name="email" class="input-small mb-2 p-1 pl-2" placeholder="email">
        <input type="password" name="password" class="input-medium mb-2 p-1 pl-2" placeholder="пароль">
        <input type="submit" value="Авторизоваться" class="btn btn-primary w-50 mx-auto">
    </form>

    <form action="/" class="auth-form d-flex flex-column mb-2" method="post">
        <h2>Регистрация</h2>
        <input type="email" name="reg_email" class="input-small mb-2 p-1 pl-2" placeholder="email">
        <input type="password" name="reg_password" class="input-medium mb-2 p-1 pl-2" placeholder="пароль">
        <input type="password" name="reg_confirm_password" class="input-medium mb-2 p-1 pl-2" placeholder="пароль ещё раз">
        <input type="submit" value="Зарегистрироваться" class="btn btn-primary w-50 mx-auto">
    </form>
</div>
</body>
</html>
