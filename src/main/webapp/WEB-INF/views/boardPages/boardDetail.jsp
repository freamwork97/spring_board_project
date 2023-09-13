<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
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
                    <c:forEach items="${boardFileList}" var="boardFile">
                        <img src="${pageContext.request.contextPath}/upload/${boardFile.storedFileName}"
                             alt="" width="100" height="100">
                    </c:forEach>
                </td>
            </tr>
        </c:if>
    </table>
    <button onclick="board_list()">목록</button>
    <button onclick="board_update()">수정</button>
    <button onclick="board_delete()">삭제</button>
</div>
<div id="comment-write-area">
    <input type="text" name="commentWriter" id="comment-Writer" placeholder="작성자">
    <input type="text" name="commentContents" id="comment-Contents" placeholder="내용"> <br>
    <button onclick="commentWrite()">댓글작성</button>

</div>
<div id="comment-list-area">
    <%--댓글 출력될 공간--%>
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

    const commentWrite = () => {
        const commentWriter = document.getElementById("comment-Writer").value();
        const commentContents = document.querySelector("#comment-Contents").value();
        const boardId = '${board.id}';
        const result = document.getElementById("comment-list-area")
        $.ajax({
            type: "post",
            url: "/comment/save",
            data: {
                commentWriter: commentWriter,
                commentContents: commentContents,
                boardId: boardId
            },
            success: function (res) {
                console.log("리턴값: ", res)
                let output = "<table id=\"comment-list\">\n" +
                    "    <tr>\n" +
                    "        <th>작성자</th>\n" +
                    "        <th>내용</th>\n" +
                    "        <th>작성시간</th>\n" +
                    "    </tr>\n";
                for (let i in res) {
                    output += "    <tr>\n" ;
                    output += "        <td></td>\n" ;
                    output += "        <td></td>\n" ;
                    output += "        <td></td>\n" ;
                    output += "    </tr>\n" ;
                }

            },
            error: function () {
                console.log("댓글작성실패");
            }
        });
    }

</script>
</html>