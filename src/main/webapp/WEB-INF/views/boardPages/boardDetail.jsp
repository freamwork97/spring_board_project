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

<div id="section">
    <table class="table table-dark table-striped">
        <tr>
            <th>id</th>
            <td>${board.id}</td>
        <tr>
            <th>writer</th>
            <td>${board.boardWriter}</td>
        </tr>
        <tr>
            <th>date</th>
            <td>${board.createdAt}</td>
        </tr>
        <tr>
            <th>hits</th>
            <td>${board.boardHits}</td>
        </tr>
        <tr>
            <th>title</th>
            <td>${board.boardTitle}</td>
        </tr>
        <tr>
            <th>contents</th>
            <td>${board.boardContents}</td>
        </tr>
        <c:if test="${board.fileAttached==1}">
            <tr>
                <th>image</th>
                <td>
                    <img src="${pageContext.request.contextPath}/upload/${boardFile.storedFileName}"
                         alt="" width="100" height="100">
                </td>
            </tr>
        </c:if>
    </table>
    <button onclick="board_list()">목록</button>
    <button onclick="board_update()">수정</button>
    <button onclick="board_delete()">삭제</button>
</div>
<input type="text" name="commentWriter" placeholder="제목">
<input type="button" value="댓글작성" onclick="comment_fn()"><br>
<textarea name="commentContents" cols="171" rows="10" placeholder="내용"></textarea>

<%@include file="../component/footer.jsp" %>

</body>
<script>
    const board_update = () => {
        const id = '${board.id}';
        location.href = "/board/update?id=" + id;
    }

    const board_delete = () => {
        const id = '${board.id}';
        location.href = "/board/delete?id=" + id;
    }

    const board_list = () => {
        location.href = "/board/";
    }

    const delete_fn = () => {
        const passArea = document.getElementById("pass-check");
        passArea.style.display = "block";
    }

    const comment_fn = () => {

    }

</script>
</html>