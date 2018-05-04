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
         
         
        </style>
    </head>
    <body>
         <%@include file="nav.jsp" %>
       
        <br/>
        <div class="container">
        <center>
            
            <form action="newAgent" method="post" name="registerForm">
                <table class="table table-striped">
                    <caption>Add Agent and a UserName</caption>
                    <tr>
                        <th>First Name:</th><td><input type="text" class="form-control" name="firstname" id="firstname" required></td>
                    </tr>
                    <tr>
                        <th>Last Name:</th><td><input <input type="text" class="form-control" name="lastname" id="lastname" required></td>
                    </tr>
                    <tr>
                        <th>Phone Number:</th><td><input <input type="text" pattern="^\d{10}$" placeholder="Format:XXXXXXXXXX" class="form-control" name="phone" id="lastname" required></td>
                    </tr>
                    <tr>
                        <th>Email:</th><td><input <input type="email" class="form-control" name="email" id="lastname" required></td>
                    </tr>
                    <tr>
                        <th>User Name:</th><td><input <input type="text" class="form-control" name="username" id="lastname" required></td>
                    </tr>
                    <tr>
                        <th>Password:</th><td><input <input type="text" class="form-control" name="password" id="lastname" required></td>
                    </tr>
                        <td colspan="2" align="center"><input type="submit" class="btn btn-primary" name="submit" value="Save"></td>
                    </tr>
                </table>
                
            </form>
        </center>
        </div>
         <%@include file="footer.jsp" %>
    </body>
</html>
