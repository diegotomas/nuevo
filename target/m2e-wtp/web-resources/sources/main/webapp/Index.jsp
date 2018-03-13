<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<!-- -------------------------------------  HEAD  ------------------------------------------------- -->
	<head>
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	  <link rel="stylesheet" type="text/css" href="css/jquery.datepick.css"> 
	  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
	  
	  
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-show-password/1.0.3/bootstrap-show-password.min.js"></script>
	  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	</head>
	<!-- -------------------------------------  END HEAD  ------------------------------------------------- -->
	
	<!-- -------------------------------------  STYLE  ------------------------------------------------- -->
	
	<style>
	.input-group-addon {
	   color: #fff;
	   background-color: #337ab7;
	}
	.form-control, .input-group-addon {
	   border-radius: 0px;
	}
	label{
	  text-align: left !important;
	}
	</style>
	
	<!-- -------------------------------------  END STYLE  ------------------------------------------------- -->

	<!-- -------------------------------------  BODY  ------------------------------------------------- -->
	<body>
	
	
	<!-- -------------------------------------  SCRYPT  ------------------------------------------------- -->
	
	<script>
			$(document).ready(function(){
			    $('[data-toggle="tooltip"]').tooltip({placement: "right"});
			});
	</script>
	
	<script type="text/javascript">
	function check(){
		console.log("check()");
		
		if( ($("#id_name").css("border-left-color") == "rgb(0, 128, 0)") &&
			($("#id_lastname").css("border-left-color") == "rgb(0, 128, 0)") &&
			($("#id_email").css("border-left-color") == "rgb(0, 128, 0)") &&
			($("#id_user").css("border-left-color") == "rgb(0, 128, 0)") &&
			($("#id_pass").css("border-left-color") == "rgb(0, 128, 0)") &&
			($("#datepicker").css("border-left-color") == "rgb(0, 128, 0)") ){
			
			$("#btn-signup").prop("disabled", false);
			
		}else{
			$("#btn-signup").prop("disabled", true);
			
		}
		
		
	}
	</script>
	
	
	<script type="text/javascript">
	function show() {
		
		if($("#id_pass").prop("type").localeCompare("text") == 0){
			$("#id_pass").prop("type", "password");
			$("#eye_img").attr("class", "glyphicon icon-eye-open glyphicon-eye-close");
		}
		else{
			$("#id_pass").prop("type", "text");
			$("#eye_img").attr("class", "glyphicon icon-eye-open glyphicon-eye-open");
		}
		
	}
	</script>
	
	<script type="text/javascript">
	 $( function() {
	   $("#datepicker").datepicker({
	   	dateFormat: 'dd/mm/yy',
	   	changeYear: true,
	   	defaultDate: "01/01/1990",
	   	yearRange: "1920:2015",
	   	showOptions: { direction: "down" }
	   });
	 } );
	</script>
	  
	<script type="text/javascript">

		$("#id_pass").password('toggle');

	</script>
			
	<script type="text/javascript">
	function checkPasswordLength(password) {
		
		  var span = document.getElementById("id_pass");
		  
		  if (password.length >= 6 && password.length <= 10 ) {
		    span.style.borderColor  ="orange";
		  } else if (password.length > 10 && password.length <= 15 ) {
			  span.style.borderColor  ="yellow";
		  } else if (password.length > 15) {
			  span.style.borderColor  ="green";
		  }
	}
	</script>
	
	
	
	
	<script type="text/javascript">
		$(document).ready(function() {
			
	
			
			$("#id_name").change(function() {
				
				var name = $("#id_name").val();
				var re = new RegExp("^[A-Za-z]{3,20}$");
				var res = name.match(re);
				
				if(!(res == null)){
					
					
					$("#signupalert").hide();
					$("#signupsuccess").html("Nombre valido");
					$("#signupsuccess").show();
					$("#id_name").css({"border-color": "green"});
					check();
					
				}else{
					
					$("#signupsuccess").hide();
					$("#signupalert").html("Nombre invalido");
					$("#signupalert").show();
					$("#id_name").css({"border-color": "red"});
					check();
				}
				
			});
			
			
			
			$("#id_lastname").change(function() {
				
				var lastname = $("#id_lastname").val();
				var re = new RegExp("^[\\sA-Za-z]{3,30}$");
				var res = lastname.match(re);
				
				if(!(res == null)){
					
					
					$("#signupalert").hide();
					$("#signupsuccess").html("Apellidos validos");
					$("#signupsuccess").show();
					$("#id_lastname").css({"border-color": "green"});
					check();
					
				}else{
					
					$("#signupsuccess").hide();
					$("#signupalert").html("Apellidos invalidos");
					$("#signupalert").show();
					$("#id_lastname").css({"border-color": "red"});
					check();
				}
				
			});
			
			$("#id_email").change(function() {
				
				var email = $("#id_email").val();
				var re = new RegExp("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$");
				var res = email.match(re);
				
				if(!(res == null)){
					$.ajax({
						type:'post',
						url:'/SpringMVCHibernate/ComprobarUsuarioEmail',
						data:{ "email": email },
						success : function(responseText) {
							
							var sol = responseText.localeCompare("Email valido");
							if(sol == 0){
								$("#signupalert").hide();
								$("#signupsuccess").html(responseText);
								$("#signupsuccess").show();
								$("#id_email").css({"border-color": "green"});
								check();
								
							}else{
								$("#signupsuccess").hide();
								$("#signupalert").html(responseText);
								$("#signupalert").show();
								$("#id_email").css({"border-color": "red"});
								check();
								
							}
						}
					});
					
				}else{
					
					$("#signupsuccess").hide();
					$("#signupalert").html("Email invalido");
					$("#signupalert").show();
					$("#id_email").css({"border-color": "red"});
					check();
					
				}
		    });
			
			$("#id_user").change(function() {
				
				var user = $("#id_user").val();
				var re = new RegExp("^[a-zA-Z0-9]{5,15}$");
				var res = user.match(re);
				
				if(!(res == null)){
					$.ajax({
						type:'post',
						url:'/SpringMVCHibernate/ComprobarUsuarioEmail',
						data:{ "user": user },
						success : function(responseText) {
							
							var sol = responseText.localeCompare("Usuario valido");
							if(sol == 0){
								$("#signupalert").hide();
								$("#signupsuccess").html(responseText);
								$("#signupsuccess").show();
								$("#id_user").css({"border-color": "green"});
								check();
								
							}else{
								$("#signupsuccess").hide();
								$("#signupalert").html(responseText);
								$("#signupalert").show();
								$("#id_user").css({"border-color": "red"});
								check();
							}
												
						}
					});
				}else{
					
					$("#signupsuccess").hide();
					$("#signupalert").html("Usuario invalido");
					$("#signupalert").show();
					$("#id_user").css({"border-color": "red"});
					check();
				}
		    });
			
			$("#id_pass").change(function() {
				
				var pass = $("#id_pass").val();
				var re = new RegExp("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,20}$");
				var res = pass.match(re);
				
				if(!(res == null)){
					
					
					$("#signupalert").hide();
					$("#signupsuccess").html("Contraseña valida");
					$("#signupsuccess").show();
					$("#id_pass").css({"border-color": "green"});
					check();
					
				}else{
					
					$("#signupsuccess").hide();
					$("#signupalert").html("Contraseña invalida");
					$("#signupalert").show();
					$("#id_pass").css({"border-color": "red"});
					check();
				}
				
			});
			
			
			
			$("#datepicker").change(function() {
				
				var datepi = $("#datepicker").val();
				
				var re = new RegExp("^(((((0[1-9])|(1\d)|(2[0-8]))\/((0[1-9])|(1[0-2])))|((31\/((0[13578])|(1[02])))|((29|30)\/((0[1,3-9])|(1[0-2])))))\/((20[0-9][0-9])|(19[0-9][0-9])))|((29\/02\/(19|20)(([02468][048])|([13579][26]))))$");
				var res = datepi.match(re);
				alert(datepi, res);
				if(!(res == null)){
					
					
					$("#signupalert").hide();
					$("#signupsuccess").html("Fecha de nacimiento valida");
					$("#signupsuccess").show();
					$("#datepicker").css({"border-color": "green"});
					check();
					
				}else{
					
					$("#signupsuccess").hide();
					$("#signupalert").html("Fecha de nacimiento invalida");
					$("#signupalert").show();
					$("#datepicker").css({"border-color": "red"});
					check();
					
				}
				check();
			});
			
		});
	</script>
	
	<script type="text/javascript">
	function sendRegister(){
	
		var name = $("#id_name").val();
		var lastname = $("#id_lastname").val();
		var email = $("#id_email").val();
		var user = $("#id_user").val();
		var pass = $("#id_pass").val();
		var fecha = $("#datepicker").val();
		
		if (name == null || name == "" ||
			lastname == null || lastname == "" ||
			email == null || email == "" ||
			user == null || user == "" ||
			pass == null || pass == "" ||
			fecha == null || fecha == "")
        {
			
			$("#signupalert").html("Por favor, debe rellenar todos los campos");
			$("#signupalert").show();

            return false;
        }
		
		$.ajax({
			type:'post',
			url:'/SpringMVCHibernate/ControladorRegistro',
			data:{ "name": name, "lastname": lastname, "email": email, "user": user, "pass":pass, "date":fecha },
			dataType: "html",
			success : function(responseText) {
				$('#ajaxGetUserServletResponse').text(responseText);
				window.alert(responseText);
			}
		});
		
		window.alert(name + lastname + email);
		return false;
	}
	</script>
	
	<script type="text/javascript">
	function sendLogin(){
		
		var user_login = $("#login-username").val();
		var pass_login = $("#login-password").val();
		
		if (user_login == null || user_login == "", 
			pass_login == null || pass_login == "")
	        {
				
				$("#signupalert").html("Por favor, debe rellenar todos los campos");
				$("#signupalert").show();

	            return false;
	        }
		
		var re_user = new RegExp("^[a-zA-Z0-9]{5,15}$");
		var res_user = user_login.match(re_user);
		
		var re_pass = new RegExp("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,20}$");
		var res_pass = pass_login.match(re_pass);
		
		if(!(res_user == null) && !(res_pass == null)){
			alert(user_login+pass_login);
			//$("#loginform").submit();
			//$("#loginform").post("/SpringMVCHibernate/ControladorAcceso",{"login-username":login-username, "login-password":login-pasword})
			$("#loginform").submit();
		}else{
			alert("algun campo no valido");
		}
	}
	
	
	</script>
	
	
	<div class="container">
	      <div class="container">    
	        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-5 col-md-offset-4 col-sm-7 col-sm-offset-3">                    
	            <div class="panel panel-primary" >
	                    <div class="panel-heading">
	                        <div class="panel-title text-center"><i class="fa fa-sign-in" aria-hidden="true"></i> Sign In</div>
	                        <div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="#">Forgot password?</a></div>
	                    </div>     
	
	                    <div style="padding-top:30px" class="panel-body" >
	
	                        <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
	                            
	                        <form id="loginform" class="form-horizontal" role="form" method="post" action="/SpringMVCHibernate/ControladorAcceso">
	                                    
	                            <div style="margin-bottom: 25px" class="input-group col-sm-offset-3 col-sm-7">
	                                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
	                                        <input id="login-username" type="text" class="form-control input-sm" name="username" value="" placeholder="username or email">                                        
	                                    </div>
	                                
	                            <div style="margin-bottom: 25px" class="input-group col-sm-offset-3 col-sm-7">
	                                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
	                                        <input id="login-password" type="password" class="form-control input-sm" name="password" placeholder="password">
	                                    </div>
	                                    
	
	                                
	                            <div class="input-group col-sm-offset-3 col-sm-7">
	                                      <div class="checkbox">
	                                        <label>
	                                          <input id="login-remember" type="checkbox" name="remember" value="1"> Remember me
	                                        </label>
	                                      </div>
	                                    </div>
	
	
	                                <div style="margin-top:10px" class="form-group">
	                                    <!-- Button -->
	
	                                    <div class="col-sm-12 controls text-center">
	                                      <a id="btn-login" href="#" class="btn btn-primary btn-sm" onclick="sendLogin()"> 
	                                      	Login <i class="fa fa-sign-in" aria-hidden="true"></i>   
	                                      </a>
	                                    </div>
	                                </div>
	
	
	                                <div class="form-group">
	                                    <div class="col-md-12 control">
	                                        <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
	                                            Don't have an account! 
	                                        <a href="#" onClick="$('#loginbox').hide(); $('#signupbox').show()">
	                                            Sign Up Here
	                                        </a>
	                                        </div>
	                                    </div>
	                                </div>    
	                            </form>     
	
	
	
	                        </div>                     
	                    </div>  	
	        </div>
	        <div id="signupbox" style="display:none; margin-top:50px" class="mainbox col-md-5 col-md-offset-4 col-sm-7 col-sm-offset-3">
	                    <div class="panel panel-primary">
	                        <div class="panel-heading">
	                            <div class="panel-title text-center">Sign Up <i class="fa fa-user-plus"></i></div>
	                            <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" href="#" onclick="$('#signupbox').hide(); $('#loginbox').show()">Sign In</a></div>
	                        </div>  
	                        <div class="panel-body" >
	                            <form id="signupform" class="form-horizontal" role="form" method = "post">
	                                
	                                <div id="signupalert" style="display:none" class="alert alert-danger">
	                                </div>
	                                <div id="signupsuccess" style="display:none" class="alert alert-success">
	                                </div>

	                                <div class="form-group">
	                                    <label for="firstname" class="col-md-4 control-label">First Name</label>
	                                    <div class="col-md-8">
	                                        <input type="text" 
	                                        	   class="form-control input-sm" 
	                                        	   name="firstname" 
	                                        	   placeholder="First Name"
	                                        	   title="solo letras, entre 3 y 20 caracteres"
	                                        	   id = "id_name"
	                                        	   data-toggle="tooltip" 
	                                        	   data-placement="right"
	                                        	   
	                                        	   >
	                                    </div>
	                                </div>
	                                <div class="form-group">
	                                    <label for="lastname" class="col-md-4 control-label">Last Name</label>
	                                    <div class="col-md-8">
	                                        <input type="text"
	                                       		   title="solo letras y espacios, entre 3 y 30 caracteres"
	                                               class="form-control input-sm" 
	                                               name="lastname" 
	                                               placeholder="Last Name"
	                                               id = "id_lastname"
	                                               data-toggle="tooltip"
	                                               data-placement="right"
	                                               
	                                               >
	                                    </div>
	                                </div>
	                                
	                                <div class="form-group">
	                                    <label for="email" class="col-md-4 control-label">Email</label>
	                                    <div class="col-md-8">
	                                        <input type="text" 
	                                        	   class="form-control input-sm" 
	                                        	   name="email" 
	                                        	   placeholder="Email Address"
	                                        	   data-toggle="tooltip"
	                                        	   data-placement="right"
	                                        	   id="id_email"
	                                        	   title="email existente"
	                                        	   
	                                        	   >
	                                    </div>
	                                </div>
	                                
	                                <div class="form-group">
	                                    <label for="user" class="col-md-4 control-label">User</label>
	                                    <div class="col-md-8">
	                                        <input type="text"
	                                        	   id="id_user" 
	                                        	   class="form-control input-sm" 
	                                        	   name="user" 
	                                        	   placeholder="User"
	                                        	   data-toggle="tooltip"
	                                        	   data-placement="right"
								        		   title="solo letras y numeros, entre 5 y 15 caracteres"
								        		   
												   >
	                                    </div>
	                                </div>
	                                
	                                <div class="form-group">
	                                    <label for="password" class="col-md-4 control-label">Password</label>
	                                    <div class="col-md-7" data-toggle="tooltip" data-placement="right">
	                                        <input type="password"
	                                        	   id="id_pass" 
	                                        	   class="form-control input-sm" 
	                                        	   name="passwd"
	                                        	   
	                                        	   placeholder="Password"
							        			   title="Por lo menos: un digito, una letra mayuscula, una letra minuscula, un simbolo de estos(@#$%^&+=), sin espacios, entre 6 y 20 caracteres"
							        			   onkeyup='checkPasswordLength(this.value)'
							        			   
							        			   >	  
	                                    </div> 
	                                    
	                                    <div style=" padding-left: px; background-color: #337ab7;color: #FFF;height: 30px;line-height: 15px;cursor: pointer; margin-left: -15px; padding-top: 8px;" class="col-md-1" onclick="show()">
							        		<span id="id_show" style=" display: block;  width: 100%;">
							        		<i id="eye_img" class="glyphicon icon-eye-open glyphicon-eye-open" style="top: 50%;right: 50%;"></i>
							        		</span>
							        	</div>
	                                </div>
	                                    
	                                <div class="form-group">
	                                    <label for="birthday" class="col-md-4 control-label">Birthday</label>
	                                    <div class="col-md-8">
	                                        <input type="text" 
	                                        	   class="form-control input-sm" 
	                                        	   name="birthday" 
	                                        	   placeholder="DD/MM/YYYY"
	                                        	   id = "datepicker"
	                                        	   data-toggle="tooltip"
	                                        	   data-placement="right"
	                                        	   readonly="readonly"
	                                        	   
	                                        	   >
	                                    </div>
	                                </div>
	
	                                <div class="form-group">
	                                    <!-- Button -->                                        
	                                    <div class="col-md-offset-4 col-md-8">
	                                        <button onclick="sendRegister()" id="btn-signup" type="button" class="btn btn-primary btn-sm" disabled> Sign Up <i class="fa fa-user-plus"></i></button>
	                                        <!--<span style="margin-left:8px;">or</span>  -->
	                                    </div>
	                                </div>
	                           
	                                <div class="form-group">
	                                    <div class="col-md-12 control">
	                                        <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
	                                            Do you have an account! 
	                                        <a href="#" onClick="$('#signupbox').hide(); $('#loginbox').show()">
	                                            Login Here
	                                        </a>
	                                        </div>
	                                    </div>
	                                </div>
	                                
	                                
	                                
	                                
	                            </form>
	                         </div>
	                    </div>

	         </div>
	         
	         
	          
	    </div>
	    
	</div>
		
	
	</body> 
</html>
