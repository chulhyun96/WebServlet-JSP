<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MemberAddForm</title>
</head>
<body>
<style>
    .form-field {
        margin-bottom: 10px; /* 하단 마진 추가 */
    }
</style>

<div style="display: flex; flex-direction: column;">
    <form method="post" action="add" class="form-field">
        <div class="form-field">User ID : <input type="text" name="userID"></div>
        <div class="form-field">Password : <input type="password" name="userPassword"></div>
        <div class="form-field">UserName : <input type="text" name="userName"></div>
        <div class="form-field"><button type="submit">완료</button></div>
    </form>
</div>
</div>
</body>
</html>
