<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.1.2/dist/tailwind.min.css" rel="stylesheet">
<head>
    <title>Title</title>
</head>
<body>

<div class="flex-row">
    <h1 class="pt-10 pl-4 text-3xl text-center italic antialiased font-serif"><a href="#">Mineurs</a></h1>
    <h4 class="pt-10 pl-4 text-base text-center italic antialiased font-serif">Product</h4>
</div>

<div class="flex place-content-between pt-4 m-10 italic font-serif relative">
    <a href="list">All</a>
    <a href="list?category=1">Top</a>
    <a href="list?category=2">Pants</a>
    <a href="list?category=3">Knit</a>
</div>
<hr class="p-4">

<div class="flex flex-wrap justify-between">
    <c:forEach var="p" items="${list}">
        <div class="w-1/3 p-3">
            <a href="#"><img src="${p.img}" alt="${p.name}" class="w-full h-auto"></a>
            <span style="font-size:12px;color:#555555;">${p.name}</span>
            <br>
            <span style="font-size:12px;color:#555555;font-weight:bold;">${p.price}원</span>
        </div>
    </c:forEach>
</div>

</body>
</html>
