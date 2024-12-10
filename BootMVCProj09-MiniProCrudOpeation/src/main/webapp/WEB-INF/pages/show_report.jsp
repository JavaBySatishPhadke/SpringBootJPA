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
			</tr>
			<c:forEach var="emp" items="${empList}">
				<tr>
					<td>${emp.empno}</td>
					<td>${emp.ename}</td>
					<td>${emp.job}</td>
					<td>${emp.sal}</td>
					<td>${emp.deptno}</td>
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


<center>
	<a href="./">Home<img src="images/home.jpg" /></a>
</center>