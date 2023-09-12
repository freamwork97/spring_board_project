<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    </table>
    <button onclick="board_list()">목록</button>
    <button onclick="board_update()">수정</button>
    <button onclick="board_delete()">삭제</button>
</div>
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
</script>
</html>