<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="dashboard.jsp"></jsp:include>


<div class="addBatches" >
       
       <h1>Add New Student</h1>
       <div>
           <form action="addStudent" method="post">
               <table>
                   
                   <tr>
                       <td><label class="label-primary">Batch Code</label></td>
                       <td><input type="text" name="batch_code" class="form-control"></td>
                       
                   </tr>
                   
                   <tr>
                       <td><label class="label-primary">Student Name</label></td>
                       <td><input type="text" name="student_name" class="form-control"></td>
                       
                   </tr>
                    <tr>
                       <td><label class="label-default">Fees Given</label></td>
                       <td><input type="text" name="fees_given" class="form-control"></td>
                       
                   </tr>
                    
               </table>
           
               <button type="submit" class="btn btn-success">Add Student</button>
           </form>
       </div>
       
   </div>


</body>
</html>