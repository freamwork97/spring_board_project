<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-09-11
  Time: 오전 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>boardSave 글작성페이지</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">

</head>
<body>
<%@include file="../component/header.jsp" %>
<%@include file="../component/nav.jsp" %>

<%--<h2>boardSave 글작성페이지</h2>--%>
<div class="container">
    <form action="/board/save" method="post">
        <input type="text" name="boardWriter" placeholder="작성자">
        <input type="text" name="boardPass" placeholder="비밀번호">
        <input type="submit" value="등록">
        <hr>
        <input type="text" name="boardTitle" placeholder="제목"><br>
        <textarea name="boardContents" cols="171" rows="10"></textarea>
    </form>
</div>
<%@include file="../component/footer.jsp" %>

</body>
</html>
