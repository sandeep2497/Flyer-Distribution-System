
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Agent"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Marketing Agent</title>
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
            <style>
            body {
                background: 	#FFFFFF;
                color: black;
                font: 87.5%/1.5em 'Open Sans', sans-serif;
                margin: 0;
                
              }
              table {
                  font-size: 20px;
              }
           
         a{
             color:	#4682B4;
         }
         h1{
             font-size: 25px;             
         }
         div{
             margin: 35px;
             margin-bottom: 100px;
         }
       </style>
    </head>
    <body>
        <%@include file="nav.jsp" %>
        
       
            <div class="container">
          <table cellpadding="5" class="table table-hover">
              <h1>Agents</h1>
                <thead>
                   
                    <th>Name</th>
                    <th>Phone Number</th>
                    <th>Email</th>
                    <th>UserName</th>
                    <th>Password</th>
                    <th>Action</th>
                  
                   </thead>
                <tbody>
            <c:forEach var="userlist" items="${userlist}">
                    <tr>
                       
                        <td><c:out value="${userlist.fname}"/> <c:out value="${userlist.lname}"/></td>
                       
                        <td><c:out value="${userlist.phoneNo}"/></td>
                        <td><c:out value="${userlist.getEmail()}"/></td>
                        <td><c:out value="${userlist.userName}"/></td>
                        <td><c:out value="${userlist.password}"/></td>
                        <td><a href="editAgent?id=<c:out value='${userlist.id}'/>">
                                    Edit
                                </a>
                                    &nbsp;&nbsp;&nbsp;
                                <a href="deleteAgent?id=<c:out value='${userlist.id}'/>">
                                    Delete
                                </a>
                            </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
                <center>
                    
               <a href="AddAgent.jsp"><input type="submit" class="btn btn-primary" value="Add New Agent" name="update" /></a>

           </center>
            
    <h3 style="color:purple"><c:out value="${messageResult}"/></h3>
            </div>  
     
        <%@include file="footer.jsp" %>
    </body>
</html>
