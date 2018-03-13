package com.prueba.spring.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.prueba.spring.dao.DAOEmpleado;
import com.prueba.spring.model.Empleado;

/**
 * Servlet implementation class UpdateEmpleado
 */
public class UpdateEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOEmpleado daoEmpleados;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmpleado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
initDao();
		
		boolean existe_usuario = false;
		
		Empleado emp = new Empleado();
		
		Date today = new Date();
		today.getTime();
		
		String id = request.getParameter("id");
		int newId = Integer.parseInt(id);
		String nombre = request.getParameter("name");
		String apellidos = request.getParameter("lastname");
		String email = request.getParameter("email");
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String fecha = request.getParameter("date");
		String rol = request.getParameter("rol");
		
		String []  bar = fecha.split(" ");

		if (
				StringUtils.isEmpty(user)      || 
			pass.isEmpty()      || (pass == null)      ||
			nombre.isEmpty()    || (nombre == null)    ||
			apellidos.isEmpty() || (apellidos == null) ||
			email.isEmpty()     || (email == null)     ||
			fecha.isEmpty()     || (fecha == null)) {
	
				System.out.println("Error: alguno de los campos esta vacio");
				return;
		 }
		
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		 Date date = null;
		try {
			date = formatter.parse(bar[0]);
		} catch (java.text.ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		 Pattern email_regex = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
		 Pattern name_regex = Pattern.compile("[a-zA-Z]{3,20}");
		 Pattern lastname_regex = Pattern.compile("^([\\sA-Za-z]{3,30})");
		 Pattern user_regex = Pattern.compile("[a-zA-Z0-9]{5,15}");
		 Pattern pass_regex = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,20}$");
		 
		 Matcher m_user = user_regex.matcher(user);
		 Matcher m_pass = pass_regex.matcher(pass);
		 Matcher m_name = name_regex.matcher(nombre);
		 Matcher m_lastname = lastname_regex.matcher(apellidos);
		 Matcher m_email = email_regex.matcher(email);

		 
		 boolean bool_user = m_user.matches();
		 boolean bool_pass = m_pass.matches();
		 boolean bool_name = m_name.matches();
		 boolean bool_lastname = m_lastname.matches();
		 boolean bool_email = m_email.matches();

		 
		 if(!bool_name) {
			 System.out.println("Error: El nombre no coincide con la especificacion requerida");
			 System.out.println("Error: solo numeros y letras del entre 6 y 15 caracteres");
			 return;
		 }
		 if(!bool_lastname) {
			 System.out.println("Error: Los apellidos no coincide con la especificacion requerida");
			 System.out.println("Error: solo numeros y letras del entre 6 y 15 caracteres");
			 return;
		 }
		 if(!bool_email) {
			 System.out.println("Error: El email no coincide con la especificacion requerida");
			 System.out.println("Error: solo numeros y letras del entre 6 y 15 caracteres");
			 return;
		 }
		 if(!bool_user) {
			 System.out.println("Error: El usuario no coincide con la especificacion requerida");
			 System.out.println("Error: solo numeros y letras del entre 6 y 15 caracteres");
			 return;
		 }
		 if(!bool_pass) {
			 System.out.println("Error: La contraseña no coincide con la especificacion requerida");
			 return;
		 }
	
		
		emp.setId(newId);
		emp.setNombre(nombre);
		emp.setApellidos(apellidos);
		emp.setEmail(email);
		emp.setUser(user);
		emp.setPassword(pass);
		emp.setF_nacimiento(date);
		emp.setRol(rol);
   
        try {
        	
        	daoEmpleados.actualizarEmpleado(emp);
        	
        } catch (Exception e) {
        	System.out.println("Error al introducir en la base de datos");
			e.printStackTrace();
			response.setContentType("text/plain");
    		response.getWriter().write("No se ha podido actualizar el Ususario");
    		return;
		}
        
        response.setContentType("text/plain");
		response.getWriter().write("se ha actualizado el Ususario correctamente");
	}

	public void setDaoEmpleados(DAOEmpleado daoEmpleados) {
		this.daoEmpleados = daoEmpleados;
	}

	public void initDao () {
		setDaoEmpleados((DAOEmpleado) this.getServletContext().getAttribute("daoEmpleados"));
	}
		
}

