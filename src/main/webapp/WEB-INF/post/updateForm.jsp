<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>UpdateForm</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.1.2/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
<form method="post" action="update" class="max-w-lg mx-auto bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4">
    <input type="hidden" name="tableId" value="${post.tableId}"/> <!-- post 객체의 tableId 값을 사용 -->

    <div class="mb-4">
        <label class="block text-gray-700 text-sm font-bold mb-2" for="subject">
            Subject
        </label>
        <input type="text" name="subject" style="width: 400px;"
               class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
    </div>
    <div class="mb-6">
        <label class="block text-gray-700 text-sm font-bold mb-2" for="content">
            Content
        </label>
        <textarea name="content" style="width: 400px; height:250px;"
               class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 mb-3 leading-tight focus:outline-none focus:shadow-outline"></textarea>
    </div>
    <div class="flex justify-end">
        <button type="submit"
                class="italic antialiased font-serif bg-black text-white mt-3 px-8 py-2 rounded-md hover:text-black hover:bg-white transition-colors duration-500">
            Submit
        </button>
    </div>
</form>
</body>
</html>
