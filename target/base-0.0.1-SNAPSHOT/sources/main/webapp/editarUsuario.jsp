
  <div id="signupbox" style=" margin-top:50px" class="mainbox col-md-5 col-md-offset-4 col-sm-7 col-sm-offset-3">
	                    <div class="panel panel-primary">
	                        <div class="panel-heading">
	                            <div class="panel-title text-center">Editar Usuario <i class="fa fa-user-plus"></i></div>
	                            <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" href="#" onclick="$('#signupbox').hide(); $('#loginbox').show()">Sign In</a></div>
	                        </div>  
	                        <div class="panel-body" >
	                            <form id="signupform" class="form-horizontal" role="form" method = "post">
	                                
	                                <div id="signupalert" style="display:none" class="alert alert-danger">
	                                </div>
	                                <div id="signupsuccess" style="display:none" class="alert alert-success">
	                                </div>

	                                <div class="form-group">
	                                    <label for="firstname" class="col-md-4 control-label">Nombre</label>
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
	                                    <label for="lastname" class="col-md-4 control-label">Apellidos</label>
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
	                                    <label for="birthday" class="col-md-4 control-label">Fecha de nacimiento</label>
	                                    <div class="col-md-8">
	                                        <input type="text" 
	                                        	   class="form-control input-sm" 
	                                        	   name="birthday" 
	                                        	   placeholder="DD/MM/YYYY"
	                                        	   id = "datepicker"
	                                        	   data-toggle="tooltip"
	                                        	   data-placement="right"
	                                        	   
	                                        	   
	                                        	   >
	                                    </div>
	                                </div>
	
	                                <div class="form-group">
	                                    <!-- Button -->                                        
	                                    <div class="col-md-offset-4 col-md-8">
	                                        <button onclick="sendRegister()" id="btn-signup" type="button" class="btn btn-primary btn-sm"> Modificar datos <i class="fa fa-user-plus"></i></button>
	                                        <!--<span style="margin-left:8px;">or</span>  -->
	                                    </div>
	                                </div>
	                           
	                                
	                                
	                            </form>
	                         </div>
	                    </div>

	         </div>
