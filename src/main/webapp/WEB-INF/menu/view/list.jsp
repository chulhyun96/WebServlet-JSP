<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link rel="stylesheet" type="text/css" href="../css/dropbtn.css">
<head>
    <title>Title</title>
</head>
<body>

<div class="dropdown">
    <button class="dropbtn">Shop</button>
    <div class="dropdown-content">
        <a href="list?category=0">All</a>
        <a href="list?category=1">Onepiece</a>
        <a href="list?category=2">Knit</a>
        <a href="list?category=3">Pants</a>
    </div>
</div>
<c:forEach var="p" items="${list}">
    <img src="${p.img}">
    <div>${p.name}</div>
    <div>${p.price}</div>
</c:forEach>

</body>
</html>
