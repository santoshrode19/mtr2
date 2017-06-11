<%@ include file="includes/header.jsp" %>


<div class="grid_6">
  <div class="container">
   <div class="breadcrumb1">
     <ul>
        <a href="index"><i class="fa fa-home home_1"></i></a>
        <span class="divider">&nbsp;|&nbsp;</span>
        <li class="current-page">Profile</li>
     </ul>
   </div>
   <div class="services">
   	  <div class="col-md-6 col-md-offset-3 login_left">
	  <form action="" class="regform" method="get">

<!-- Fieldsets -->

<fieldset id="first">
<div class="age_select">
		      <label for="edit-pass">He Lives in<span class="form-required" title="This field is required.">*</span></label>
		        
                  <div class="select-block1">
                    <select required>
	                    <option value="">Select State</option>
	                    <c:forEach var="s" items="${stateList}">
	                    <option value="${s.id}">${s.name}</option>
	                    </c:forEach> 
	                </select>
                  </div><br>
				  <div class="select-block1">
                    <select>
	                    <option value="">Select City</option>
	                    <option value=""></option>
	                    <option value=""></option>
	                </select>
                  </div>
           
            </div>
			<div class="age_select">
		      <label for="edit-pass">His marital status<span class="form-required" title="This field is required.">*</span></label>
		        
                  <div class="select-block1">
                    <select>
	                    <option value="">Select</option>
	                    <option value=""></option>
	                    <option value=""></option>
	                </select>
                  </div>
            </div>
			<div class="age_select">
		      <label for="edit-pass">His Community<span class="form-required" title="This field is required.">*</span></label>
		        
                  <div class="select-block1">
                    <select>
	                    <option value="">Select</option>
	                    <option value=""></option>
	                    <option value=""></option>
	                </select>
                  </div>
            </div>
			<div class="age_select">
		      <label for="edit-pass">Gothra / Gothram<span class="form-required" title="This field is required.">*</span></label>
		        
                  <div class="select-block1">
                    <select>
	                    <option value="">Select</option>
	                    <option value=""></option>
	                    <option value=""></option>
	                </select>
                  </div>
            </div>
			<div class="age_select">
		      <label for="edit-pass">Nakshatra<span class="form-required" title="This field is required.">*</span></label>
		        
                  <div class="select-block1">
                    <select>
	                    <option value="">Select</option>
	                    <option value=""></option>
	                    <option value=""></option>
	                </select>
                  </div>
            </div>
			<div class="form-group form-group1">
                <label for="sex">Dosham: </label>
               
                    <div class="radios">
				        <label for="radio-01" class="label_radio">
				            <input type="radio" checked=""> Yes
				        </label>
				        <label for="radio-02" class="label_radio">
				            <input type="radio"> No
				        </label>
						<label for="radio-03" class="label_radio">
				            <input type="radio"> Dont Know
				        </label>
	                </div>
                
                <div class="clearfix"> </div>
             </div>
			 
<input class="next_btn btn_1 submit" name="next" type="button" value="Next">
</fieldset>

<fieldset id="second">
<h2 class="title">Please add education & career details</h2>
<div class="age_select">
		      <label for="edit-pass">His education level<span class="form-required" title="This field is required.">*</span></label>
		        
                  <div class="select-block1">
                    <select>
	                    <option value="">Select</option>
	                    <option value=""></option>
	                    <option value=""></option>
	                </select>
                  </div><br>
				 
            </div>
			<div class="age_select">
		      <label for="edit-pass">His education field<span class="form-required" title="This field is required.">*</span></label>
		        
                  <div class="select-block1">
                    <select>
	                    <option value="">Select</option>
	                    <option value=""></option>
	                    <option value=""></option>
	                </select>
                  </div>
            </div>
			<div class="age_select">
		      <label for="edit-pass">He works with<span class="form-required" title="This field is required.">*</span></label>
		        
                  <div class="select-block1">
                    <select>
	                    <option value="">Select</option>
	                    <option value=""></option>
	                    <option value=""></option>
	                </select>
                  </div>
            </div>
			<div class="age_select">
		      <label for="edit-pass">As<span class="form-required" title="This field is required.">*</span></label>
		        
                  <div class="select-block1">
                    <select>
	                    <option value="">Select</option>
	                    <option value=""></option>
	                    <option value=""></option>
	                </select>
                  </div>
            </div>
			<div class="age_select">
		      <label for="edit-pass">His annual income<span class="form-required" title="This field is required.">*</span></label>
		        
                  <div class="select-block1">
                    <select>
	                    <option value="">Select</option>
	                    <option value=""></option>
	                    <option value=""></option>
	                </select>
                  </div>
            </div>
			 
