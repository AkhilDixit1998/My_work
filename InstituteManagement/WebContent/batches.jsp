<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%if(request.getSession(false)!=null)
    	
    	
    	{%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Batches</title>
</head>
<body>
<%@include file="dashboard.jsp" %>

<div class="batches">
   
   <button class="btn btn-success"><a href="addBatches.jsp">Add Batches</a></button>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   <button class="btn btn-primary"><a href="showBatches.jsp">Edit Batches</a></button>
   
  </div>

</body>
</html>
<%}%>