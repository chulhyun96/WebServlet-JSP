<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>MyList</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.1.2/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
<div class="container mx-auto mt-10">
    <table class="min-w-full table-auto">
        <thead class="bg-gray-200">
        <tr>
            <th class="px-4 py-2 pl-4 text-lg text-center italic antialiased font-serif">No</th>
            <th class="px-4 py-2 pl-4 text-lg text-center italic antialiased font-serif">Subject</th>
            <th class="px-4 py-2 pl-4 text-lg text-center italic antialiased font-serif">Content</th>
            <th class="px-4 py-2 pl-4 text-lg text-center italic antialiased font-serif">Writer</th>
            <th class="px-4 py-2 pl-4 text-lg text-center italic antialiased font-serif">Date</th>
            <!-- 여기에 더 많은 열 제목 추가 -->
        </tr>
        </thead>

        <tbody>
        <c:forEach var="post" items="${myList}">
            <tr>
                <td id="post" class="border px-4 py-2">${post.tableId}</td>
                <td id="post" class="border px-4 py-2"><a href="detail?tableId=${post.tableId}">${post.subject}</a></td>
                <td id="post" class="border px-4 py-2">${post.content}</td>
                <td id="post" class="border px-4 py-2">${post.userId}</td>
                <td id="post" class="border px-4 py-2">${post.formattedDate}</td>
            </tr>
        </c:forEach>
        <!-- 여기에 더 많은 행 추가 -->
        </tbody>
    </table>


</body>
</html>
