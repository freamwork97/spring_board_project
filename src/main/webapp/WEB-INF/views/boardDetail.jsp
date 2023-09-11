<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">

</head>
<body>

<table class="table table-dark table-striped">
    <tr>
        <td>글번호</td>
        <td>작성자</td>
        <td>글제목</td>
        <td>조회수</td>
        <td>수정</td>
        <td>삭제</td>
    </tr>
    <tr>
        <td>${board.id}</td>
        <td>${board.boardWriter}</td>
        <td>${board.boardTitle}</td>
        <td>${board.boardHits}</td>
        <td>
            <button class="btn btn-info" onclick="update_fn('${board.id}')">수정</button>
        </td>
        <td>
            <button class="btn btn-danger" onclick="delete_fn('${board.id}')">삭제</button>
        </td>
    </tr>

</table>
<textarea name="boardContents" cols="30" rows="10" readonly>${board.boardContents}</textarea><br>

<a href="/board/list">목록으로 돌아가기</a>
</body>
<script>
    const update_fn = (id) => {
        location.href = "/board/update?id=" + id;
    }

    const delete_fn = (id) => {
        location.href = "/board/delete?id=" + id;
    }
</script>
</html>