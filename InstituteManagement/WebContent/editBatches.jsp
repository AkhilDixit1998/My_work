
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.akhil.institutemanagement.dao.batchDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%if(request.getSession(false)!=null)
    	
    	
    	{%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">

function pageRedirect(variable)
{
	var form=document.getElementById("myForm");
	var hiddenField=document.getElementById("hidden-field");
	hiddenField.value=document.getElementById("batch-code").value;
	if(variable=="submit")
		{
		form.action="editBatch";
		form.submit();
		/* alert("in submit"); */
		}
	else
		if(variable=="delete")
			{
			
			form.action="deleteBatches";
			form.submit();
			
		/* 	alert("In delete"); */
			}
	
	
	}

</script>


</head>
<body>
<%@include file="dashboard.jsp" %>


<%
String batchName="";
String instructorName="";
String batchTimingsFrom="";
String batchTimingsTo="";
String batchDays="";
String numberOfStudents="";
String batchPerformance="";
String batchCode=request.getParameter("hiddenBatchCode");
out.println(request.getParameter("hiddenBatchCode"));
batchDAO bd=new batchDAO();
Connection connection=bd.myConnection();
String sql="select * from batches where batchCode=?";
PreparedStatement pstmt=connection.prepareStatement(sql);
pstmt.setString(1,batchCode);
ResultSet rs=pstmt.executeQuery();


while(rs.next())
{
	batchName=rs.getString(1);
	instructorName=rs.getString(2);
	batchTimingsFrom=rs.getString(3);
	batchTimingsTo=rs.getString(4);
	batchDays=rs.getString(5);
	numberOfStudents=rs.getString(6);
	batchPerformance=rs.getString(7);
	batchCode=rs.getString(8);
}
%>

 <div class="editBatches" >
       
       <h1>Edit Batches</h1>
       <div>
           <form id="myForm" method="post">
           
           <input type="hidden" id="hidden-field" name="hidden-batch-code">
               <table>
                   
                    <tr>
                       <td><label class="label-primary">Batch code</label></td>
                       <td><input type="text" name="batch_code" class="form-control" id="batch-code" value='<%= batchCode%>'></td>
                       
                   </tr>
                   
                   <tr>
                       <td><label class="label-primary">Course/Batch Name</label></td>
                       <td><input type="text" name="batch_name" class="form-control" value='<%= batchName%>'></td>
                       
                   </tr>
                    <tr>
                       <td><label class="label-default">Instructor's Name</label></td>
                       <td><input type="text" name="instructor_name" class="form-control" value='<%= instructorName%>'></td>
                       
                   </tr>
                    <tr>
                    <td>  <label>Timings</label></td>
                       <td><label>from</label></td>
                       <td><input type="datetime-local" name="batch_timings" class="form-control" value='<%= batchTimingsFrom%>' ></td>
                        
                        <td><label>to</label></td>
                       <td><input type="datetime-local" name="batch_timings" class="form-control" value='<%= batchTimingsTo%>'></td>
                       
                   </tr>
               </table>
               
               <div>
                 <label>WeekDays</label>  <input type="radio" value="weekDay" name="batchDays" <% if(batchDays=="weekDay")
                 { System.out.println("In if"); %> checked="checked" <%} %> > &nbsp;&nbsp;&nbsp;&nbsp;  <label>WeekEnds</label>  <input type="radio" value="weekEnd" name="batchDays" <%if(batchDays=="weekEnd"){ %> checked="checked"<%} %>> 
                   
               </div>
               
               <div>
                   <textarea name="batch_performance" class="form-control" placeholder="Enter performance" value='<%= batchPerformance%>'></textarea>
               </div>
               <div>
                   <input type="number" name="student_strength" class="btn-block" value='<%= numberOfStudents%>'>
               </div>
               
               <!-- <button type="submit" class="btn btn-success">Submit Data</button>
               <button type="reset" class="btn btn-success">Reset Data</button>
               <button type="button" class="btn btn-danger" onclick="deleteFn()" >Delete Batch</button> -->
               
               <button type="button" class="btn btn-success" value="submit" onclick="pageRedirect(this.value)">Submit Data</button>
               <button type="reset" class="btn btn-success">Reset Data</button>
               <button type="button" class="btn btn-danger" onclick="pageRedirect(this.value)" value="delete" >Delete Batch</button>
           </form>
       </div>
       
   </div>

</body>
</html>
<%} %>
