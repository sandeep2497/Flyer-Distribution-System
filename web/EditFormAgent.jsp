<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit User Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

       <style>
            body {
                background:#FFFFFF;
                color: black;
                font: 87.5%/1.5em 'Open Sans', sans-serif;
                margin: 0;
              }
              body > h2{
                  font-family:monospace;
              }
              table{
                  font-size: 20px;
              }
           
         
         a{
             color:	#4682B4;
         }
         h1{
             font-size: 25px;             
         }
        </style>
    </head>
    <body>
         <%@include file="nav.jsp" %>
         <div class="container">
        <center>
            <form action="updateAgent" method="post" name="editForm">
                <input type="hidden" name="id" id="userId" value="${agent.id}"/>
                <table  class="table table-striped">
                    <caption>Edit Client</caption><br/><br/>
                    <tr>
                        <th>First Name</th>
                        <td><input type="text" class="form-control" name="name" id="name" value="${agent.fname}"</td>
                    </tr>
                    <tr>
                        <th>Last Name</th>
                        <td><input type="text" class="form-control" name="lastname" id="lastname" value="${agent.lname}"</td>
                    </tr>
                    <tr>
                        <th>Phone Number</th>
                        <td><input type="text" class="form-control" pattern="^\d{10}$" placeholder="Format: XXXXXXXXXX" name="phone" id="phone" value="${agent.phoneNo}"</td>
                    </tr>
                    <tr>
                        <th>Email</th>
                        <td><input type="email" class="form-control" name="email" id="email" value="${agent.email}"</td>
                    </tr>
                    
                    
                    <td colspan="2" align="center">
                            <input type="submit" class="btn btn-primary" value="Update" name="update" />
                        </td>
                </table>
            </form>
        </center>
</div>
  <%@include file="footer.jsp" %>
    </body>
</html>
