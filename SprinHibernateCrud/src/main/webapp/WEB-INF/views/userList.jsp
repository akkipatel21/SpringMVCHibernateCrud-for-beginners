<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
	<table  border="1"  class="table table-striped">
		<thead>
			<th>ID</th>
			<th>UserName</th>
			<th>PassWord</th>
			<th>Action</th>
		</thead>
<tbody><c:forEach items="${result}" var="a" >
		<tr>
			<td>${a.id}</td>
			<td>${a.username}</td>
			<td>${a.password}</td>
			<td><a href="editUser?id=${a.id }">EDIT</a></td>
			         <%--  <form action="editEmployee" method="get">
			         <input type="hidden" name="id" value="${a.id}">
			         <input type="submit" name="submit" value="Edit">
			                 </form>  --%>
		  <td><a href="deleteUser?id=${a.id}&username=${a.username}">Delete</a></td>
					 <%--  <form action="deleteUser" method="get">
					 	 <input type="hidden" name="id" value="${a.id}">
					  	<input type="submit" name="submit" value="Delete">
					  </form> --%>
		</tr>
		</c:forEach>
</tbody>
	</table></center>
</body>
</html>