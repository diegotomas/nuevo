package com.prueba.spring.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;

import com.prueba.spring.dao.DAOEmpleado;
import com.prueba.spring.model.Empleado;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * Servlet implementation class ControladorRegistro
 */
public class ControladorRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOEmpleado daoEmpleados;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorRegistro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


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
		
		String nombre = request.getParameter("name");
		String apellidos = request.getParameter("lastname");
		String email = request.getParameter("email");
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String fecha = request.getParameter("date");
		String rol;

		if (user.isEmpty()      || (user == null)      || 
			pass.isEmpty()      || (pass == null)      ||
			nombre.isEmpty()    || (nombre == null)    ||
			apellidos.isEmpty() || (apellidos == null) ||
			email.isEmpty()     || (email == null)     ||
			fecha.isEmpty()     || (fecha == null)) {
	
				System.out.println("Error: alguno de los campos esta vacio");
				return;
		 }
		
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		 Date date = null;
		try {
			date = formatter.parse(fecha);
		} catch (java.text.ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 if(today.compareTo(date) <= 0) {
			 System.out.println("Error: La fecha introducida debe ser anterior a la fecha actual");
			 return;
		 }
		
		 Pattern email_regex = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
		 Pattern name_regex = Pattern.compile("[a-zA-Z]{3,20}");
		 Pattern lastname_regex = Pattern.compile("^([\\sA-Za-z]{3,30})");
		 Pattern date_regex = Pattern.compile("(^(((0[1-9]|1[0-9]|2[0-8])[\\/](0[1-9]|1[012]))|((29|30|31)[\\/](0[13578]|1[02]))|((29|30)[\\/](0[4,6,9]|11)))[\\/](19|[2-9][0-9])\\d\\d$)|(^29[\\/]02[\\/](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)");
		 Pattern user_regex = Pattern.compile("[a-zA-Z0-9]{5,15}");
		 Pattern pass_regex = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,20}$");
		 
		 Matcher m_user = user_regex.matcher(user);
		 Matcher m_pass = pass_regex.matcher(pass);
		 Matcher m_name = name_regex.matcher(nombre);
		 Matcher m_lastname = lastname_regex.matcher(apellidos);
		 Matcher m_email = email_regex.matcher(email);
		 Matcher m_date = date_regex.matcher(fecha);
		 
		 boolean bool_user = m_user.matches();
		 boolean bool_pass = m_pass.matches();
		 boolean bool_name = m_name.matches();
		 boolean bool_lastname = m_lastname.matches();
		 boolean bool_email = m_email.matches();
		 boolean bool_date = m_date.matches();
		 
		 if(bool_name == false) {
			 System.out.println("Error: El nombre no coincide con la especificacion requerida");
			 System.out.println("Error: solo numeros y letras del entre 6 y 15 caracteres");
			 return;
		 }
		 if(bool_lastname == false) {
			 System.out.println("Error: Los apellidos no coincide con la especificacion requerida");
			 System.out.println("Error: solo numeros y letras del entre 6 y 15 caracteres");
			 return;
		 }
		 if(bool_email == false) {
			 System.out.println("Error: El email no coincide con la especificacion requerida");
			 System.out.println("Error: solo numeros y letras del entre 6 y 15 caracteres");
			 return;
		 }
		 if(bool_user == false) {
			 System.out.println("Error: El usuario no coincide con la especificacion requerida");
			 System.out.println("Error: solo numeros y letras del entre 6 y 15 caracteres");
			 return;
		 }
		 if(bool_pass == false) {
			 System.out.println("Error: La contraseña no coincide con la especificacion requerida");
			 return;
		 }
		 if(bool_date == false) {
			 System.out.println("Error: La fecha no coincide con la especificacion requerida");
			 System.out.println("Error: solo numeros y letras del entre 6 y 15 caracteres");
			 return;
		 }
		
		emp.setNombre(nombre);
		emp.setApellidos(apellidos);
		emp.setEmail(email);
		emp.setUser(user);
		emp.setPassword(pass);
		emp.setF_nacimiento(date);

        existe_usuario = daoEmpleados.comprobarUsarioExistente(emp);
        
        if(existe_usuario == true) {
        	
        	response.setContentType("text/plain");
    		response.getWriter().write("Ya existe un usuario con este nombre");
    		return;
        }
        
        try {
        	
        	daoEmpleados.insertar(emp);
        	
        } catch (ParseException e) {
        	System.out.println("Error al introducir en la base de datos");
			e.printStackTrace();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setDaoEmpleados(DAOEmpleado daoEmpleados) {
		this.daoEmpleados = daoEmpleados;
	}

	public void initDao () {
		setDaoEmpleados((DAOEmpleado) this.getServletContext().getAttribute("daoEmpleados"));
	}
		
}
