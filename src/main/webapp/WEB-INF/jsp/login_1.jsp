<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import = "java.util.ResourceBundle" %>
<!DOCTYPE html>
<html class="no-js">
<head>
<title>G-DII Application</title>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="description" content="POID User Interface">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
	
    <!-- Vendor Stylesheets -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">

    <!-- Our Styles -->
    <link rel="stylesheet" href="css/main.css">
      
</head>
<body class="login-body">
<% 
	ResourceBundle resource = ResourceBundle.getBundle("applicationConfig");
	String supportMailId= "";///* resource.getString("mail.support.mailid"); */
%>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <!-- <div class="login-panel panel panel-default"> -->
                <div class="login-box clearfix">
				<div class="page-icon ">
					<img class="img-responsive" src="images/logoin.jpg" alt="Key icon" style="margin-top: 40px;" />
				</div>	
                        <div class="login-form">
                        <div>
  							<h2 class="center bolder">Repleteinc</h2>
  							<h4 class="center bolder">G-DII Application</h4>
  							<h5 class="center">Powered By<b> G-DII&trade; &nbsp;</b></h5>
						</div>
                        <div class="red bolder center">${error}</div>
                        <form role="form" method="post" name="loginForm" action="login">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            
                                    <input class="form-control" placeholder="User Name" name="userName" id="userName" type="text" autofocus required  value="54382">
                            
                                    <input class="form-control" placeholder="Password" name="password" id="password" type="password" required value="54382"> 
                            
                                	<button type="submit" class="btn btn-success btn-md btn-login">Login <span class="glyphicon glyphicon-log-in"></span></button>
                            		<div class="text-center">
                                		<a href="javascript:forgotPassword();" class="pull-center">Forgot Password?</a>
                                	</div>
                                	<div class="text-center fyi-txt-sm-black bolder" style="font-size: x-small;">Please contact <%=supportMailId%> for login queries.</div>
                                	<div id="spinnerDiv" hidden="true"><i class="fa fa-spinner fa-pulse"></i></div>
                                	<div class="red bolder center" id="fpresult"></div>
                           </form>
                        </div>
                        
                    </div>
                    
                </div>
                
            </div>
            
        </div>

    <!-- jQuery -->
    <script src="js/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>          
	
	<!-- Our JavaScript -->
    <script src="js/login.js"></script>   

 </body>
</html>