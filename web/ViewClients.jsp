<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Client"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
        <script src="script.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <title>View Users</title>
        <style>
            body {
                background: 	#FFFFFF;
                color: black;
                font: 87.5%/1.5em 'Open Sans', sans-serif;
               
                left:-10px;
                
              }
              table{
                  width: 100%;
                  font-size: 15px;
                  
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
         .error{
             font-size: 15px;
             color:red;
         }
         
       </style>
    </head>
    <body>

 <%@include file="nav.jsp" %>
        <br/>
        
            <div class="container">
                <h1>List of Clients</h1>
                <table cellpadding="10" class="table table-hover">
                    <thead>
                        
                        
                        <th>Name</th>
                        <th>Address</th>
                        <th>City</th>
                        <th>Province</th>
                        <th>Postal Code</th>
                        <th>Tel Office</th>
                        <th>Tel Cell</th>
                        <th>Email</th>
                        <th>Company</th>
                        <th>Company Type</th>
                        <th>Agent</th>
                        <!--will only display if you are admin-->
                         <c:set var = "role" value="${sessionScope.role}"/>
                         <c:if test = "${role == 1}">
                                <th>Action</th>
                         </c:if>
                        
                        
                    </thead>
                    <tbody>
                    <c:forEach var="user" items="${userList}">
                        <tr>
                            
                            
                            <td><c:out value="${user.name}"/> <c:out value="${user.lastname}"/></td>
                            
                            <td><c:out value="${user.streetnumber}"/> <c:out value="${user.streetName}"/></td>
                        
                            <td><c:out value="${user.city}"/></td>
                            <td><c:out value="${user.province}"/></td>
                            <td><c:out value="${user.postalcode}"/></td>
                            <td><c:out value="${user.teloffice}"/></td>
                            <td><c:out value="${user.telcell}"/></td>
                            <td><c:out value="${user.email}"/></td>
                            <td><c:out value="${user.company}"/></td>
                            <td><c:out value="${user.companytype}"/></td>  
                            <td><c:out value="${user.getAgentname()}"/></td>
                            
                           <!--will only display if youre an admin-->
                            <c:if test = "${role == 1}">
                               <td><a href="edit?id=<c:out value='${user.userId}'/>">
                                        Edit
                                    </a>
                                        &nbsp;&nbsp;&nbsp;
                                    <a href="delete?id=<c:out value='${user.userId}'/>">
                                        Delete
                                    </a>
                                </td>
                            </c:if>
                            
                          
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
             <center>
                
            <a href="new"><input type="submit" class="btn btn-primary" value="Add New Client" name="update" /></a>
            <br/>
            <h2 class="error"> ${messageUser}</h2>
             </center>
     <%@include file="footer.jsp" %>
    </body>
</html>
