<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-09-11
  Time: 오전 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>비밀번호확인</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">

</head>
<body>
<%@include file="../component/header.jsp" %>
<%@include file="../component/nav.jsp" %>

<div id="container">
    <form action="/board/delete" method="post" name="deleteForm">
        <input type="hidden" name="id" value="${board.id}">
        <input type="text" name="boardPass" id="boardPass" placeholder="비밀번호"><br>
        <input type="button" value="삭제" onclick="delete_fn()">
    </form>
</div>
<%@include file="../component/footer.jsp" %>

</body>
<script>
    const delete_fn = () => {
        const ex1 = document.getElementById("boardPass").value;
        const check = '${board.boardPass}';
        console.log(ex1);
        if (ex1 == check) {
            document.deleteForm.submit();
        } else {
            alert("비밀번호 불일치")
        }
    }
</script>
</html>
