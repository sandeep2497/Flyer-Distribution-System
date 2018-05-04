<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Client</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <style>
            body {
                background: 	#FFFFFF;
                color: black;
                font: 87.5%/1.5em 'Open Sans', sans-serif;
                margin: 0;}
         a{
             color:	#4682B4;
         }
         table{
             font-size: 15px;
         }
         div{
             margin-bottom: 120px;
         }
         
         
        </style>
    </head>
    <body>
         <%@include file="nav.jsp" %>
       
        <br/>
        <div>
        <div class="container">
        <center>
            
            <form action="updateLocation" method="post" name="registerForm">
                <table class="table table-striped">
                    <caption>Add Location</caption>
                     <input type="hidden" name="id" id="userId" value="${user.id}"/>
                    <tr>
                        <th>Location Name:</th>
                        <td><input type="text" class="form-control" name="name" id="firstname" value="${user.locationName}"></td>
                    </tr>
                    <tr>
                        <th>Capacity:</th>
                        <td><input <input type="text" class="form-control" name="quantity" id="lastname" value="${user.distributionCapacity}"></td>
                    </tr>
                        <td colspan="2" align="center"><input type="submit" class="btn btn-primary" name="submit" value="Save"></td>
                    </tr>
                </table>
                
                    
                
            </form>
        </center>
        </div>
                    </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
