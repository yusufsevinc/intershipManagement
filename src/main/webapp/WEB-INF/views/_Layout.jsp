<%--
  Created by IntelliJ IDEA.
  User: sevinc
  Date: 3.08.2021
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<title>Admin Kontrol</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="https://cdn.ckeditor.com/4.7.3/standard/ckeditor.js"></script>
<link href="~/lib/bootstrap/dist/css/bootstrap.css" rel="stylesheet" />




<body>

<!-- Sidebar -->
<div class="w3-sidebar w3-black w3-bar-block" style="width:15%">
    <h3 class="w3-bar-item">Menu</h3>
    <a href="/teacher/getall" class="w3-bar-item w3-button">Teachers</a>
    <a href="/student/getall" class="w3-bar-item w3-button">Students</a>
    <a href="/company/getall" class="w3-bar-item w3-button">Companies</a>
    <a href="/university/getall" class="w3-bar-item w3-button">Universities</a>
    <a href="/universityDepartment/getall" class="w3-bar-item w3-button">University Departments</a>


</div>


</body>
</html>
