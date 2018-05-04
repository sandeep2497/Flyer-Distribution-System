<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Order Form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

     <style>
            body {
                background:#FFFFFF;
                color: black;
                font: 87.5%/1.5em 'Open Sans', sans-serif;
                margin: 0;
              }
         a{
             color:#4682B4;
         }
         h1{
             font-size: 25px;             
         }         
        </style>
</head>
<body>
    <%@include file="nav.jsp" %>
    <div class="container">
            <form action="updateOrder" method="post" enctype="multipart/form-data">
                <center>
                <table  class="table table-striped ">
                    <caption><h2>Edit Order</h2></caption>
                  <input type="hidden" name="id" value="${order.getId()}" />
                               
                    <tr>
                        <th>Agent ID: </th>
                        <td>
                            <input type="text"  class="form-control"name="agentId"  disabled
                                    value="<c:out value='${order.getAgentId()}' />"
                            />
                        </td>
                    </tr>
                            
                    <tr>
                        <th>Client ID: </th>
                        <td>
                            <input type="text" class="form-control" name="clientId" disabled
                                    value="<c:out value='${order.getClientId()}' />"
                                />
                        </td>
                    </tr>
                    
                    <tr>
                        <th>Flyer Quantity: </th>
                        <td>
                            <input type="number" class="form-control" name="flyerQty" size="5"
                                    value="<c:out value='${order.getFlyerQty()}' />"
                            />  
                        </td>
                    </tr>
                    <tr>
                        <th>Flyer Layout: </th>
                        <td>
<!--                            <input type="text" class="form-control" name="flyerLayout" size="45"
                                    value="<c:out value='${order.getFlyerLayout()}' />"
                            />  -->
                            <select class="form-control" name="flyerLayout" required>
                                <option><c:out value='${order.getFlyerLayout()}' /></option>
                                <option>Portrait</option>
                                <option>Landscape</option>
                            </select>
                        </td> 
                    </tr>
                    <tr>
                        <th>Flyer Image: </th>
                        <td>
                            <input type="file"  class="form-control"name="flyerImage" size="45"
                                   value=""/>
                        </td>
                    </tr>
                    <tr>
                        <th>Personal Copy: </th>
                        <td>
                            <input type="number" class="form-control" name="personalCopy" size="5"
                                    value="<c:out value='${order.getPersonalCopy()}' />"
                            />
                        </td>
                    </tr>
                    <tr>    
                        <th>Payment Information: </th>
                        <td>
<!--                            <input type="text" class="form-control" name="paymentInformation" size="5"
                                    value="<c:out value='${order.getPaymentInformation()}' />"
                            />-->
                                <select class="form-control" name="paymentInformation" required>
                                 <option><c:out value='${order.getPaymentInformation()}' /></option>
                                <option>Visa</option>
                                <option>Master Card</option>
                                <option>American Express</option>
                                <option>Debit Car</option>
                                <option>Cheque</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Invoice Number: </th>
                        <td>
                            <input type="text" class="form-control" name="invoiceNumber" size="5"
                                    value="<c:out value='${order.getInvoiceNumber()}' />"
                            />
                        </td>
                    </tr>
                    <tr>
                        <th>Comments: </th>
                        <td>
                            <input type="text" class="form-control" name="comments" size="5"
                                    value="<c:out value='${order.getComments()}' />"
                            />
                        </td>   
                    </tr>
                    <tr>
                        <th>Is Flyer Art approved: </th>
                        <td>
                            <input type="text" class="form-control"name="isFlyerArtApproved" size="5"
                                    value="<c:out value='${order.isIsFlyerArtApproved()}' />"
                            />
                        </td>
                    </tr>
                    <tr>
                        <th>Is Payment Received </th>
                        <td>
                            <input type="text" class="form-control" name="isPaymentReceived" size="5"
                                    value="<c:out value='${order.isIsPaymentRecieved()}' />"
                            />
                        </td>
                    </tr>
                        <td colspan="2" align="center">
                            <input type="submit" class="btn btn-primary" value="Update" name="update" />
                        </td>
                    </tr>
                </table>
             </form>
    </center>
    </div>   
    <%@include file="footer.jsp" %>
</body>
</html>