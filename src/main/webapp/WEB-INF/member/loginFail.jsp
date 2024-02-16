<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>MemberPage</title></head>
<body>

    <c:choose>
        <c:when test="${result == 0}">
            <h3>PW가 올바르지 않습니다</h3>
            <a href="/">뒤로가기</a>
        </c:when>

        <c:otherwise>
            <h3>회원가입 이력이 없습니다.</h3>
            <a href="/index.jsp">뒤로가기</a>
            <a href="/">회원가입</a>
        </c:otherwise>
    </c:choose>

</body>
</html>
