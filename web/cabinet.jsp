<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 26.02.2022
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/task-style.css">
</head>

<body>

<form action="/cabinet" method="post">
    <div id="myDIV" class="header">
        <h2>Product List</h2>
        <input type="text" id="product-name" name="title" placeholder="title..."/>
        <input type="text" id="product-type"  name="author"   placeholder="author..."/>
        <input type="text" id="product-price" name="price" placeholder="price..."/>
        <br>
        <button class="addBtn">Add</button>
    </div>
</form>

<ul id="myUL">

</ul>
<script src="js/todo.js"></script>
</body>
</html>