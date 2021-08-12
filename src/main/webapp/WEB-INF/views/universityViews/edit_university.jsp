<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit University</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<div class="row">
  <div class="col-md-2">
    <jsp:include page="../_Layout.jsp"></jsp:include>
  </div>
  <div class="col-md-10">
    <form:form action="save" method="post" modelAttribute="uni" cssStyle="margin-top: 50px">

      <table border="0" cellpadding="5">
        <tr>
          <td>ID: </td>
          <td>${uni.universityId}
            <form:hidden path="universityId" />
          </td>
        </tr>

        <tr>
          <td>Name:
          <td><form:input path="universityName"   /></td>
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
