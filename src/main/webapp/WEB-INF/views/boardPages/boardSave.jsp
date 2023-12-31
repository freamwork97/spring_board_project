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
    <form action="/board/save" method="post" enctype="multipart/form-data">
        <input type="text" name="boardTitle" placeholder="제목을 입력하세요"> <br>
        <input type="text" name="boardWriter" placeholder="작성자를 입력하세요"> <br>
        <input type="text" name="boardPass" placeholder="비밀번호를 입력하세요"> <br>
        <textarea name="boardContents" cols="30" rows="10"></textarea> <br>
        <input type="file" name="boardFile" multiple> <br>
        <input type="submit" value="작성">
    </form>
</div>
<%@include file="../component/footer.jsp" %>
</body>
</html>
