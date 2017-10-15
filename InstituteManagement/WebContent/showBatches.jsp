<%@page import="com.akhil.institutemanagement.dto.BatchDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.akhil.institutemanagement.dao.batchDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.akhil.institutemanagement.common.driverDetails" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%if(request.getSession(false)!=null)
    	
    	
    	{%>
    
    
 <%

batchDAO b=new batchDAO();
 
ArrayList<BatchDTO> arr= b.getBatches();


String art[]={" Batch name "," Instructor name "," Batch From "," Batch To "," Days "," Number Of Students "," Batch Performance "," Batch Code "};  
String ari[]={".getBatchName()",".getinstructorName()",".getbatchTimingsFrom()",".getBatchTimingsTo()",".getBatchDays()",".getNumberOfStudents()",".getBatchPerformance()",
		".getBatchCode()"};

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">

/* window.addEventListener("load",function()
		{
	alert("hello");
	
	

		});
 */		
		/* function make(event)     not able to use this
		{
			alert("h"+event.srcElement);
			
		}
		 */
		
	
		 window.addEventListener("load",bind);
		 
		 function bind()
		 {
			 
			 
			 var btn=document.getElementsByName("editButton");
			    
			    Array.prototype.forEach.call(btn,function(b)
			                                {
			        b.addEventListener("click",function(event)
			                          {
			        	
			                          var id=event.srcElement.id;
			           // alert("jki"+event);
			            //alert(event.srcElement.id);
			            document.getElementById("hiddenInput").value= id;
			            console.log(document.getElementById("hiddenInput").value);
			           //location.href="editBatches.jsp";
			     
			           document.getElementById("form1").submit();
			           
			                          });
			    });
		 }
		 
		
</script>

</head>
<body>
<%@include file="dashboard.jsp" %>

  


<h1 style="margin-left: 40%" >Present Batches</h1>

<div class="editBatches">

<form method="post" action="editBatches.jsp" id="form1">

<input type="hidden" name="hiddenBatchCode" id="hiddenInput">
<table border="2px">
<tr>

<% for(int i=0;i<8;i++)
	{
	%>
	<td>
	<%out.println(art[i]); %>
	</td>
<%} %>
</tr>


<% 
int i=0;
for(BatchDTO bt:arr)
	{%>
	<tr>
	<td>
	<% out.println(bt.getBatchName()); %>
	</td>
	
<td><% out.println(bt.getInstructorName());%>
	</td>
	
	<td><%out.println(bt.getBatchTimingsFrom()); %>
	</td>
	
	<td><%out.println(bt.getBatchTimingsTo()); %>
	</td>
	
	<td><%out.println(bt.getBatchDays()); %>
	</td>
	
	<td><%out.println(bt.getNumberOfStudents()); %>
	</td>
	
	<td><% out.println(bt.getBatchPerformance());%>
	</td>
	
	<td><%out.println(bt.getBatchCode()); %>
	</td>
	
	<td>
	<button name="editButton" class="btn btn-primary" type="button" id="<%= bt.getBatchCode()%>">EDIT</button>
	</td>
	
</tr>
<%i++;} %>

</table>
<!-- <button type="submit" class="btn btn-primary">Edit</button> -->  
</form>
</div>
</body>
</html>

<%} %>
