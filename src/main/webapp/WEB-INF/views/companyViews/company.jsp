<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Company</title>
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
                <th scope="col">Company Name</th>
                <th scope="col">Company E-mail</th>
                <th scope="col">Company Web Address</th>
                <th scope="row">Company Address</th>
                <th scope="col">Company City</th>
                

            </tr>

            </thead>
            <tbody>
            <c:forEach items="${company}" var="company">
                <tr>
                    <th scope="row"><%out.print(row);%></th>
                    <td>${company.id}</td>
                    <td>${company.name}</td>
                    <td>${company.email}</td>
                    <td>${company.webAddress}</td>
                    <td>${company.address}</td>
                    <td>${company.city.cityName}</td>
                    <td><a href="/company/admin/delete/${company.id}" class="btn btn-danger">Delete</a></td>
                    <td><a href="/company/admin/edit/${company.id}" class="btn btn-success">Update</a></td>
                </tr>
                <%row++;%>
            </c:forEach>

            </tbody>
            <tbody>
            </tbody>
        </table>
        <a  href="/company/admin/edit/newCompany" class="btn btn-Primary">New Company</a>
    </div >
</div>
</div>
</body>
</html>
