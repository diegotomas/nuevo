package com.prueba.spring.servlets;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.impl.SessionImpl;

import com.prueba.spring.model.Empleado;
import com.prueba.spring.utils.HibernateUtil;
import com.prueba.spring.dao.*;


/**
 * Servlet implementation class Prueba
 */
public class Prueba extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static EntityManager manager;
	private static EntityManagerFactory emf;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prueba() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = this.getServletContext();
		
		//Session session = HibernateUtil.getSessionFactory().openSession();
		
//		Empleado emp = new Empleado();
//		List <Empleado> lista;
//		String prueba = "prueba";
//		emp.setNombre(prueba);
//		emp.setApellidos(prueba);
//		emp.setEmail(prueba);
//		emp.setPassword(prueba);
//		emp.setUser(prueba);
//		emp.setF_nacimiento(Calendar.getInstance().getTime());
//		
//		try {
//			DAOEmpleado.insertar(emp);
//			lista = DAOEmpleado.leer();
//			
//			int cont = 1;
//			for(Empleado empleado : lista) {
//				
//				System.out.println("Empleado " + cont + "--->  id:" + empleado.getId() + "nombre: " + empleado.getNombre());
//				cont++;
//			}
//			//session.save(emp);
//			//((SessionImpl)session).connection().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		System.out.println("prueba");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doGet(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void imprimirTodo() {
		
		List <Empleado> empleados = (List<Empleado>) manager.createQuery("FROM Empleado").getResultList();
		System.out.println("En esta base de datos hay " + empleados.size() + "empleados.");
		for(Empleado emp : empleados) {
			
			System.out.println(emp.toString());
		}
	}

}
