<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<h1 style="color:red;text-align:center">Employee Edit Operations page</h1>

<frm:form modelAttribute="emp">
<table align="center" bgcolor="yellow">
<tr>
   <td>emp no ::</td>
   <td><frm:input path="empno" readonly="true" cssStyle="background-color:gray"/></td>
</tr>
<tr>
   <td>emp name ::</td>
   <td><frm:input path="ename"/></td>
</tr>
<tr>
   <td>emp job ::</td>
   <td><frm:input path="job"/></td>
</tr>
<tr>
   <td>emp salary ::</td>
   <td><frm:input path="sal"/></td>
</tr>
<tr>
   <td>emp deptno ::</td>
   <td><frm:input path="deptno"/></td>
</tr>

<tr>
   <td><input type="submit" value="Edit Employee"> </td>
   <td><input type="reset" value="cancel"></td>
</tr>

</table>


</frm:form>