<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Teacher</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>

<body>
<div class="row">
    <div class="col-md-2">
        <jsp:include page="../_Layout.jsp"></jsp:include>
    </div>
    <div class="col-md-10">
        <form:form action="save" method="post" modelAttribute="teacher" cssStyle="margin: 50px">
            <table  border="0" cellpadding="5">
                <tr>
                    <td>First Name :</td>
                    <td><form:input path="firstName" type = "text" required = "true"/></td>
                </tr>
                <tr>
                    <td>Last Name :</td>
                    <td><form:input path="lastName" type = "text" required = "true"/></td>
                </tr>
                <tr>
                    <td>Email :</td>
                    <td><form:input path="email" type = "text" required = "true"/></td>
                </tr>
                <tr>
                    <td>Password :</td>
                    <td><form:input path="password" type = "password" required = "true"/></td>
                </tr>
                <tr>
                    <td>Phone :</td>
                    <td><form:input path="phone" type = "text" required = "true"/></td>
                </tr>
                <tr>
                    <td>Photo URL :</td>
                    <td><form:input path="photoURL" type = "text" required = "true"/></td>
                </tr>
                <tr>
                    <td>University :</td>
                    <td>
                    <form:select path="universityId">
                        <c:forEach var="university" items="${university}">
                           <form:option value="${university.universityId}" label="${university.universityName}"/>
                        </c:forEach>
                    </form:select></td>
                </tr>
                <tr>
                    <td>University Department :</td>
                    <td>
                        <form:select path="universityDepartmentId">
                            <c:forEach var="universityDepartment" items="${universityDepartment}">
                                <form:option value="${universityDepartment.universityDepartmentId}" label="${universityDepartment.universityDepartmentName}"/>
                            </c:forEach>
                        </form:select></td>
                </tr>
                <tr>
                    <td>University Degree :</td>
                    <td>
                        <form:select path="universityDegreeId">
                            <c:forEach var="universityDegree" items="${universityDegree}">
                                <form:option value="${universityDegree.degreeId}" label="${universityDegree.degree.name()}"/>
                            </c:forEach>
                        </form:select></td>
                </tr>
                <tr>
                <td colspan="2"><input type="submit" value="Save" class="btn btn-Primary"></td>
                </tr>
            </table>
        </form:form>
    </div>
</div>
</body>
</html>