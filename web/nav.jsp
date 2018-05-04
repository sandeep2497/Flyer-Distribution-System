
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
           <style>
 .polka {
    list-style-type: none;
    margin: 0;
    overflow: hidden;
    background-color: black;
}

.polka li {
    float: left;
    height: 80px;
}

.polka li a {
    display: block;
    color: white;
    text-align: center;
    height: 80px;
    padding: 22px 40px;
    text-decoration: none;
    font-size: 15px;
}

.polka li a:hover {
    background-color:	#0000FF;
    opacity:0.8;
    border: 2px solid 	#0000FF;
}
        </style>   
    </head>
    <body>
    
            <ul class="polka">
                <li ><a style="background:white;padding: 0px" href="gohome" > <img src="poka.png" width="50px" height="30px"/></a></li>
                <li><a href="gohome">Home&nbsp;<samp class="glyphicon glyphicon-home"></samp></a>&nbsp;</li>
                <li><a href="listAgents">Marketing Agent Form&nbsp;<span class="glyphicon glyphicon-knight"></span></a>&nbsp;</li>
                <li><a href="list">Clients&nbsp;<span class="glyphicon glyphicon-user"></span></a>&nbsp;</li>
                <li><a href="order">Orders&nbsp;<span class="glyphicon glyphicon-th-list"></span></a>&nbsp;</li>
                <li><a href="listLoc">Locations&nbsp;<span class="glyphicon glyphicon-map-marker"></span></a>&nbsp;</li>
                <li style="float:right"><a href=""><p style="color:white;" >Hello ${sessionScope.name}!&nbsp;&nbsp;&nbsp;LogOut&nbsp;&nbsp;<samp class="glyphicon glyphicon-log-out"></samp></p></a></li>
       </ul>
        
    
    </body>
</html>
