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
<div class="page-container">
    <div class="form-container">
        <ul class="nav nav-tabs" id="myTab" role="tablist">
            <li class="nav-item">
                <a class="nav-link" id="authorisation-tab" data-toggle="tab" href="#authorisation" role="tab" aria-controls="authorisation" aria-selected="true">Авторизация</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="registartion-tab" data-toggle="tab" href="#registration" role="tab" aria-controls="registration" aria-selected="false">Регистрация</a>
            </li>
        </ul>
        <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade show active" id="authorisation" role="tabpanel" aria-labelledby="authorisation-tab">
                <form action="/" class="auth-form d-flex flex-column mb-2 form-group" method="post">
                    <h3>Авторизация</h3>
                    <input type="email" name="email" class="form-control input-small mb-2 p-1 pl-2" placeholder="email">
                    <input type="password" name="password" class="form-control input-medium mb-2 p-1 pl-2" placeholder="пароль">
                    <input type="submit" value="Авторизоваться" class="btn w-auto mx-auto">
                </form>
            </div>
            <div class="tab-pane fade show" id="registration" role="tabpanel" aria-labelledby="registartion-tab">
                <form action="/" class="auth-form d-flex flex-column mb-2" method="post">
                    <h3>Регистрация</h3>
                    <input type="email" name="reg_email" class="form-control input-small mb-2 p-1 pl-2" placeholder="email">
                    <input type="password" name="reg_password" class="form-control input-medium mb-2 p-1 pl-2" placeholder="пароль">
                    <input type="password" name="reg_confirm_password" class="form-control input-medium mb-2 p-1 pl-2" placeholder="пароль ещё раз">
                    <input type="submit" value="Зарегистрироваться" class="btn w-auto mx-auto">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
