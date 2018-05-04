<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Welcome To Flyer It Up!</title>
        <style>
div.album {
   
    margin: 0px auto;
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
 
<div class="container">
   
      
  <h2 class="text-success">Welcome to "Flyer It UP!"</h2>  
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img  src="<c:url value='img/c.jpg'/>" alt="Image1" style="width:100%;">
      </div>

      <div class="item">
        <img  src ="" alt="image2" style="width:100%;">
      </div>
    
      <div class="item">
        <img  alt="imqge3" style="width:100%;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

    <div >
    <br>
    
<div class="page-header">
   <h2 class="text-info ">&nbsp;&nbsp;&nbsp; Our Recent Flyers<span class="glyphicon glyphicon-tags"></span></h2></div>
<div class="holder">
<div class="resp">
  <div class="album">
    <a target="_blank" href="img/ex1.jpg">
      <img  alt="Example11" width="300px" class="img-rounded" height="200px">
    </a>
  </div>
</div>


<div class="resp">
  <div class="album">
    <a target="_blank" href="https://cdn.frip.in/wp-content/uploads/2018-New-Year-Color-Music-Festival-Flyer.jpg">
        <img  alt="Example2" width="300px" class="img-rounded" height="200px">
    </a>
  </div>
</div>

<div class="resp">
  <div class="album">
    <a target="_blank" href="img/ex4.jpg">
      <img alt="Example3" width="300px" class="img-rounded" height="200px">
    </a>
  </div>
</div>
</div>
</div>
         <%@include file="footer.jsp" %>
    </body>
</html>