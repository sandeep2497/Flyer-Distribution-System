<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Order Form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <style>
            body {
                background: 	#FFFFFF;
                color: black;
                font: 87.5%/1.5em 'Open Sans', sans-serif;
                margin: 0;
              }
         a{
             color:	#4682B4;
         }
         .error{
             font-size: 20px;
             color:red;
         }
       </style>
</head>
<body>
     <%@include file="nav.jsp" %>

    <div class="container">
        
            <form action="neworder" method="post" enctype="multipart/form-data">
                <table class="table table-striped">
                    <caption>
                        <h2> Add New Order </h2>
                    </caption>
                    <tr>
                        <th>Client ID:</th>
                        <td><select class="form-control" name="clientId" id="clientId">
                            <option>----Select Client---</option>
                            <c:forEach var="dropdown" items="${dropdown}">
                                <option value="${dropdown.getUserId()}"> <c:out value="${dropdown.getName()}"/></option>
                                                              
                            </c:forEach>
                            
                            </select></td>
                    </tr>
                    <tr>
                        <th>Flyer Quantity: </th>
                        <td>
                            <input type="number" class="form-control" name="flyerQty" size="5" required />  
                        </td>
                    </tr>
                    <tr>
                        <th>Flyer Layout: </th>
                        <td>
                            <!--<input type="text" class="form-control" name="flyerLayout" size="45"required/>-->  
                            <select class="form-control" name="flyerLayout" required>
                                 <option>---Select Landscape---</option>
                                <option>Portrait</option>
                                <option>Landscape</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Flyer Image: </th>
                        <td>
                            <input type="file" class="form-control" name="flyerImg" size="45" required/>
                        </td>
                    </tr>
                    <tr>
                        <th>Personal Copy: </th>
                        <td>
                            <input type="number"  class="form-control" name="personalCopy" size="5" required/>
                        </td>
                    </tr>
                    <tr>    
                        <th>Payment Information: </th>
                        <td>
                            <select class="form-control" name="paymentInformation" required>
                                 <option>---Select Payment---</option>
                                <option>Visa</option>
                                <option>Master Card</option>
                                <option>American Express</option>
                                <option>Debit Car</option>
                                <option>Cheque</option>
                            </select>
                            <!--<input type="text" class="form-control" name="paymentInformation" size="45" required/>-->
                        </td>
                    </tr>
                    <tr>
                        <th>Invoice Number: </th>
                        <td>
                            <input type="text" class="form-control" name="invoiceNumber" size="5" required/>
                        </td>
                    </tr>
                    <tr>
                        <th>Comments: </th>
                        <td>
                            <input type="textarea" class="form-control" name="comments" size="45" required/>
                        </td>   
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" class="btn btn-primary" value="Add Order" name="update"/>
                        </td>
                    </tr>
                </table>
             </form>
    </div>   
             <%@include file="footer.jsp" %>
</body>
</html>