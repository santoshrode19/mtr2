<%@ include file="includes/header.jsp" %>
   <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <!-- <div class="login-panel panel panel-default"> -->
                <div class="login-box clearfix">
				<div class="page-icon ">
					<img class="img-responsive" src="images/logo.png" alt="Key icon" style="margin-top: 40px;" />
				</div>	
                        <div class="login-form">
                        <div>
  							<h2 class="center bolder" style="padding-left:25%;">Metrimonial</h2>
  						</div>
  						<div class="red bolder center">${message}</div>
                        <div class="red bolder center">${error}</div>
                        <form role="form" method="post" name="loginForm" action="login">
                          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                     <div class="form-group">
                                     <input class="form-control" placeholder="User Name" name="userName" id="userName" type="text" autofocus required  value="one@nc.com">
                                     </div>
                                     <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" id="password" type="password" required value="54382"> 
                                     </div>
                                     <div class="form-grup">
                                                    <input class="next_btn btn_1 submit btn-lg" name="next" type="Submit" value="Sign in ">
                                	</div>
                                	<!-- <button type="submit" class="btn btn-success btn-md btn-login">Login <span class="glyphicon glyphicon-log-in"></span></button> -->
                            		<div class="text-right">
                                		<a href="javascript:forgotPassword();" class="pull-center">Forgot Password?</a>
                                	</div>
                                	<div class="text-left">
                                		<a href="signup" class="pull-center">Sign up?</a>
                                	</div>
                                	<div class="text-center fyi-txt-sm-black bolder" style="font-size: x-small;">Please contact for login queries.</div>
                                	<div id="spinnerDiv" hidden="true"><i class="fa fa-spinner fa-pulse"></i></div>
                                	<div class="red bolder center" id="fpresult"></div>
                           </form>
                        </div>
                        
                    </div>
                    
                </div>
                
            </div>
            
        </div>
 <div class="map">
<!-- 	<iframe src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d3150859.767904157!2d-96.62081048651531!3d39.536794757966845!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sen!2sin!4v1408111832978"> </iframe> -->
</div> 

<%@ include file="includes/footer.jsp" %>
 