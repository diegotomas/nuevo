package com.prueba.spring.servlets;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.prueba.spring.dao.DAOEmpleado;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")

public class BaseJSON extends Mockito{
	
	@Mock
	HttpServletRequest request;   
	@Mock
    HttpServletResponse response;
	@Mock
	public ServletContext servletContext;

	@Autowired
	public DAOEmpleado daoEmpleado;
	
	public DatosUsuario servlet = new DatosUsuario(){
		public ServletContext getServletContext(){
			return servletContext;
		}
	};
	
	
	
	@Before
	public void beforeServlet() throws Exception{
		
		MockitoAnnotations.initMocks(this);
		when(servletContext.getAttribute("daoEmpleados")).thenReturn(daoEmpleado);
		request = mock(HttpServletRequest.class);       
	    response = mock(HttpServletResponse.class);

	    	
	}

}
