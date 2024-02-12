<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>MemberPage</title></head>
<body>

    <c:choose>
        <c:when test="${result == 1}">
            <h3>${memberVO.userId}님 환영합니다</h3>
            <h3><a href="/post/list">게시글 보러가기</a></h3>
        </c:when>

        <c:when test="${result == 0}">
            <h3>PW가 올바르지 않습니다</h3>
            <a href="/index.jsp">뒤로가기</a>
        </c:when>

        <c:otherwise>
            <h3>회원가입 이력이 없습니다.</h3>
            <a href="/index.jsp">뒤로가기</a>
            <a href="/member/add-form">회원가입</a>
        </c:otherwise>
    </c:choose>

</body>
</html>
