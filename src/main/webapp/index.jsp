<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>로그인 화면</h1>
<div style="display: flex">
    <form method="get" action="member/login">
        UserID : <input type="text" name="userID">
        PW : <input type="password" name="userPassword">
        <button type="submit">로그인</button>
    </form>
    <a href="member/add-form"><button type="submit">회원가입</button></a>
    <a href="/post/list"><button type="submit">게시판 바로가기</button></a>
</div>
</body>
</html>