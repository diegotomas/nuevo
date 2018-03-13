package com.prueba.spring.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ibm.db2.jcc.am.ep;
import com.prueba.spring.dao.DAOEmpleado;
import com.prueba.spring.model.Empleado;

/**
 * Servlet implementation class DevolverEmpleados
 */
public class DevolverEmpleados extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private DAOEmpleado daoEmpleados;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DevolverEmpleados() {
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
		
		List<Empleado> ListaEmpleados = new ArrayList<Empleado>();
		
	    //JsonObject jsonObject = new JsonObject();
	    //jsonObject.addProperty("user", "diego");
	    //jsonObject.addProperty("id", "452352345");
	    //jsonObject.addProperty("nombre", "Diego");
	    
	    //String json = new Gson().toJson(jsonObject);

	    //response.setContentType("application/json");
	    //response.setCharacterEncoding("UTF-8");
	    //response.getWriter().write(json);
	    
	    ListaEmpleados = (ArrayList<Empleado>) daoEmpleados.devolverEmpleados();
	    //String jsonStudents = Gson.toJson(ListaEmpleados);
	    JsonArray jArray = new JsonArray();
	    for (Empleado empleado : ListaEmpleados) {
			JsonObject json = new JsonObject();
			json.addProperty("id", empleado.getId());
			int idValue = empleado.getId();
			json.addProperty("nombre", empleado.getNombre());
			json.addProperty("apellidos", empleado.getApellidos());
			json.addProperty("email", empleado.getEmail());
			json.addProperty("user", empleado.getUser());
			json.addProperty("password", empleado.getPassword());
			json.addProperty("f_nacimiento", empleado.getF_nacimiento().toString());
			String rol= empleado.getRol();

			json.addProperty("edit", "<span>\r\n" + " <input type=\"button\" class=\"button\" value=\"Editar\" onclick=\" showModal('"+idValue+"','"+rol+"') \" />\r\n" + "</span>");
			json.addProperty("delete", "<span>\r\n" + " <input type=\"button\" class=\"button\" value=\"Eliminar\" />\r\n" + "</span>");
			
			jArray.add(json);
		}
	    Gson gson = new Gson();  
	    String jsonEmpleados = gson.toJson(jArray);
	    
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(jsonEmpleados);
	    System.out.println(jsonEmpleados);
	}
	
	public void setDaoEmpleados(DAOEmpleado daoEmpleados) {
		this.daoEmpleados = daoEmpleados;
	}

	public void initDao () {
		setDaoEmpleados((DAOEmpleado) this.getServletContext().getAttribute("daoEmpleados"));
	}
}
