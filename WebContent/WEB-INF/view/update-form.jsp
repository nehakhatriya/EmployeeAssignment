<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<head>
	<title>Edit Employee</title>
	<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
<style>
.text {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>	
</head>

<body>
<div class="container">
<h1>Employee Form</h1>
	<form:form action="update" method="post" modelAttribute="employee">
    Employee ID : <form:input path="empID" cssClass="text"/>
    <form:errors path="empID" cssClass="error" />
		<br>
		<br>
    Name: <form:input path="Name" cssClass="text" />
    <form:errors path="Name" cssClass="error" />
		<br>
		<br>
<button type="submit" class="btn btn-success">SAVE</button>
</form:form>

</div>
</body>
</html>









