<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Student</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<% int row = 1;%>

<body>
<div class="row">
    <div class="col-md-2">
        <jsp:include page="../_Layout.jsp"></jsp:include>
    </div>
    <div class="col-md-10" style="overflow: scroll " >
        <table class="table table-striped" style="width: 90% ; margin-top: 50px">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Id</th>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="row">Email</th>
                <th scope="col">Phone</th>
                <th scope="col">Photo URL</th>
                <th scope="col">Class No</th>
                <th scope="col">Student No</th>
                <th scope="col">Company</th>
                <th scope="col">Department</th>
                <th scope="col">Statu</th>
                <th scope="col">University</th>
                <th scope="col">University Departments</th>
                <th scope="col">University Degree</th>

            </tr>

            </thead>
            <tbody>
            <c:forEach items="${student}" var="student">
                <tr>
                    <th scope="row"><%out.print(row);%></th>
                    <td>${student.id}</td>
                    <td>${student.firstName}</td>
                    <td>${student.lastName}</td>
                    <td>${student.email}</td>
                    <td>${student.phone}</td>
                    <td>${student.photoURL}</td>
                    <td>${student.classNo}</td>
                    <td>${student.studentNo}</td>
                    <td>${student.company.name}</td>
                    <td>${student.department.departmentName}</td>
                    <td>${student.status.name()}</td>
                    <td>${student.universityStudent.universityName}</td>
                    <td>${student.universityDepartmentStudent.universityDepartmentName}</td>
                    <td>${student.universityDegree.degree.name()}</td>
                    <td><a href="/student/admin/delete/${student.id}" class="btn btn-danger">Delete</a></td>
                    <td><a href="/student/admin/edit/${student.id}" class="btn btn-success">Update</a></td>
                </tr>
                <%row++;%>
            </c:forEach>

            </tbody>

        </table>
        <a  href="/student/admin/edit/newStudent" class="btn btn-Primary">New Student</a>
    </div >
</div>
</div>
</body>
</html>
