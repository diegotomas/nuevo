package com.prueba.spring.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.prueba.spring.dao.DAOEmpleado;
import com.prueba.spring.model.Empleado;

/**
 * Servlet implementation class DatosUsuario
 */
public class DatosUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOEmpleado daoEmpleados;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatosUsuario() {
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
		
		int id = -1;
		if(request.getParameter("id")!=null && 
				StringUtils.isNumeric(request.getParameter("id"))) {
			id = Integer.parseInt(request.getParameter("id"));
		}
		
		Empleado emp;
		try {
			emp = daoEmpleados.getEmpleadoById(id);
			
			if(emp == null) {
				response.getWriter().write("error");
				return;
			}
			
			JsonObject json = new JsonObject();
			json.addProperty("id", id);
			json.addProperty("nombre",emp.getNombre() == null ? "" : emp.getNombre());
			json.addProperty("apellidos", emp.getApellidos() == null ? "" : emp.getApellidos());
			json.addProperty("email",emp.getEmail() == null ? "" : emp.getEmail());
			json.addProperty("user",emp.getUser() == null ? "" : emp.getUser());
			json.addProperty("password",emp.getPassword() == null ? "" : emp.getPassword());
			json.addProperty("f_nacimiento",emp.getF_nacimiento() == null ? "" : emp.getF_nacimiento().toString());
			
			Gson gson = new Gson();  
		    String jsonEmpleado = gson.toJson(json);
			
			response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(jsonEmpleado);
		    String var = response.getCharacterEncoding();
		    
			
			
		} catch (SQLException e) {
			System.out.println("Error, id null");
			response.getWriter().write("error2");
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
