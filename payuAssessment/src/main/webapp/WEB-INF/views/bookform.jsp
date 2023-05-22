<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book registration</title>

   <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Book Form</title>
	<link href="css/bootstrap.css"      rel="stylesheet">
	<link href="css/custom.css"      rel="stylesheet">
	<link href="css/main.css"      rel="stylesheet">
</head>
<body>

      <div class="form-container">
 	
 	<h1>Book registration form</h1>
 	
	<form:form method="POST" modelAttribute="book" commandName="book" class="form-horizontal" action="save">
	

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="name">Name</label>
				<div class="col-md-7">
					<form:input type="text" path="name" id="name" class="form-control input-sm"/>
				</div>
			</div>
		</div>
		
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="isbnNumber">ISBN number</label>
				<div class="col-md-7">
					<form:input type="text" path="isbnNumber" id="name" class="form-control input-sm"/>
				</div>
			</div>
		</div>
		
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="publishDate">Publish Date</label>
				<div class="col-md-7">
					<form:input type="text" path="publishDate" id="publishDate" class="form-control input-sm"/>(dd/MM/yyyy)
					
				</div>
			</div>
		</div>
		
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="price">Book price</label>
				<div class="col-md-7">
					<form:input type="text" path="price" id="price" class="form-control input-sm"/>
					
				</div>
			</div>
		</div>
		
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="book_type">Book Type</label>
				<div class="col-md-7">
					<form:select path="book_type" id="book_type" class="form-control input-sm">
				        <form:option value="">Select Book type</form:option>
			    	    <form:options items="${book_type}" />
				    </form:select>
				</div>
			</div>
		</div>
		
		
		<div class="row">
			<div class="form-actions floatRight">
				<input type="submit" value="Register" class="btn btn-primary btn-sm">
			</div>
		</div>
		
		
		
		</form:form>
	</div>

</body>
</html>