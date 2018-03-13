package com.prueba.spring.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;

import com.prueba.spring.dao.DAOEmpleado;
import com.prueba.spring.model.Empleado;

/**
 * Servlet implementation class ControladorAcceso
 */
public class ControladorAcceso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOEmpleado daoEmpleados;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorAcceso() {
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
		
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		boolean es_admin;
		boolean existe_usuario = false;
		boolean existe_user = false;
		boolean existe_pass = false;
		
		Empleado emp = new Empleado();
		
		if (user.isEmpty() || (user == null) || pass.isEmpty() || (pass == null)) {
		
			System.out.println("Error: alguno de los campos esta vacio");
			return;
		}
		
		 Pattern user_regex = Pattern.compile("[a-zA-Z0-9]{5,15}");
		 Pattern pass_regex = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,20}$");
		 
		 Matcher m_user = user_regex.matcher(user);
		 Matcher m_pass = pass_regex.matcher(pass);
		 

		 boolean bool_user = m_user.matches();
		 boolean bool_pass = m_pass.matches();
		 
		 if(bool_user == false) {
			 System.out.println("Error: El usuario no coincide con la especificacion requerida");
			 System.out.println("Error: solo numeros y letras del entre 6 y 15 caracteres");
			 return;
		 }
		 if(bool_pass == false) {
			 System.out.println("Error: La contraseña no coincide con la especificacion requerida");
			 return;
		 }
		 
		 if(user != null) {
			 	Empleado e;
				try {
					e = daoEmpleados.getEmpleadoByUser(user);
					if(e.isAdmin()) {
				 		request.getRequestDispatcher("/MainPageA.jsp").forward(request, response);
				 	}
				 	else {
				 		request.getRequestDispatcher("/MainPageV.jsp").forward(request, response);
				 	}
					
				} catch (HibernateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 	
			 	
			}
		 
		 response.setContentType("text/plain");
 		response.getWriter().write("Usuario valido");
 		return;
			
			
		 
		
		
	}
	
	public void setDaoEmpleados(DAOEmpleado daoEmpleados) {
		this.daoEmpleados = daoEmpleados;
	}

	public void initDao () {
		setDaoEmpleados((DAOEmpleado) this.getServletContext().getAttribute("daoEmpleados"));
	}
}
