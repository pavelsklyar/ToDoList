<%--
  Created by IntelliJ IDEA.
  User: pavelsklyar
  Date: 2019-03-28
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/WEB-INF/jspf/style.jspf"%>

    <title>Добавить задачу</title>
</head>
<body>
<%@include file="/WEB-INF/jspf/navigation.jspf" %>

<form action="/add/" class="addForm d-flex flex-column mb-2" method="post">
    <div class="form-group">
        <p>Название:</p>
        <input class="form-control input-small mb-2 p-1 pl-2" type="text" name="name" placeholder="Название задачи">
    </div>
    <div class="form-group">
        <p>Описание:</p>
        <textarea class="form-control" name="description" cols="30" rows="10" placeholder="Описание задачи"></textarea>
    </div>
    <div class="form-group">
        <p>Приоритет:</p>
        <select class="form-control" name="priority">
            <option value="3">3</option>
            <option value="2">2</option>
            <option value="1">1</option>
        </select>
    </div>
    <div class="form-group">
        <p>Дедлайн:</p>
        <input class="form-control input-small mb-2 p-1 pl-2" type="date" name="deadline">
    </div>
    <input type="submit" value="Добавить" class="btn w-auto mx-auto mt-2">
</form>

</body>
</html>
