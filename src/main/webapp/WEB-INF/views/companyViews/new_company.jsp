<%@ page import="com.intership.internshipmanagement.model.University" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Company</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>

<body>
<div class="row">
    <div class="col-md-2">
        <jsp:include page="../_Layout.jsp"></jsp:include>
    </div>
    <div class="col-md-10">
        <form:form action="save" method="post" modelAttribute="company" cssStyle="margin: 50px">
            <table  border="0" cellpadding="5">
                <tr>
                    <td>Company E-mail:</td>
                    <td><form:input path="email" type = "text" required = "true"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:input path="password" type = "password" required = "true"/></td>
                </tr>
                <tr>
                    <td>Company Name :</td>
                    <td><form:input path="name" type = "text" required = "true"/></td>
                </tr>
                <tr>
                    <td>Company Web Address :</td>
                    <td><form:input path="webAddress" type = "text" required = "true"/></td>
                </tr>
                <tr>
                    <td>Company Address :</td>
                    <td><form:input path="address" type = "text" required = "true"/></td>
                </tr>

                <tr>
                    <td>Company City :</td>
                    <td>
                    <form:select path="cityId">
                        <c:forEach var="city" items="${city}">
                           <form:option value="${city.cityId}" label="${city.cityName}"/>
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