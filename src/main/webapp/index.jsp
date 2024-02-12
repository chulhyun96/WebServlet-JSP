<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>로그인 화면</h1>
    <form method="get" action="member/login">
        UserID : <input type="text" name="userID">
        PW : <input type="text" name="userPassword">
        <button type="submit">로그인</button>
    </form>
</body>
</html>