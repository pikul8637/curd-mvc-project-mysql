<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
<c:when test="${!empty empList}">
<table border="1" bgcolor="green" align="center">
<tr>
<th>empno</th><th>emp name</th><th>emp job</th><th>emp salary</th><th>deptno</th><th>operations</th>
</tr>

<c:forEach var="emp" items="${empList}">
<tr>
<td>${emp.empno}</td>
<td>${emp.ename}</td>
<td>${emp.job}</td>
<td>${emp.sal}</td>
<td>${emp.deptno}</td>
<td><a href="edit?no=${emp.empno}"><img  src="images/edit.png" height="30px" width="30px">&nbsp;&nbsp;&nbsp;</a>
         <a href="delete?no=${emp.empno}" onclick="return confirm('are you sure to delete???')"><img  src="images/delete.png" height="30px" width="30px"></a>
</td>
</tr>
</c:forEach>

</table>
</c:when>
<c:otherwise>
<h1 style="color:red;text:align:center">Records not found</h1>
</c:otherwise>

</c:choose>
<br><br><br><br>

<h2 style="color:green;text-align:center">${resultMsg}</h2>

<center><a href="register">Register Employee<br><br><image src="images/add.png" width="100px"height="100px"></image></a></center>

<br>


<center><a href="./">home<br><br><image src="images/home.jpg" width="100px"height="100px"></image></a></center>
