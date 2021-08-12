<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New University Department</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>
<div class="row">
    <div class="col-md-2">
        <jsp:include page="../_Layout.jsp"></jsp:include>
    </div>
    <div class="col-md-10">
        <form:form action="save" method="post" modelAttribute="uniDepartment" cssStyle="margin: 50px">
            <table  border="0" cellpadding="5">
                <tr>
                    <td>Name:</td>
                    <td><form:input path="universityDepartmentName" type = "text" required = "true"/></td>
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