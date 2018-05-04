<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Location"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Locations</title>
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
       
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

          <style>
            body {
                background: 	#FFFFFF;
                color: black;
                font: 87.5%/1.5em 'Open Sans', sans-serif;
                left:-10px;
                
              }
              table{
                  width: 100%;
                 font-size: 20px;
              }
         a{
x`             color:	#4682B4;
         }
         h1{
             font-size: 20px;             
         }
         .co{
             width: 40%;
             text-align: left;
             margin-left: 28%;
             margin-bottom: 100px;
             
         }
         div{
             margin-bottom: 50px;
         }
         
       </style>
    </head>
      <body>
          
       <%@include file="nav.jsp" %>
         
       <div>
            <div class="container">
            <div class="co">
          <h1>List of Locations</h1>
          <table cellpadding="10" class="table table-hover">
             
                <thead>
                    <th>Id</th>
                    <th>Location</th>
                    <th>Capacity</th>
                    <th>Action</th>
                   </thead>
                <tbody>
            <c:forEach var="location" items="${locList}">
                    <tr>
                        <td><c:out value="${location.id}"/></td>
                        <td><c:out value="${location.getLocationName()}"/></td>
                        <td><c:out value="${location.getDistributionCapacity()}"/></td>
                        <td><a href="editLocation?id=<c:out value='${location.id}'/>">
                                    Edit
                                </a>
                                    &nbsp;&nbsp;&nbsp;
                                <a href="deleteLoc?id=<c:out value='${location.id}'/>">
                                    Delete
                                </a>
                            </td>
                           
                            </tr>
                </c:forEach>
                </tbody>
                
            </table>
            </div>
                <center>
                    <h1>${message1}</h1> <br/><br/>
               <a href="AddLocation.jsp"><input type="submit" class="btn btn-primary" value="Add New Location" name="update" /></a>

           </center>
                </div>
            
    <h3 style="color:purple"><c:out value="${messageResult}"/></h3>
     
      </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
