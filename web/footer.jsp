
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            
         
* {
  box-sizing: border-box
}
html, body {
  height: 100%
      margin-top: 100px;
}
body {
	font: 11px "Open Sans", sans-serif;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
	margin: auto;
  display: flex;
  flex-flow: column nowrap;
}
ul {
  list-style: none
}
.generic-anchor {
	color: $primary-light-blue;
	&:visited {
		color: $primary-light-blue
	}
	&:hover {
		color: $primary-line-color
	}
}
.flex-rw {
  display: flex;
  flex-flow: row wrap;
  margin-top: 50px;
  padding-top: 20px;
}
h4{
    font-size: 33px;
    color:white;
    font-family:cursive;
    font-style:italic;
}
//This main is mostly to push the footer to the bottom and for demo purposes.
main {
  flex: 1 1 auto; //For IE11
  display: flex;
  align-items: center;
  justify-content: center;
  font: 10em "Oswald", sans-serif;
  color: rgb(155,155,155);
  line-height: 1
}
footer {
  background: black;
  margin-top: auto;
  width: 100%
}
.footer-list-top {
  width: 33.333%
}
.footer-list-top > li {
  text-align: center;
  padding-bottom: 10px
}
.footer-list-header {
  padding: 10px 0 5px 0;
  color: #fff;
  font: 2.3vw "Oswald", sans-serif
}
.footer-list-anchor {
  font: 1.3em "Open Sans", sans-serif
}
.footer-social-section {
  width: 100%;
  align-items: center;
  justify-content: space-around;
  position: relative;
  margin-top: 5px;
}
.footer-social-section::after {
  content: "";
  position: absolute;
  z-index: 1;
  top: 50%;
  left: 10px;
  border-top: 1px solid $primary-line-color;
  width: calc(100% - 20px)
}
.footer-social-overlap {
  position: relative;
  z-index: 2;
  background: rgb(55,55,55);
  padding: 0 20px
}
.footer-social-connect {
  display: flex;
  align-items: center;
  font: 3.5em "Oswald", sans-serif;
  color: #fff
}
.footer-social-small {
  font-size: 0.6em;
  padding: 0px 20px
}
.footer-social-overlap > a {
  font-size: 3em
}
.footer-social-overlap > a:not(:first-child) {
  margin-left: 0.38em
}
.footer-bottom-section {
  width: 100%;
  padding: 10px;
  border-top: 1px solid $primary-line-color;
  margin-top: 10px
}
.footer-bottom-section > div:first-child {
  margin-right: auto
}
.footer-bottom-wrapper {
  font-size: 1.5em;
  color: #fff
}
.footer-address {
  display: inline;
  font-style: normal
}
@media only screen and (max-width: 768px) {
  .footer-list-header {
    font-size: 2em
  }
  .footer-list-anchor {
    font-size: 1.1em
  }
  .footer-social-connect {
    font-size: 2.5em
  }
  .footer-social-overlap > a {
    font-size: 2.24em
  }
  .footer-bottom-wrapper {
    font-size: 1.3em
  }
}
@media only screen and (max-width: 568px) {
  main {
    font-size: 5em
  }
  .footer-list-top {
    width: 100%
  }
  
  .footer-list-anchor {
    font-size: 1.5em
  }
  .footer-social-section {
    justify-content: center
  }
  .footer-social-section::after {
    top: 25%
  }
  .footer-social-connect {
    margin-bottom: 10px;
    padding: 0 10px
  }
  .footer-social-overlap {
    display: flex;
    justify-content: center;
  }
  .footer-social-icons-wrapper {
    width: 100%;
    padding: 0
  }
  .footer-social-overlap > a:not(:first-child) {
    margin-left: 20px;
  }
  .footer-bottom-section {
    padding: 0 5px 10px 5px
  }
  .footer-bottom-wrapper {
    text-align: center;
    width: 100%;
    margin-top: 10px
  }
}
@media only screen and (max-width: 480px) {
  .footer-social-overlap > a {
    margin: auto
  }
  .footer-social-overlap > a:not(:first-child) {
    margin-left: 0;
  }
  .footer-bottom-rights {
    display: block
  }
}
@media only screen and (max-width: 320px) {
  .footer-list-header {
    font-size: 2.2em
  }
  .footer-list-anchor {
    font-size: 1.2em
  }
  .footer-social-connect {
    font-size: 2.4em
  }
  .footer-social-overlap > a {
    font-size: 2.24em
  }
  .footer-bottom-wrapper {
    font-size: 1.3em
  }
}
        </style>
    </head>
    <body>
<!--Some of this HTML is directly from Pavilion.  You can change it to whatever you want if you want to mimic this design.-->
<footer class="flex-rw">
  
  <ul class="footer-list-top">
    <li>
      <h4 >About Flyer It UP</h4></li>
   
    <li><a class="generic-anchor footer-list-anchor" itemprop="significantLink">Become an Agent</a></li>

    <li><a  itemprop="significantLink" class="generic-anchor footer-list-anchor">Job Opennings</a></li>

    <li><a class="generic-anchor footer-list-anchor" itemprop="significantLink">Events</a></li>
  </ul>
  <ul class="footer-list-top">
    <li>
        
    <h4>Options</h4></li>


    <li><a  class="generic-anchor footer-list-anchor">Agents</a></li>
    <li><a  class="generic-anchor footer-list-anchor">Locations</a></li>
    <li><a  class="generic-anchor footer-list-anchor">Clients</a></li>
    <li><a  class="generic-anchor footer-list-anchor">Open Orders</a></li>
   
  </ul>
  <ul class="footer-list-top">
    <li id='help'>
      <h4 >Need Help Me</h4></li>
    <li><a  class="generic-anchor footer-list-anchor" itemprop="significantLink">Contact us</a></li>
    <li><a  class="generic-anchor footer-list-anchor" itemprop="significantLink">F.A.Q</a></li>
    <li id='find-a-store'><a  class="generic-anchor footer-list-anchor" itemprop="significantLink">Store Locations</a></li>
    <li id='user-registration'><a  class="generic-anchor footer-list-anchor" itemprop="significantLink">New Here</a></li>
    <li id='order-tracking'><a  itemprop="significantLink" class="generic-anchor footer-list-anchor">Order Status</a></li>
  </ul>
     
  </section>
  <section class="footer-bottom-section flex-rw">
<div class="footer-bottom-wrapper">   
<i class="fa fa-copyright" role="copyright">
 
</i> 2018 Flyer It UP in <address class="footer-address" role="company address">Toronto, On</address><span class="footer-bottom-rights"> <p>Flyer Corp.&copy;2018</p></span>
    </div>
    <div class="footer-bottom-wrapper">
    <a  class="generic-anchor" rel="nofollow">Terms</a> | <a  class="generic-anchor" rel="nofollow">Privacy</a>
      </div>
  </section>
</footer>
    </body>
</html>
