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

    <title>Завершённые задачи</title>
</head>
<body>
<%@include file="/WEB-INF/jspf/navigation.jspf" %>
<div class="d-flex doings-container">
    <div class="card card-do">
        <div class="card-body">
            <div class="card-title d-flex flex-column align-items-center">
                <h5 class="mb-3 d-flex align-items-center">
                    <span class="status status-red rounded-circle mr-2"></span>
                    Special title treatment
                </h5>
                <div class="d-flex">
                    <h5 class="m-0 d-flex align-items-center mr-2">
                        <span class="status-date ml-4 mr-2"></span>
                        31.1.12
                    </h5>
                    <a class="edit" href="#"></a>
                    <a class="delete" href="#"></a>
                </div>
            </div>
            <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
        </div>
    </div>
</div>
</body>
</html>
