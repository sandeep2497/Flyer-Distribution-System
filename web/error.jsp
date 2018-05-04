<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Welcome To Flyer It Up!</title>
        <style>
div{
   
   
        margin-top: 100px;
        margin-bottom: 100px;
}
div.album:hover {
    border: 1px solid red;
     box-shadow: 10px 10px 2px red;
}

div.album img {
    width: 100%;
    height: -webkit-fill-available;
}
* {
    box-sizing: border-box;
    
}

.resp {
    padding: 1px 6px;
    float: left;
    width: 30%;
    margin-left: 3%;
}
.holder
{
    border:2px solid black;
    width: 80%;
    background: black;
    margin: 0% 1% 2% 9%;
    padding: 2%;
    height: 450px;
}


@media only screen and (max-width: 500px) {
    .resp {
        width: 100%;
        margin: 1%;
    }
    .holder
    {
        border: 0px solid black;    }
    div{
       
    }
}
</style>
    </head>
    <body>
    <%@include file="nav.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <div>
    <div >
    <center>
        <h2><br/>${message1}<br/><span class="glyphicon glyphicon-thumbs-down"></span></h2>
        <a href="home.jsp"><input type="submit" class="btn btn-primary" value="Go Back" name="update" /></a>

    </center>
    </div>
      
  
</div>

   
         <%@include file="footer.jsp" %>
    </body>
</html>