<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books Available</title>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Books</title>
	<link href="css/bootstrap.css"      rel="stylesheet">
	<link href="css/custom.css"      rel="stylesheet">
	<link href="css/main.css"      rel="stylesheet">
</head>
<body>

   <h1 align="center">Books List</h1>
<table id="t02"  cellpadding="2">
<tr>

<th>
<a  href="/bookform"><h2>Add more books</h2></a>
</th>

<th>
<a  align ="right" href="/delete"><h2>Delete All Books</h2></a>
</th>

</tr>

</table>





<table >
<tr>


  <th>Page No : 
<c:forEach var="count" items="${pageCount}"  varStatus="theCount"> 
<a align="right" href="/viewbooks/${theCount.count}">${theCount.count}</a>   
</c:forEach>  
</th>

</tr>

</table>
   
<form:form  class="form-horizontal" >
<table id="t01" border="2" width="70%" cellpadding="2">
<tr><th>Name</th><th>ISBN Number</th>
<th>Publish date</th><th>price</th>
<th>Book Type</th>
<th>Edit</th><th>Delete</th></tr>  

   <c:forEach var="book" items="${books}"> 
   <tr>  
 
   <td>${book.name}</td> 
   <td>${book.isbnNumber}</td>  
   <td>${book.publishDate}</td> 
   <td>${book.price}</td>  
   <td>${book.book_type}</td>  
   <td><a href="/editbook/${book.id}">Edit</a></td>  
   <td><a href="/deletebook/${book.id}">Delete</a></td>  
   </tr>  
   </c:forEach> 
   
   
   </table>  
   <br/>
   
  
   </form:form>



</body>
</html>