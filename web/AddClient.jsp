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
            
            <form action="new" method="post" name="registerForm">
                <table class="table table-striped">
                    <caption>Add Client</caption>
                    <tr>
                        <th>First Name:</th><td><input type="text" class="form-control" name="firstname" id="firstname" required></td>
                    </tr>
                    <tr>
                        <th>Last Name:</th><td><input type="text" class="form-control" name="lastname" id="lastname" required></td>
                    </tr>
                    <tr>
                        <th>Street Number:</th><td><input type="number" class="form-control" name="Streetnum" id="streetnum" required></td>
                    </tr>
                    <tr>
                        <th>Street Name:</th><td><input type="text" class="form-control" name="Streetname" id="Streetname" required></td>
                    </tr>
                    <tr>
                        <th>City:</th><td><input type="text" class="form-control" name="city" id="city" required></td>
                    </tr>
                    <tr>
                        <th>Province:</th>
                        <!--<td><input type="text" class="form-control" name="province" id="province" required></td>-->
                        <td><select class="form-control" name="province" id="province" required>
                            <option>---Select Province---</option>
                            <option>Alberta</option>
                            <option>British Columbia</option>
                            <option>Manitoba</option>
                            <option>New Brunswick</option>
                            <option>Newfoundlan</option>
                            <option>Nova Scotia</option>
                             <option>Nunavut</option>
                             <option>Ontario</option>
                             <option>Prince Edward Island</option>
                             <option>Quebec</option>
                             <option>Saskatchewan</option>
                             <option>Yukon</option>
                            </select></td>
                    </tr>
                    <tr>
                        <th>Postal Code: </th><td><input type="text" class="form-control"  name="postalcode" id="postalcode" required></td>
                    </tr>
                    <tr>
                        <th>Tel Office: </th><td><input type="text" pattern="^\d{10}$" placeholder="Format:XXXXXXXXXX" class="form-control" name="telO" id="telO" required></td>
                    </tr>
                    <tr>
                        <th> Tel Cell:</th><td><input type="text"  pattern="^\d{10}$" placeholder="Format:XXXXXXXXXX" class="form-control" name="telC" id="telC" required></td>
                    </tr>
                    <tr>
                        <th> Email:</th><td><input type="email" class="form-control" name="email" id="email" required></td>
                    </tr>
                    <tr>
                        <th>Company Name:</th><td><input type="text" class="form-control" name="companyname" id="companyname" required></td>
                    </tr>
                    <tr>
                        <th>Company Type:</th><td><input type="text" class="form-control" name="type" id="type" required> </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" class="btn btn-primary" name="submit" value="Save"></td>
                    </tr>
                </table>
            </form>
        </center>
        </div>
         <%@include file="footer.jsp" %>
    </body>
</html>
