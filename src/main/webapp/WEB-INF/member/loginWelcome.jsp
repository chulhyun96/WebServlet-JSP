<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:choose>

        <c:when test="${result == -100}">
            <h1>회원 ID 중복</h1>
            <h2>다시 작성해주세요</h2>
            <h2><a href="add-form">다시작성하기</a></h2>
            <h2><a href="/index.jsp">로그인 하러가기</a></h2>
        </c:when>

        <c:when test="${result < 0}">
            <h1>회원가입 실패</h1>
            <h2>${memberVO.message}</h2>
            <a href="/index.jsp">로그인 하러가기</a>
        </c:when>

        <c:otherwise>
            <h1>회원가입 완료</h1>
            <h2>${memberVO.userId}님 환영합니다</h2>
            <h3><a href="/post/list">게시글 보러가기</a></h3>
        </c:otherwise>

    </c:choose>


</body>
</html>
