<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-09-11
  Time: 오전 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">

</head>
<body>
<%@include file="../component/header.jsp" %>
<%@include file="../component/nav.jsp" %>

<%--<h2>업데이트</h2>--%>
<div id="container">
    <form action="/board/update" method="post" name="updateForm">
        <input type="hidden" name="id" value="${board.id}">
        <input type="text" name="boardTitle" value="${board.boardTitle}" placeholder="제목"> <br>
        <input type="text" name="boardWriter" value="${board.boardWriter}" readonly> <br>
        <input type="text" name="boardPass" id="boardPass" placeholder="비밀번호"><br>
        <textarea name="boardContents" cols="171" rows="10"></textarea>

        <input type="button" value="수정" onclick="update_fn()">
    </form>
</div>
<%@include file="../component/footer.jsp" %>

</body>
<script>
    const update_fn = () => {
        const ex1 = document.getElementById("boardPass").value;
        const check = '${board.boardPass}';
        console.log(ex1);
        if (ex1 == check) {
            document.updateForm.submit();
        } else {
            alert("비밀번호 불일치")
        }
    }
</script>
</html>
