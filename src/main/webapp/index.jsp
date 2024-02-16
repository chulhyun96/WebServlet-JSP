<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <!-- Tailwind CSS 링크 -->
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100 flex items-center justify-center h-screen">
<div class="bg-white p-8 rounded-lg shadow-lg">
    <form method="get" action="/member/login" class="flex flex-col space-y-4">
        <div>
            <label for="userID" class="block text-sm font-medium text-white-700">UserID</label>
            <input type="text" name="userID" class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50" required>
        </div>
        <div>
            <label for="userPassword" class="block text-sm font-medium text-gray-700">PW</label>
            <input type="password" name="userPassword" class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50" required>
        </div>
        <button type="submit" class="italic antialiased font-serif bg-black text-white mt-3 px-8 py-2 rounded-md
                 hover:text-black hover:bg-white" style="transition: background-color 0.5s, color 0.5s;">
            Login
        </button>
    </form>
    <div class="flex justify-between mt-6">
        <a href="member/add-form" class="italic antialiased font-serif bg-black text-white mt-3 px-8 py-2 rounded-md
                 hover:text-black hover:bg-white" style="transition: background-color 0.5s, color 0.5s;">SignIn</a>
        <div style="margin: 5px"></div>
        <a href="post/list" class="italic antialiased font-serif bg-black text-white mt-3 px-8 py-2 rounded-md
                 hover:text-black hover:bg-white" style="transition: background-color 0.5s, color 0.5s;">Go to Board</a>
    </div>
</div>
</body>
</html>
