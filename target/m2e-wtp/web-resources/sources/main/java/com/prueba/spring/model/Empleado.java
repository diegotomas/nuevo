package com.prueba.spring.model;

import java.io.Serializable;
import java.util.Date;

public class Empleado implements Serializable{
	
	private int id;
	
	private String nombre;
	
	private String apellidos;
	
	private String email;
	
	private String user;
	
	private String password;
	
	private Date f_nacimiento;
	
	private String rol;

	public Empleado(){
		
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", user="
				+ user + ", password=" + password + ", f_nacimiento=" + f_nacimiento + "]";
	}

	public Empleado(int id, String nombre, String apellidos, String email, String user, String password, Date f_nacimiento, String rol) {

		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.user = user;
		this.password = password;
		this.f_nacimiento = f_nacimiento;
		this.rol = rol;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getF_nacimiento() {
		return f_nacimiento;
	}

	public void setF_nacimiento(Date f_nacimiento) {
		this.f_nacimiento = f_nacimiento;
	}
	
	public boolean isAdmin() {
		return this.getRol().equalsIgnoreCase("A");
	}
	
}
