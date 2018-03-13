package com.prueba.spring.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prueba.spring.dao.DAOEmpleado;
import com.prueba.spring.model.Empleado;
/**
 * Servlet implementation class ComprobarUsuario
 */
public class ComprobarUsuarioEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOEmpleado daoEmpleados;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComprobarUsuarioEmail() {
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
		boolean existe_email = false;
		
		Empleado emp = new Empleado();
		
		String user = request.getParameter("user");
		String email = request.getParameter("email");
		
		if(user != null) {
			emp.setUser(user);
			existe_usuario = daoEmpleados.comprobarUsarioExistente(emp);
			if(existe_usuario == true) {
	        	
	        	response.setContentType("text/plain");
	    		response.getWriter().write("Ya existe un usuario con este nombre");
	    		return;
	    		
	        }else {
	        	response.setContentType("text/plain");
	    		response.getWriter().write("Usuario valido");
	    		return;
	        }
		}
		
		if(email != null) {
			emp.setEmail(email);
			existe_email = daoEmpleados.comprobarEmailExistente(emp);
			if(existe_email == true) {
	        	
	        	response.setContentType("text/plain");
	    		response.getWriter().write("Ya existe un Email con este nombre");
	    		return;
	    		
			}else {
	        	response.setContentType("text/plain");
	    		response.getWriter().write("Email valido");
	    		return;
	        }
		}
	}
	public void setDaoEmpleados(DAOEmpleado daoEmpleados) {
		this.daoEmpleados = daoEmpleados;
	}

	public void initDao () {
		setDaoEmpleados((DAOEmpleado) this.getServletContext().getAttribute("daoEmpleados"));
	}
}
