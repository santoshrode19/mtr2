<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@page session="true"%>
<!DOCTYPE html>
<html class="no-js">
<head>
 <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
 <meta charset="utf-8">
    <style>
      #right-panel {
        font-family: 'Roboto','sans-serif';
        line-height: 30px;
        padding-left: 10px;
      }

      #right-panel select, #right-panel input {
        font-size: 15px;
      }

      #right-panel select {
        width: 100%;
      }

      #right-panel i {
        font-size: 12px;
      }
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      #map {
        height: 100%;
        float: left;
        width: 70%;
        height: 100%;
      }
      #right-panel {
        margin: 20px;
        border-width: 2px;
        width: 20%;
        height: 400px;
        float: left;
        text-align: left;
        padding-top: 0;
      }
      #directions-panel {
        margin-top: 10px;
        background-color: #FFEE77;
        padding: 10px;
      }
    </style>
<title>Application</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>


    <!-- Vendor Stylesheets -->

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/sb-admin-2.css" >
	<link rel="stylesheet" href="css/metisMenu.min.css" >
	<link rel="stylesheet" href="css/morris.css" >
	<link rel="stylesheet" href="css/dataTables.bootstrap.min.css" >
	<link rel="stylesheet" href="css/bootstrap-datepicker.min.css" >
	<link rel="stylesheet" href="css/bootstrap-select.min.css" >
	<link rel="stylesheet" href="css/sortable.css" >
	<link rel="stylesheet" href="css/jquery-ui.css" >
			<link rel="stylesheet" href="css/jquery-ui.structure.css" >
				<link rel="stylesheet" href="css/jquery-ui.theme.css" >
				
					
						
	<link rel="stylesheet" href="css/file-select.css">
    <!-- Our Styles -->
    <link rel="stylesheet" href="css/main.css">
    
	<link rel="stylesheet" type="text/css" href="css/jsgantt.css"/>

	<link href="css/BootSideMenu.css" rel="stylesheet">		



</head>

