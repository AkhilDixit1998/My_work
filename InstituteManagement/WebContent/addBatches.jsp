<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%if(request.getSession(false)!=null)
    	
    	
    	{%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="dashboard.jsp" %>

<div class="addBatches" >
       
       <h1>Create New Batch</h1>
       <div>
           <form action="addBatchesServlet" method="get">
               <table>
                   
                   <tr>
                       <td><label class="label-primary">Batch code</label></td>
                       <td><input type="text" name="batch_code" class="form-control"></td>
                       
                   </tr>
                   
                   <tr>
                       <td><label class="label-primary">Course/Batch Name</label></td>
                       <td><input type="text" name="batch_name" class="form-control"></td>
                       
                   </tr>
                    <tr>
                       <td><label class="label-default">Instructor's Name</label></td>
                       <td><input type="text" name="instructor_name" class="form-control"></td>
                       
                   </tr>
                    <tr>
                    <td>  <label>Timings</label></td>
                       <td><label>from</label></td>
                       <td><input type="datetime-local" name="batch_timings_from" class="form-control"></td>
                        
                        <td><label>to</label></td>
                       <td><input type="datetime-local" name="batch_timings_to" class="form-control"></td>
                      
                   </tr>
               </table>
               
               <div>
                 <label>WeekDays</label>  <input type="radio" name="batchDays" value="weekDay"> &nbsp;&nbsp;&nbsp;&nbsp;  <label>WeekEnds</label>  <input type="radio" name="batchDays"value="weekEnd">
                    
               </div>
               
               
               <button type="submit" class="btn btn-success">Create New Batch</button>
           </form>
       </div>
       
   </div>
   
   

</body>
</html>
<%}%>