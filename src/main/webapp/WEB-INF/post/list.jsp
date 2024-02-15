<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.1.2/dist/tailwind.min.css" rel="stylesheet">
    <title>문서 제목</title>

</head>

<body>
<div class="flex justify-center pt-10 pl-4 text-3xl italic antialiased font-serif">
    <h1 class="italic antialiased font-serif">Board</h1>
</div>
<div class="bg-white p-8 rounded-lg shadow-lg" style="width:250px;">
    <a href="/member/logout">
        <h1 class="block text-sm font-medium text-white-700">User ID</h1>
        <h3 class="mt-1 block w-full rounded-md border-black-300 shadow-xm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50">${userID}</h3>
        <button type="submit" class="italic antialiased font-serif bg-black text-white mt-3 px-8 py-2 rounded-md
                 hover:text-black hover:bg-white" style="transition: background-color 0.5s, color 0.5s;">
            Logout
        </button>
    </a>
</div>
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
        <c:forEach var="post" items="${size}">
            <tr>
                <td class="border px-4 py-2">${post.tableId}</td>
                <td class="border px-4 py-2">${post.subject}</td>
                <td class="border px-4 py-2">${post.content}</td>
                <td class="border px-4 py-2">${post.userId}</td>
                <td class="border px-4 py-2">${post.formattedDate}</td>
            </tr>
        </c:forEach>
        <!-- 여기에 더 많은 행 추가 -->
        </tbody>
    </table>

    <div class="flex justify-end">
        <a href="add-form">
            <button type="submit" class="italic antialiased font-serif bg-black text-white mt-3 px-8 py-2 rounded-md
                 hover:text-black hover:bg-white" style="transition: background-color 0.5s, color 0.5s;">
                Write
            </button>
        </a>
    </div>
</div>
</body>
</html>