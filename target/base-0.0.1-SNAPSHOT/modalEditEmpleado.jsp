
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 style="text-align: center;" class="modal-title" id="exampleModalLabel">Editar Empleado</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form id="signupform" class="form-horizontal" role="form" method = "post">
	                                
	                                <div id="signupalert" style="display:none" class="alert alert-danger">
	                                </div>
	                                <div id="signupsuccess" style="display:none" class="alert alert-success">
	                                </div>
	                                <div class="form-group">
									 <label for="id" class="col-md-4 control-label">Id</label>
	                                    <div class="col-md-8">
	                                        <input type="text" 
	                                        	   class="form-control input-sm" 
	                                        	   name="id" 
	                                        	   placeholder="Id"
	                                        	   title="solo letras, entre 3 y 20 caracteres"
	                                        	   id = "id"
	                                        	   data-toggle="tooltip" 
	                                        	   data-placement="right"
	                                        	   disabled
	                                        	   >
	                                    </div>
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
	                                    <div class="col-md-8"  data-placement="right">
	                                        <input type="text"
	                                        	   id="id_pass" 
	                                        	   class="form-control input-sm" 
	                                        	   name="passwd" 
	                                        	   placeholder="Password"
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
									 <label for="rol" class="col-md-4 control-label">Rol</label>
	                                    <div class="col-md-8">
	                                        <input type="text" 
	                                        	   class="form-control input-sm" 
	                                        	   name="rol" 
	                                        	   placeholder="Rol"
	                                        	   title="solo letras, entre 3 y 20 caracteres"
	                                        	   id = "rol"
	                                        	   data-toggle="tooltip" 
	                                        	   data-placement="right"
	                                        	   disabled
	                                        	   >
	                                    </div>
									</div>
	                                
	
	                            </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
        <button id="boton_actualizar" type="button" class="btn btn-primary" onclick="guardarDatosEmpleado()">Actualizar Empleado</button>
      </div>
    </div>
  </div>
</div>

