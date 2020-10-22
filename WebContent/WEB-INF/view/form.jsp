<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
<style>
.error {
	color: red;
}
</style>
<title>Employee</title>
</head>

<body>
<div class="container">
<div class="card" style="width:50%;top: 50px;">
    <h5 class="card-header info-color white-text text-center py-4">
        <strong>Add New Employee</strong>
    </h5>
        <div class="card-body px-lg-5">
        <form:form  action="${pageContext.request.contextPath}/app/employee" method="post" modelAttribute="employee" class="text-center" style="color: #757575;">
            <div class="md-form mt-3">
                <label for="id"><strong>ID</strong> </label>
                <form:input type="text" id="id" path="empID" class="form-control"/>
            </div>
            <div class="md-form">
                <label for="name"><strong>Name</strong></label>
                <form:input type="text" id="name" path="Name" class="form-control"/>
            </div>
            <button class="btn btn-outline-info btn-rounded btn-block z-depth-0 my-4 waves-effect" type="submit">Add Employee</button>
        </form:form>
    </div>
</div>
</div>
</body>
</html>