<input class="pre_btn btn_1 submit" type="button" value="Previous">
<input class="next_btn btn_1 submit" name="next" type="button" value="Next">

</fieldset>
<fieldset id="third">
<h2 class="title">Add lifestyle details and we are almost done</h2>

<div class="age_select">
		      <label for="edit-pass">What's his diet?<span class="form-required" title="This field is required.">*</span></label>
		        
                  <div class="select-block1">
                    <select>
	                    <option value="">Select</option>
	                    <option value=""></option>
	                    <option value=""></option>
	                </select>
                  </div>
            </div>
			
			
				        
                 <div class="form-group form-group1">
                <label for="sex">Does he smoke?</label>
               
                    <div class="radios">
				        <label for="radio-01" class="label_radio">
				            <input type="radio" checked=""> No
				        </label>
				        <label for="radio-02" class="label_radio">
				            <input type="radio">Occasionally
				        </label>
						<label for="radio-03" class="label_radio">
				            <input type="radio"> Yes
				        </label>
	                </div>
                
                <div class="clearfix"> </div>
             </div>
			 
			 
			  <div class="form-group form-group1">
                <label for="sex">Drink?</label>
               
                    <div class="radios">
				        <label for="radio-01" class="label_radio">
				            <input type="radio" checked=""> No
				        </label>
				        <label for="radio-02" class="label_radio">
				            <input type="radio">Occasionally
				        </label>
						<label for="radio-03" class="label_radio">
				            <input type="radio"> Yes
				        </label>
	                </div>
                
                <div class="clearfix"> </div>
             </div>
           
		   <div class="age_select">
		      <label for="edit-pass">His height<span class="form-required" title="This field is required.">*</span></label>
		        
                  <div class="select-block1">
                    <select>
	                    <option value="">Select</option>
	                    <option value=""></option>
	                    <option value=""></option>
	                </select>
                  </div>
            </div>
			
			 
			  <div class="form-group form-group1">
                <label for="sex">Drink?</label>
               
                    <div class="radios">
				        <label for="radio-01" class="label_radio">
				            <input type="radio" checked=""> No
				        </label>
				        <label for="radio-02" class="label_radio">
				            <input type="radio">Occasionally
				        </label>
						<label for="radio-03" class="label_radio">
				            <input type="radio"> Yes
				        </label>
	                </div>
                
                <div class="clearfix"> </div>
             </div>
			 
			 
			 	 <div class="form-group form-group1">
                <label for="sex">Body Type</label>
               
                    <div class="radios">
				        <label for="radio-01" class="label_radio">
				            <input type="radio" checked=""> Slim
				        </label>
				        <label for="radio-02" class="label_radio">
				            <input type="radio"> Athletic
				        </label>
						<label for="radio-03" class="label_radio">
				            <input type="radio"> Average
				        </label>
						<label for="radio-03" class="label_radio">
				            <input type="radio"> Heavy
				        </label>
	                </div>
                
                <div class="clearfix"> </div>
             </div>
		
		
			 <div class="form-group form-group1">
                <label for="sex">Skin Tone</label>
               
                    <div class="radios">
				        <label for="radio-01" class="label_radio">
				            <input type="radio" checked=""> Very Fair
				        </label>
				        <label for="radio-02" class="label_radio">
				            <input type="radio"> Fair
				        </label>
						<label for="radio-03" class="label_radio">
				            <input type="radio"> Wheatish
				        </label>
						<label for="radio-03" class="label_radio">
				            <input type="radio"> Dark
				        </label>
	                </div>
                
                <div class="clearfix"> </div>
             </div>
		

			
			

<input class="pre_btn btn_1 submit" type="button" value="Previous">
<input class="next_btn btn_1 submit" name="next" type="button" value="Next">


</fieldset>

<fieldset id="forth">
<h2 class="title">One last thing! Describe Karan in a few words
</h2>

<div class="form-group">
		      <label for="edit-name">About my <span class="form-required" title="This field is required.">*</span></label>
		<textarea class="form-control" id="textbox" name="text" placeholder="Type in your message" rows="5"></textarea>
    </div>

	<div class="form-group form-group1">
                <label for="sex">Any Disability</label>
               
                    <div class="radios">
				        <label for="radio-01" class="label_radio">
				            <input type="radio" checked=""> None
				        </label>
				        <label for="radio-02" class="label_radio">
				            <input type="radio"> Physical Disability
				        </label>
				    </div>
                
                <div class="clearfix"> </div>
             </div>
<input class="pre_btn btn_1 submit" type="button" value="Previous">
   <input type="submit" id="edit-submit" name="op" value="Create Profile" class="btn_1 submit">
			 


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
<script type="text/javascript" src="js/multi_step_form.js"></script> 
 
<%@ include file="includes/footer.jsp" %>
	