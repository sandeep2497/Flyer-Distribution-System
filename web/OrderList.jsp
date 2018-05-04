
<%@page import="model.Orders"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Listing</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        
        <style>
            .error{
             font-size: 20px;
             color:red;
         }
            body {
                background: 	#FFFFFF;
                color: black;
                font: 87.5%/1.5em 'Open Sans', sans-serif;
                margin: 0;
                
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
             margin-left: 0px;
             margin-bottom: 100px;
         }
       </style>
</head>
<body>
     <%@include file="nav.jsp" %>
    <div class="container">
        <table border="0" cellpadding="10" class="table table-hover">
            <caption><h2>List of Orders</h2></caption>
            <tr>
               
                <th>Order #</th>
                <th>Quantity</th>
                <th>Layout</th>
                <th>Image</th>
                <th>Personal Copies</th>
                <th>Payment</th>
                <th>Invoice</th>
                <th>Comments</th>
                <th>Art Approved</th>
                <th>Payment Received</th>
                <th>Agent</th>
                <th>Client</th>
                <th>Action</th>
            </tr>
            

            <c:forEach var="order" items="${listOrder}">
                <tr>
                    
                   <td><c:out value="${order.getId()}" /></td>
                    <td><c:out value="${order.getFlyerQty()}" /></td>
                    <td><c:out value="${order.getFlyerLayout()}" /></td>
                    <td>
                        <img src="data:image/gif;base64,<c:out value="${order.getFlyerImgStr()}" />" alt="images Here" width="50" height="50"/>
                    </td>
                    <td><c:out value="${order.getPersonalCopy()}" /></td>
                    <td><c:out value="${order.getPaymentInformation()}" /></td>
                    <td><c:out value="${order.getInvoiceNumber()}" /></td>
                    <td><c:out value="${order.getComments()}" /></td>
                    
                    
<!--                     Will display yes or no depending on the number the data base 
                     gives back-->
                     <c:set var = "art" value="${order.isIsFlyerArtApproved()}"/>
                     <c:if test = "${art == 0}">
                         <td>No</td>
                     </c:if>
                     <c:if test = "${art == 1}">
                         <td>Yes</td>
                     </c:if>
                         
                     <c:set var = "payment" value="${order.isIsPaymentRecieved()}"/>
                     <c:if test = "${payment == 0}">
                         <td>No</td>
                     </c:if>
                     <c:if test = "${payment == 1}">
                         <td>Yes</td>
                     </c:if>
                          <td><c:out value="${order.getFirst()}" /></td>
                    <td><c:out value="${order.getCfirst()}" /></td>
                     
                    <td>
                        <a href="editO?id=<c:out value='${order.getId()}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="deleteO?id=<c:out value='${order.getId()}' />">Delete</a>                     
                    </td>
                </tr>
               
            </c:forEach>
        </table>
        <center>
            <a href="AddOrder.jsp"><input type="submit" class="btn btn-primary" value="Add New Order" name="update" /></a>
        </center>
    </div>   
    <p class="error">${sessionScope.error}</p>
     
</body>
<%@include file="footer.jsp" %>

</html>
