package com.prueba.spring.servlets;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.prueba.spring.model.Empleado;

public class DatosUsuarioTest extends BaseJSON{
	
	
	
	@Test
    public void testGet() throws Exception {
		
		StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
		servlet.doGet(request, response);
        
        String result = stringWriter.toString();
        
        Assert.assertEquals("",result);
	}
	
	
	@Test
    public void testEmpNull() throws Exception {
		
        when(request.getParameter("id")).thenReturn(String.valueOf(-1));
        
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        servlet.doPost(request, response);
        
        String result = stringWriter.toString();
        Assert.assertEquals("",result);
        
	}
	
	
	
	@Test
    public void testServlet() throws Exception {
		
		List<Empleado> listaEmpleados = daoEmpleado.devolverEmpleados();
		Assert.assertFalse(listaEmpleados.isEmpty());
		
		int valorId = listaEmpleados.get(0).getId();
		
		//when(servletContext.getAttribute("daoEmpleados")).thenReturn(resources);	
        when(request.getParameter("id")).thenReturn(String.valueOf(valorId));

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        servlet.doPost(request, response);
        
        JsonObject json = new JsonObject();
		json.addProperty("id",listaEmpleados.get(0).getId());
		json.addProperty("nombre",listaEmpleados.get(0).getNombre());
		json.addProperty("apellidos",listaEmpleados.get(0).getApellidos());
		json.addProperty("email",listaEmpleados.get(0).getEmail());
		json.addProperty("user",listaEmpleados.get(0).getUser());
		json.addProperty("password",listaEmpleados.get(0).getPassword());

		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");
		String s = formatter.format(listaEmpleados.get(0).getF_nacimiento());

		json.addProperty("f_nacimiento",s);
		
		Gson gson = new Gson();  
	    String jsonEmpleado = gson.toJson(json);
	    
//	    StringWriter sw = new StringWriter();
//		PrintWriter pw  =new PrintWriter(sw);
//		String lista = sw.toString();
//		System.out.println(lista);
//		JsonObject obj = new JsonParser().parse(lista).getAsJsonObject();
		
	    //PrintWriter out = response.getWriter();
	    String result = stringWriter.toString();
	    Assert.assertEquals(jsonEmpleado,result);
	    
        
        //assertTrue(stringWriter.toString().contains("prueba"));
        //assertNotNull(response);
    }
	

}
