<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <%@include file="/WEB-INF/jspf/style.jspf"%>

    <title>Текущие задачи</title>
</head>
<body>
<%@include file="/WEB-INF/jspf/navigation.jspf" %>

<div class="d-flex doings-container flex-row">

    <c:forEach var="task" items="${ list }">
        <div class="card card-do">
            <div class="card-body">
                <div class="card-title d-flex flex-column align-items-center">
                    <h5 class="mb-3 d-flex align-items-center">
                        <!-- у спан есть класс статус к нему дописываешь status-цвет(red, green, yellow) (status status-red) -->
                        <!-- если тебе нужно три прокрутки то копируешь весь блок целиком(doings-container) и там цвет указываешь -->
                        <c:if test="${ task.priority == 3 }">
                            <span class="status status-red rounded-circle mr-2"></span>
                        </c:if>
                        <c:if test="${ task.priority == 2 }">
                            <span class="status status-yellow rounded-circle mr-2"></span>
                        </c:if>
                        <c:if test="${ task.priority == 1}">
                            <span class="status status-green rounded-circle mr-2"></span>
                        </c:if>
                        ${ task.name }
                    </h5>
                    <div class="d-flex">
                        <h5 class="m-0 d-flex align-items-center mr-2">
                            <span class="status-date ml-4 mr-2"></span>
                            ${ task.deadline }
                        </h5>
                        <a class="edit" href="#"></a>
                        <a class="delete" href="#"></a>
                    </div>
                </div>
                <p class="card-text">${ task.description }</p>
            </div>
            <a href="#" class="btn btn-do">Завершить</a>
        </div>
    </c:forEach>
</div>



</body>
</html>
