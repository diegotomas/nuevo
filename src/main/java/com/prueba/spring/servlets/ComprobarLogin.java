package com.prueba.spring.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prueba.spring.dao.DAOEmpleado;
import com.prueba.spring.model.Empleado;

/**
 * Servlet implementation class ComprobarLogin
 */
public class ComprobarLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOEmpleado daoEmpleados;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComprobarLogin() {
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
		
		boolean existe_user = false;
		boolean existe_pass = false;
		
		Empleado emp = new Empleado();
		
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		if(user != null) {
			emp.setUser(user);
			existe_user = daoEmpleados.comprobarUsarioExistente(emp);
			if(existe_user == true) {
	        	
	        	response.setContentType("text/plain");
	    		response.getWriter().write("Ya existe un usuario con este nombre");
	    		return;
	    		
	        }else {
	        	response.setContentType("text/plain");
	    		response.getWriter().write("Usuario valido");
	    		return;
	        }
		}
		
		if(pass != null) {
			emp.setEmail(pass);
			existe_pass = daoEmpleados.comprobarEmailExistente(emp);
			if(existe_pass == true) {
	        	
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