<body>

    <c:if test="${pageContext.request.userPrincipal.name != null}">
		<input type="hidden" name="userName" id="userName" value='<security:authentication property="principal.username" />' />	
	</c:if>
    <security:authorize access="hasRole('ROLE_APP_USER')">
    <div id="wrapper">

		<div id="navigation">
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
            	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
               <!--  <a href="http://www.reple.com" target="blank"><img src="images/logoin.jpg"/></a> -->
            </div>
            <!-- /.navbar-header -->


            <ul class="nav navbar-top-links navbar-right">
                 
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    
                        <strong>${userFullName}</strong>
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#" data-toggle="modal" data-target="#changePasswordModal"><i class="fa fa-gear fa-fw"></i> Change Password</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="logout.htm"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation" id="sidebarDiv">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
           				<li>
			                <a id="Dashboard" href="#"  ><i class="fa fa-area-chart fa-fw"></i> Dashboard<span class="fa arrow"></span></a>
			            </li>
                 
                        <security:authorize access="hasAnyRole('ROLE_APP_USER')">
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i> Admin<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                               <li>
                                   <a href="#"><i class="fa fa-user fa-fw"></i> Manage Users<span class="fa arrow"></span></a>
                                   <ul class="nav nav-third-level">
                                      <li>
                                         <a id="CreateUser" href="#"><i class="fa fa-plus fa-fw"></i> Create User</a>
                                      </li>
                                      <li>
                                         <a id="EditUser" href="#"><i class="fa fa-edit fa-fw"></i> Edit User </a>
                                      </li>
                                     
                                   
                                   </ul>
                               </li>

                               
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
						</security:authorize>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
		</div>
        <!-- Page Content -->
        <div id="page-wrapper">
        </div>
        
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
	
	<!-- Change Password Modal -->
			<div id="changePasswordModal" class="modal fade in" role="dialog">
			  <div class="modal-dialog modal-sm">
			
			    <!-- Modal content-->
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h3 class="modal-title"><i class="fa fa-cog fa-spin"></i> Change Password</h3>
			      </div>
			      <div class="modal-body">
				        <form method="POST" name="changePasswordForm" id="changePasswordForm" onsubmit="return changePassword();">
				        	<input class="form-control" placeholder="Old password" name="oldpassword" id="oldpassword" type="password" autofocus required>
				        	<br/>
				        	<input class="form-control" 
				        			required pattern="(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\d]){1,})(?=(.*[\W]){1,})(?!.*\s).{8,32}" 
				        			onchange="if(this.checkValidity()) changePasswordForm.newpassword2.pattern = this.value;" 
				        			placeholder="New password" name="newpassword" id="newpassword" type="password" maxlength="32" required>
				        	<h6 class="fyi-txt-sm">Password must contain at least 8 characters, including UPPER/lowercase alphabets, numbers and special characters</h6>
				        	<input class="form-control" 				        			 
				        			pattern="(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\d]){1,})(?=(.*[\W]){1,})(?!.*\s).{8,32}"				        			
				        			placeholder="Confirm password" name="newpassword2" id="newpassword2" type="password" maxlength="32" required>
				        	<h6 class="fyi-txt-sm">Please enter the same password as above</h6>
				        	<button type="submit" class="btn btn-success btn-md"><i class="fa fa-check"></i> Change</button>&nbsp;&nbsp;<button type="button" class="btn btn-info btn-md" data-dismiss="modal"><i class="fa fa-close"></i> Cancel</button>
				        	<div id="messageDiv" class="red bolder"></div><div id="spinnerDiv" class="center" hidden="true"><i class="fa fa-cog fa-spin" id="spinnerDiv" hidden="true"></i></div>
				        </form>
			      </div>			      
			    </div>
			
			  </div>
			</div>
            
            <!-- /.Change Password Modal -->
	
	
	<!-- Task Details Modal -->
	<div id="taskDetailsModal" class="modal fade in" role="dialog">
	  <div class="modal-dialog modal-lg">
	    <!-- Modal content-->
	    <div class="modal-content"></div>
	  </div>
	</div>
	
	<!-- Task Forward Modal -->
	<div id="taskForwardModal" class="modal fade in" role="dialog">
	  <div class="modal-dialog modal-md">
	    <!-- Modal content-->
	    <div class="modal-content"></div>
	  </div>
	</div>
	
	<!-- Audit Trail Modal -->
	<div id="auditTrailModal" class="modal fade in" role="dialog">
	  <div class="modal-dialog modal-lg">
	    <!-- Modal content-->
	    <div class="modal-content"></div>
	  </div>
	</div>
	<!-- Project Details Modal -->
	<div id="projectDetailsModal" class="modal fade in" role="dialog">
	  <div class="modal-dialog modal-lg">
	    <!-- Modal content-->
	    <div class="modal-content"></div>
	  </div>
	</div>

    <!-- jQuery -->
    <script src="js/jquery.min.js"></script>
    <script src="js/jquery.dataTables.min.js"></script>
    <script src="js/dataTables.bootstrap.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
	<script src="js/bootstrap-datepicker.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="js/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="js/sb-admin-2.js"></script>
    
    <!-- Other JavaScript -->
    <script src="js/morris.min.js"></script>
    <script src="js/raphael-min.js"></script>
    <script src="js/eModal.min.js"></script>
    
    <script src="js/jsgantt.js"></script>
    <script src="js/jquery.blockUI.min.js"></script>
    <script src="js/jquery.i18n.properties.min.js"></script>
     <script src="js/jquery-ui.js"></script>
     <script src="js/prettify.js"></script>
     <script src="js/jquery.sortable5.min.js"></script>
     <script src="js/jquery.pnotify.min.js"></script>
    
     
     
     
    <!-- Our JavaScript -->
    <script src="js/main.js"></script>
      
 	<script src="js/bootstrap-select.min.js"></script>
 	<script src="js/load-image.all.min.js"></script>
    <!-- Metis Menu Plugin JavaScript -->

    <!-- Custom Theme JavaScript -->
    <script src="js/sb-admin-2.js"></script>
    <script src="js/BootSideMenu.js"></script>
    <script type="text/javascript">
		$('#sidebarDiv').BootSideMenu({side:"left", autoClose:false});
	</script>    
    <script>
	// This will initialize the plugin 
/* 	 jQuery.i18n.properties({
	     name:'Messages', 
	     path:'i18/', 
	     mode:'both',
	     language: $('#user_language')+'_'+$('#user_country'),  // language: 'de_GR', //+$('#user_country'),
	     checkAvailableLanguages: true,
	     async: true,
	     callback: function() {
	         // We specified mode: 'both' so translated values will be available as JS vars/functions and as a map
	         //jQuery.i18n.prop('msg_hello');
	        // alert(msg_hello +' <>  '+ msg_world);

	        //alert('${user_language}'+'_'+'${user_country}');
	     }
	}); */
	</script>
	
</security:authorize>
	


	<script type="text/javascript">
		$(document).ready(function() {

		});
	</script>
</body>

</html>
