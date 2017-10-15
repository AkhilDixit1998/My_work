<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="dashboard.jsp"></jsp:include>


<div class="editBatches">
<table border=1>



<a:forEach items="${studentArrayList}" var="arr">

<tr>

<td>
${arr.batchCode}
</td>
<td>${arr.studentName }</td>
<td>${arr.feesGiven }</td>


</tr>
</a:forEach>



</table>
</div>

</body>
</html>