<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detail Page</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>

<body class="bg-gray-100 p-10">
    <div class="mb-4">
        <label class="block text-gray-700 text-sm font-bold mb-2" for="subject">
            Subject
        </label>
        <textarea type="text" name="subject" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
            ${post.subject}
        </textarea>

    </div>
    <div class="mb-6">
        <label class="block text-gray-700 text-sm font-bold mb-2" for="content">
            Content
        </label>
        <textarea name="content" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 mb-3 leading-tight focus:outline-none focus:shadow-outline">
            ${post.content}
        </textarea>
    </div>

    <c:choose>
        <c:when test="${result == false}">
            <div class="flex justify-end">
                <a href="list">
                    <button type="submit" class="italic antialiased font-serif bg-black text-white mt-3 px-8 py-2 rounded-md hover:text-black hover:bg-white transition-colors duration-500">
                        Back
                    </button>
                </a>
            </div>
        </c:when>

        <c:otherwise>
            <div class="flex justify-end">
                <a href="delete">
                    <button type="submit" class="italic antialiased font-serif bg-black text-white mt-3 px-8 py-2 rounded-md hover:text-black hover:bg-white transition-colors duration-500">
                        Delete
                    </button>
                </a>
                <a href="update">
                    <button type="submit" style="margin-left: 10px;" class="italic antialiased font-serif bg-black text-white mt-3 px-8 py-2 rounded-md hover:text-black hover:bg-white transition-colors duration-500">
                        Update
                    </button>
                </a>
                <a href="list">
                    <button type="submit" style="margin-left: 10px;" class="italic antialiased font-serif bg-black text-white mt-3 px-8 py-2 rounded-md hover:text-black hover:bg-white transition-colors duration-500">
                        Back
                    </button>
                </a>
            </div>
        </c:otherwise>
    </c:choose>
</body>
</html>
