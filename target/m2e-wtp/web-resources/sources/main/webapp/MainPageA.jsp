<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	  <link rel="stylesheet" type="text/css" href="css/jquery.datepick.css"> 
	  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
	  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.css"/>
	  
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-show-password/1.0.3/bootstrap-show-password.min.js"></script>
	  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	  <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
#load{
    width:100%;
    height:100%;
    position:fixed;
    z-index:9999;
    background:url("https://www.creditmutuel.fr/cmne/fr/banques/webservices/nswr/images/loading.gif") no-repeat center center rgba(0,0,0,0.25)
}
	
#ui-id-1 {

padding-left: 350px;
content: 'Empleados';
}

#example2_wrapper{

	margin-left: 50px;
	margin-right: 50px;
	margin-top: 50px;

}
</style>

</head>
<body  onload="mostrarEmpleados()">

<script type="text/javascript">
function guardarDatosEmpleado(){

	var id = $("#id").val();
	var name = $("#id_name").val();
	var lastname = $("#id_lastname").val();
	var email = $("#id_email").val();
	var user = $("#id_user").val();
	var pass = $("#id_pass").val();
	var fecha = $("#datepicker").val();
	var rol = $("#rol").val();
	
	if (
		name == null || name == "" ||
		lastname == null || lastname == "" ||
		email == null || email == "" ||
		user == null || user == "" ||
		pass == null || pass == "" ||
		fecha == null || fecha == "")
    {
		
		$("#signupalert").html("Por favor, debe rellenar todos los campos");
		$("#signupalert").show();

        return;
    }
	
	$.ajax({
		type:'post',
		url:'/SpringMVCHibernate/UpdateEmpleado',
		data:{ "id": id, "name": name, "lastname": lastname, "email": email, "user": user, "pass":pass, "date":fecha, "rol": rol},
		dataType: "html",
		success : function(responseText) {
			$('#ajaxGetUserServletResponse').text(responseText);
			window.alert(responseText);
		}
	});
	
	return;
	
}
</script>


<script type="text/javascript">
function showModal(id, rol){
	$.ajax({
		type:'post',
		url:'/SpringMVCHibernate/DatosUsuario',
		data:{ "id": id },
		success : function(data) {

			$("#rol").val(rol);
			$("#id").val(id);
			$("#id_name").val(data.nombre);
			$("#id_lastname").val(data.apellidos);
			$("#id_email").val(data.email);
			$("#id_user").val(data.user);
			$("#id_pass").val(data.password);
			$("#datepicker").val(data.f_nacimiento);					
		}
	});
	$("#exampleModal").modal('show');
}

</script>


<script type="text/javascript">
	function mostrarDialog() {
	var url = 'ruta a datos';
	var dialog = $(
	'<table id="example" class="display" width="100%" cellspacing="0"  style="padding-left: 0px;"><thead><tr><th>Id</th><th>Nombre</th><th>Apellidos</th><th>Email</th><th>Usuario</th><th>Contraseña</th><th>Fecha de nacimiento</th></tr></thead></table>').appendTo('body');	 
	dialog.dialog({ 
	close: function(event, ui) { 
	dialog.remove();
	},
	modal: true,
	title: 'Empleados',
	width:918,
	height:450
	}); 
	dialog.load(
	url,
	{},
	function (responseText, textStatus, XMLHttpRequest) {
	dialog.removeClass('loading');
	mostrarEmpleados();
	}
	
	);
	}

</script>

<script type="text/javascript">
function mostrarEmpleados(){
	$.ajax({
		type:'post',
		url:'/SpringMVCHibernate/DevolverEmpleados',
		success : function(data) {
			
			//$("#data1").html(data.user);
			//$("#data2").html(data.id);
			//$("#data3").html(data.nombre);
			/*
			$('#example').DataTable( {
			    data: data,
			    columns: [
			    	
			    	{ data: 'id' },
			        { data: 'nombre' },
			        { data: 'apellidos' },
			        { data: 'email' },
			        { data: 'user' },
			        { data: 'password' },
			        { data: 'f_nacimiento' }
			    ]
			} );
			*/
			$('#example2').DataTable( {
			    data: data,
			    columns: [
			    	{ "title": "ID", data: 'id' },
			        { "title": "NOMBRE", data: 'nombre' },
			        { "title": "APELLIDOS", data: 'apellidos' },
			        { "title": "EMAIL", data: 'email' },
			        { "title": "USUARIO", data: 'user' },
			        { "title": "CONTRASEÑA", data: 'password' },
			        { "title": "FECHA DE NACIMINETO", data: 'f_nacimiento' },
			        { "title": "EDITAR", data: 'edit' },
			        { "title": "BORRAR", data: 'delete' }
			    ]
			} );
			
		}	
	});
}

</script>
<!--
<div class="col-md-offset-4 col-md-8">
    <button onclick="mostrarEmpleados()" id="botonMostrarEmpleados" type="button" class="btn btn-primary btn-sm"> 
    	Mostrar empleados <i class="fa fa-user-plus"></i>
    </button>
</div>

<div class="col-md-offset-4 col-md-8">
    <button onclick="mostrarDialog()" id="botonMostrarEmpleados" type="button" class="btn btn-primary btn-sm"> 
    	Mostrar  <i class="fa fa-user-plus"></i>
    </button>
</div>
-->
<table id="example2" class="display" width="100%" cellspacing="0">
	<thead>
		<tr>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
		</tr>
	</thead>
</table>

<%@ include file="modalEditEmpleado.jsp" %>
</body>
</html>