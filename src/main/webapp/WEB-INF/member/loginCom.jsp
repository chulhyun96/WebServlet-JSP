<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>MemberPage</title></head>
<body>

    <c:choose>
        <c:when test="${result == 1}">
            <h3>${memberVO.userId}님 환영합니다</h3>
        </c:when>
    </c:choose>

</body>
</html>
