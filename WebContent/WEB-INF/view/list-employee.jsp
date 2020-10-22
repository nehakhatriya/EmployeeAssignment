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
<strong>Welcome, <sec:authentication property="principal.username"/></strong>
<br><br>
<sec:authorize access="hasRole('USER')">
<input type="button" style="float:left;" class="btn btn-info" value="Add Employee" onclick="window.location.href='${pageContext.request.contextPath}/app/employee/addEmployee';return false ;"
		 /> 
</sec:authorize>

   <form:form method="POST" action="${pageContext.request.contextPath}/logout">
<input type="submit" style="float:right" class="btn btn-info" value="Logout"/>
</form:form>
<br><br>
<h4 style="text-align: center;">Employees Registered</h4>

		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col"><a href="${pageContext.request.contextPath}/app/employee/list?sort=id">ID</a></th>
					<th scope="col"><a href="${pageContext.request.contextPath}/app/employee/list?sort=name">Name</a></th>
					<sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
                            <th width="100"></th>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ADMIN')">
                            <th width="100"></th>
                        </sec:authorize>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="temp" items="${employees}">
					<tr>
						<td scope="row">${temp.empID}</td>
						<td>${temp.name}</td>
						<sec:authorize access="hasRole('ADMIN')">
						<td><a
							href="${pageContext.request.contextPath}/app/employee/delete?empid=${temp.empID}">Delete</a></td>
						</sec:authorize>
						<sec:authorize access="hasRole('ADMIN')">
						<td><a
							href="${pageContext.request.contextPath}/app/employee/update?empid=${temp.empID}">Edit</a></td>
						</sec:authorize>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</div>
</body>		
</html>