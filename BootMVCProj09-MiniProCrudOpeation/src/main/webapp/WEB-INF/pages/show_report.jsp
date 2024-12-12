<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--<h1>Response Data: <%= request.getAttribute("ename") %></h1>-->

<c:choose>

	<c:when test="${!empty empList}">
		<table align="center" border="1" bgcolor="yellow">

			<tr bgcolor="cyan">
				<th>empno</th>
				<th>ename</th>
				<th>job</th>
				<th>sal</th>
				<th>deptno</th>
				<th>operation</th>
			</tr>
			<c:forEach var="emp" items="${empList}">
				<tr>
					<td>${emp.empno}</td>
					<td>${emp.ename}</td>
					<td>${emp.job}</td>
					<td>${emp.sal}</td>
					<td>${emp.deptno}</td>
					<td><a href="edit?no=${emp.empno}"><img src="images/edit.jpg", width="30px", height="40p"> </a>
					&nbsp;&nbsp; <a onclick="return confirm('Are you sure delete?')"  href="delete?no=${emp.empno}"><img src="images/delete.jpg" width="30px", height="40p"> </td>
				</tr>

			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<h1 style="color: red; text-align: center">No Data Found</h1>
	</c:otherwise>
</c:choose>
<br>
<br>

<h1 style="color: red; text-align: center">${resultMsg}</h1>

<br>
<br>
<center><a href="register">Add Employee<img src="images/add.jpg" width="30px", height="40p" /></a></center>
<br>
<br>
<center>
	<a href="./">Home<img src="images/home.jpg", width="100px", height="100px
	" /></a>
</center>