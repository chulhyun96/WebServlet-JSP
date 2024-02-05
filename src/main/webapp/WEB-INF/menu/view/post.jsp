<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../output.css">
    <title>문서 제목</title>

</head>
<body>
<div class="container mx-auto mt-10">
    <table class="min-w-full table-auto">
        <thead class="bg-gray-200">
        <tr>
            <th class="px-4 py-2">No</th>
            <th class="px-4 py-2">상품 구분</th>
            <th class="px-4 py-2">상품 코드</th>
            <th class="px-4 py-2">상품명</th>
            <th class="px-4 py-2">판매가</th>
            <th class="px-4 py-2">할인가</th>
            <th class="px-4 py-2">모바일 할인가</th>
            <!-- 여기에 더 많은 열 제목 추가 -->
        </tr>
        </thead>

        <tbody>
        <c:forEach var="product" items="${list}">
            <tr>
                <td class="border px-4 py-2">${product.num}</td>
                <td class="border px-4 py-2">${product.category}</td>
                <td class="border px-4 py-2">${product.code}</td>
                <td class="border px-4 py-2">${product.name}</td>
                <td class="border px-4 py-2">${product.price}</td>
                <td class="border px-4 py-2">${product.dPrice}</td>
                <td class="border px-4 py-2">${product.mdPrice}</td>
            </tr>
        </c:forEach>
        <!-- 여기에 더 많은 행 추가 -->
        </tbody>
    </table>
</div>
</body>
</html>

