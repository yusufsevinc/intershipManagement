<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Teacher</title>
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
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="row">Email</th>
                <th scope="col">Phone</th>
                <th scope="col">Photo URL</th>
                <th scope="col">Universities</th>
                <th scope="col">University Departments</th>
                <th scope="col">University Degree</th>

            </tr>

            </thead>
            <tbody>
            <c:forEach items="${teacher}" var="teacher">
                <tr>
                    <th scope="row"><%out.print(row);%></th>
                    <td>${teacher.id}</td>
                    <td>${teacher.firstName}</td>
                    <td>${teacher.lastName}</td>
                    <td>${teacher.email}</td>
                    <td>${teacher.phone}</td>
                    <td>${teacher.photoURL}</td>
                    <td><select name="uni" >
                        <c:forEach items="${teacher.universities}" var="uniName" varStatus="loop">
                            <option >
                                    ${uniName.universityName.toString()}
                            </option>
                        </c:forEach>

                    </select></td>
                    <td><select name="unia">
                        <c:forEach items="${teacher.universityDepartments}" var="uniName" varStatus="loop">
                            <option value="${loop.index}" >
                                    ${uniName.universityDepartmentName}
                            </option>
                        </c:forEach>

                    </select></td>
                    <td><select name="uniaa">
                        <c:forEach items="${teacher.degrees}" var="uniName" varStatus="loop">
                            <option value="${loop.index}">
                                    ${uniName.degree}
                            </option>
                        </c:forEach>

                    </select></td>




                    <td><a href="/teacher/admin/delete/${teacher.id}" class="btn btn-danger">Delete</a></td>
                    <td><a href="/teacher/admin/edit/${teacher.id}" class="btn btn-success">Update</a></td>
                </tr>
                <%row++;%>
            </c:forEach>

            </tbody>
            <tbody>
            </tbody>
        </table>
        <a  href="/teacher/admin/edit/newTeacher" class="btn btn-Primary">New Teacher</a>
    </div >
</div>
</div>
</body>
</html>
