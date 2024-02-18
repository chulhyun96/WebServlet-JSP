<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.1.2/dist/tailwind.min.css" rel="stylesheet">
<html>
<head>
    <title>UpdateForm</title>
</head>
<body>
<form method="post" action="update?tableId=${post.tableId}" class="max-w-lg mx-auto bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4">
    <div class="mb-4">
        <label class="block text-gray-700 text-sm font-bold mb-2" for="subject">
            Subject
        </label>
        <input type="text" name="subject"
               class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
    </div>
    <div class="mb-6">
        <label class="block text-gray-700 text-sm font-bold mb-2" for="content">
            Content
        </label>
        <textarea name="content"
                  class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 mb-3 leading-tight focus:outline-none focus:shadow-outline"></textarea>
    </div>
    <div class="flex justify-end">
        <button type="submit"
                class="italic antialiased font-serif bg-black text-white mt-3 px-8 py-2 rounded-md hover:text-black hover:bg-white transition-colors duration-500">
            Submit
        </button>
    </div>

</body>
</html>
