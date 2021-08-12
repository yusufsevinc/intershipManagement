<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>University Department</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<% int row = 1;%>

<body>
<div class="row">
    <div class="col-md-2">
        <jsp:include page="../_Layout.jsp"></jsp:include>
    </div>
    <div class="col-md-10">
        <table class="table table-striped" style="width: 90% ; margin-top: 50px">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Id</th>
                <th scope="col">Name</th>

            </tr>

            </thead>
            <tbody>
            <c:forEach items="${universityDepartment}" var="uniDepartment">
                <tr>
                    <th scope="row"><%out.print(row);%></th>
                    <td>${uniDepartment.universityDepartmentId}</td>
                    <td>${uniDepartment.universityDepartmentName}</td>
                    <td><a href="/universityDepartment/admin/delete/${uniDepartment.universityDepartmentId}" class="btn btn-danger">Delete</a></td>
                    <td><a href="/universityDepartment/admin/edit/${uniDepartment.universityDepartmentId}" class="btn btn-success">Update</a></td>
                </tr>
                <%row++;%>
            </c:forEach>

            </tbody>
            <tbody>
            </tbody>
        </table>
        <a  href="/universityDepartment/admin/edit/newUniversityDepartment" class="btn btn-Primary">New University Department</a>
    </div >
</div>
</div>

</body>
</html>
