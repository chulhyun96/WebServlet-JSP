<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form class="max-w-lg mx-auto bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4">
    <div class="mb-4">
        <label class="block text-gray-700 text-sm font-bold mb-2" for="subject">
            Subject
        </label>
        <textarea type="text" name="subject"
               class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
        <c:out value="${post.subject}"/>
        </textarea>

    </div>
    <div class="mb-6">
        <label class="block text-gray-700 text-sm font-bold mb-2" for="content">
            Content
        </label>
        <textarea name="content"
                  class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 mb-3 leading-tight focus:outline-none focus:shadow-outline">
            <c:out value="${post.content}"/>
        </textarea>
    </div>
    <div class="flex justify-end">
        <a href="delete">
            <button type="submit"
                    class="italic antialiased font-serif bg-black text-white mt-3 px-8 py-2 rounded-md hover:text-black hover:bg-white transition-colors duration-500">
                Delete
            </button>
        </a>
        <a href="update">
            <button type="submit"
                    class="italic antialiased font-serif bg-black text-white mt-3 px-8 py-2 rounded-md hover:text-black hover:bg-white transition-colors duration-500">
                Update
            </button>
        </a>
    </div>
</form>

</body>

</body>
</html>
