<%@ include file="includes/header.jsp" %>

<script type="text/javascript" src="js/moment.min.js"></script>
<script type="text/javascript" src="js/combodate.js"></script>
<script>
$(function(){
    $('#date').combodate(); 
});

function convertDate(inputFormat) {
	  function pad(s) { return (s < 10) ? '0' + s : s; }
	  var d = new Date(inputFormat);
	  return [pad(d.getDate()), pad(d.getMonth()+1), d.getFullYear()].join('-');
	}
</script>
<div class="grid_6">
  <div class="container">
   <div class="breadcrumb1">
     <ul>
        <a href="index.html"><i class="fa fa-home home_1"></i></a>
        <span class="divider">&nbsp;|&nbsp;</span>
        <li class="current-page">Register</li>
     </ul>
   </div>
   <div class="services">
   	  <div class="col-md-6 col-md-offset-3 login_left">
	  <form action="createUser" class="" method="post">

<!-- Fieldsets -->
<fieldset id="first">

<h2 class="title">Create your account</h2>
<div class="form-group">
		      <label for="email">Enter your email id <span class="form-required" title="This field is required.">*</span></label>
		      <input type="text" id="email" name="email" value="" size="60" maxlength="60" class="form-text required">
		    </div>
 <div class="form-group">
		      <label for="password">Password <span class="form-required" title="This field is required.">*</span></label>
		      <input type="password" id="password" name="password" size="60" maxlength="128" class="form-text required">
		    </div>
			<div class="age_select">
		      <label for="edit-pass">Profile for<span class="form-required" title="This field is required.">*</span></label>
		        
                  <div class="select-block1">
                    <select name="profile_for">
	                    <option value="Self">Self</option>
	                    <option value="Son">Son</option>
	                    <option value="Daughter">Daughter</option>
	                    <option value="Brother">Brother</option>
	                    <option value="Friend">Friend</option>    
	                    <option value="Relative">Relative</option>
	                </select>
                  </div>
            </div>
        
            
			 <div class="form-group form-group1">
                <label class="col-sm-7 control-lable" for="gender">Gender : </label>
                <div class="col-sm-5">
                    <div class="radios">
				        <label for="radio-01" class="label_radio">
				            <input name="gender" value="M"  type="radio"> Male
				        </label>
				        <label for="radio-02" class="label_radio">
				            <input name="gender" value="F" type="radio"> Female
				        </label>
	                </div>
                </div>
                <div class="clearfix"> </div>
             </div>
                     <input class="next_btn btn_1 submit" name="next" type="button" value="Next">
</fieldset>
<fieldset>
           <div class="form-group">
			  <label for="first-name">Your Name <span class="form-required" title="This field is required.">*</span></label>
		       <div class="name_grid">
		        <div class="col-sm-6 form_box">
                  <div class="select-block1">
		      <input type="text" id="first-name" name="first_name" value="" size="60" maxlength="60" placeholder="First Name" class="form-text required">
			  </div>
			  </div>
			  <div class="col-sm-6 form_box">
                  <div class="select-block1">
			  <input type="text" id="last-name" name="last_name" value="" size="60" maxlength="60" placeholder="Last Name" class="form-text required">
			</div>
			</div>
			</div>
			</div>
			</br>
			   <div class="form-group">
			  <div class="age_select">
		      <label for="edit-pass">Date Of Birth <span class="form-required" title="This field is required.">*</span></label>
		        
		        <div class="age_grid">
		        <div class="col-md-6 form_box">
                  <input id="date" data-format="YYYY-MM-DD" value="2013-01-03" data-template="D MMM YYYY" name="dob" type="text">
                </div>
		          <div class="clearfix"> </div>
                 </div>
              </div>
              </div>
			  <div class="age_select">
		      <label for="edit-pass">Religion<span class="form-required" title="This field is required.">*</span></label>
		        
                  <div class="select-block1">
                    <select name="religion" required>
	                    <option value="">Select Religion</option>
	                   <c:forEach var="r" items="${religionList}">
	                    <option value="${r.id}">${r.name}</option>
	                   </c:forEach>
	                </select>
                  </div>
            </div>
			 <div class="age_select">
		      <label for="edit-pass">Mother Tongue<span class="form-required" title="This field is required.">*</span></label>
		        
                  <div class="select-block1">
                    <select name="mother_tongue">
	                    <option value="">Select Mother Tongue</option>
	                   <c:forEach var="mt" items="${mothertongueList}">
	                          <option value="${mt.id}">${mt.name}</option>
	                   </c:forEach>
	                </select>
                  </div>
            </div>
			 <div class="age_select">
		      <label for="edit-pass">Living in<span class="form-required" title="This field is required.">*</span></label>
		        
                  <div class="select-block1">
                    <select name="country">
	                    <option value="">Select</option>
	                    <c:forEach var="c" items="${countryList}">
	                     <option value="${c.id}" selected="selected">${c.name}</option>
	                    </c:forEach>
	                </select>
                  </div>
            </div>
            <input class="pre_btn btn_1 submit" type="button" value="Previous">
            <input class="next_btn btn_1 submit" name="signup" type="submit" value="Sign up">
</fieldset>
</form>

	  </div>
	  <!--<div class="col-sm-6">
	     <ul class="sharing">
			<li><a href="#" class="facebook" title="Facebook"><i class="fa fa-boxed fa-fw fa-facebook"></i> Share on Facebook</a></li>
		  	<li><a href="#" class="twitter" title="Twitter"><i class="fa fa-boxed fa-fw fa-twitter"></i> Tweet</a></li>
		  	<li><a href="#" class="google" title="Google"><i class="fa fa-boxed fa-fw fa-google-plus"></i> Share on Google+</a></li>
		  	<li><a href="#" class="linkedin" title="Linkedin"><i class="fa fa-boxed fa-fw fa-linkedin"></i> Share on LinkedIn</a></li>
		  	<li><a href="#" class="mail" title="Email"><i class="fa fa-boxed fa-fw fa-envelope-o"></i> E-mail</a></li>
		 </ul>
	  </divd>-->
	  <div class="clearfix"> </div>
   </div>
  </div>
</div>
<script src="js/multi_step_form.js"></script> 

<%@ include file="includes/footer.jsp" %>
 