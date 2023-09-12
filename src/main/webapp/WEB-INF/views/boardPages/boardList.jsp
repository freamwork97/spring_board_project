<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-09-11
  Time: 오전 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<%@include file="../component/header.jsp" %>
<%@include file="../component/nav.jsp" %>

<table class="table table-dark table-striped">
    <tr>
        <td>글번호</td>
        <td>작성자</td>
        <td>글제목</td>
        <td>작성시간</td>
        <td>조회수</td>
    </tr>
    <c:forEach items="${boardList}" var="board">
        <tr>
            <td>${board.id}</td>
            <td>${board.boardWriter}</td>
            <td><a href="/board?id=${board.id}">${board.boardTitle}</a></td>
            <td>${board.createdAt}</td>
            <td>${board.boardHits}</td>
        </tr>
    </c:forEach>
</table>
<%@include file="../component/footer.jsp" %>

</body>
</html>
