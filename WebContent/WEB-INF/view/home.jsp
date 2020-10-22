<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
</head>
<body>

<div class="container" style="width:90%">
<br>
    <form:form method="POST" action="${pageContext.request.contextPath}/app/employee/login">
<input type="submit" class="btn btn-info" value="login"/>
</form:form>

<h4 style="text-align: center;">Employees Registered</h4>

		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col"><a href="${pageContext.request.contextPath}/app/employee?sort=id">ID</a></th>
					<th scope="col"><a href="${pageContext.request.contextPath}/app/employee?sort=name">Name</a></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="temp" items="${employees}">
					<tr>
						<td scope="row">${temp.empID}</td>
						<td>${temp.name}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</div>
</body>		
</html>