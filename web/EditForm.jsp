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
            <form action="update" method="post" name="editForm">
                <input type="hidden" name="id" id="userId" value="${user.userId}"/>
                <table  class="table table-striped">
                    <caption>Edit Client</caption><br/><br/>
                    <tr>
                        <th>First Name</th>
                        <td><input type="text" class="form-control" name="name" id="name" value="${user.name}"</td>
                    </tr>
                    <tr>
                        <th>Last Name</th>
                        <td><input type="text" class="form-control" name="lastname" id="lastname" value="${user.lastname}"</td>
                    </tr>
                    <tr>
                        <th>Street Number</th>
                        <td><input type="number" class="form-control" name="streetnumber" id="streetnumber" value="${user.streetnumber}"</td>
                    </tr>
                    <tr>
                        <th>Street Name</th>
                        <td><input type="text" class="form-control" name="streetname" id="streetname" value="${user.streetName}"</td>
                    </tr>
                    <tr>
                        <th>City</th>
                        <td><input type="text" class="form-control" name="city" id="city" value="${user.city}"</td>
                    </tr>
                    <tr>
                        <th>Province</th>
                        <td>
                            <!--<input type="text" class="form-control" name="province" id="province" value="${user.province}"</td>-->
                            <select class="form-control" name="province" id="province" required>
                            <option>${user.province}</option>
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
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Postal Code</th>
                        <td><input type="text" class="form-control" name="postalcode" id="postalcode" value="${user.postalcode}"</td>
                    </tr>
                    <tr>
                        <th>Tell Office</th>
                        <td><input type="text" class="form-control" pattern="^\d{10}$" placeholder="Format: XXXXXXXXXX" name="telO" id="telO" value="${user.teloffice}"</td>
                    </tr>
                    <tr>
                        <th>Tel Cell</th>
                        <td><input type="text" class="form-control" pattern="^\d{10}$" placeholder="Format: XXXXXXXXXX" name="telC" id="telC" value="${user.telcell}"</td>
                    </tr>
                    <tr>
                        <th>Email</th>
                        <td><input type="email" class="form-control" name="email" id="email" value="${user.email}"</td>
                    </tr>
                    <tr>
                        <th>Company Name</th>
                        <td><input type="text" class="form-control" name="companyname" id="companyname" value="${user.company}"</td>
                    </tr>
                    <tr>
                        <th>Company Type</th>
                        <td><input type="text" class="form-control" name="type" id="type" value="${user.companytype}"</td>
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
