package com.prueba.spring.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.impl.SessionImpl;
import org.springframework.orm.hibernate3.HibernateOperations;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.prueba.spring.model.Empleado;
import com.prueba.spring.utils.HibernateUtil;

public class DAOEmpleado extends HibernateDaoSupport {
	
	private HibernateOperations hibernateOperations;
	
	public HibernateOperations getHibernateOperations() {
		if(hibernateOperations != null) {
			return hibernateOperations;
		}
		return getHibernateTemplate();
	}

	public void setHibernateOperations(HibernateOperations hibernateOperations) {
		this.hibernateOperations = hibernateOperations;
	}

	public void insertar(Empleado emp) throws HibernateException, SQLException {

//		SessionFactory sf = HibernateUtil.getSessionFactory();
//		Session sesion = sf.openSession();
//		Transaction tx = sesion.beginTransaction();
//		sesion.saveOrUpdate(emp);
//		tx.commit();
//		sesion.close();
		getHibernateOperations().save(emp);
	}

	public List<Empleado> leer() throws HibernateException, SQLException {


		List<Empleado> lista = getHibernateOperations().find("from Empleado");

		return lista;
	}

	public boolean comprobarUsarioExistente(Empleado emp) {
		boolean result = false;
		
		List<Empleado> list = getHibernateOperations().findByNamedParam("from Empleado where (:user)", "user", emp.getUser());
		
//		SessionFactory sf = HibernateUtil.getSessionFactory();
//		Session sesion = sf.openSession();
//		Query query = sesion.createQuery("from Empleado where user = :user ");
//		query.setParameter("user", emp.getUser());
//		List<Empleado> list = query.list();
		
		if (!list.isEmpty()) {
			result = true;
		}
		return result;
	}

	public boolean comprobarEmailExistente(Empleado emp) {
		boolean result = false;
		List<Empleado> list = getHibernateOperations().findByNamedParam("from Empleado where (:email)", "email", emp.getEmail());
//		SessionFactory sf = HibernateUtil.getSessionFactory();
//		Session sesion = sf.openSession();
//
//		Query query = sesion.createQuery("from Empleado where email = :email ");
//		query.setParameter("email", emp.getEmail());
//		List<Empleado> list = query.list();
		if (!list.isEmpty()) {
			result = true;
		}
		return result;
	}

	public List<Empleado> devolverEmpleados() {
		
		List<Empleado> listaEmpleados = getHibernateOperations().find("from Empleado");

//		SessionFactory sf = HibernateUtil.getSessionFactory();
//		Session sesion = sf.openSession();
//		Query query = sesion.createQuery("from Empleado");
//
//		ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>(query.list());

		return listaEmpleados;

	}

	public boolean comprobarAdmin(Empleado emp) throws HibernateException, SQLException {

		List<Empleado> list = getHibernateOperations().findByNamedParam("from Empleado where (:user)", "user", emp.getUser());
//		SessionFactory sf = HibernateUtil.getSessionFactory();
//		Session sesion = sf.openSession();
//		Query query = sesion.createQuery("select * from Empleado E where E.user= :user");
//		query.setParameter("user", emp.getUser());
//		List<Empleado> list = query.list();
		if (!list.isEmpty()) {
			String resultado = list.get(0).getRol();

			return resultado.equalsIgnoreCase("A");
		} else {
			return false;
		}

	}

	public Empleado getEmpleadoByUser(String user) throws HibernateException, SQLException {

//		SessionFactory sf = HibernateUtil.getSessionFactory();
//		Session sesion = sf.openSession();
//		Query query = sesion.createQuery("from Empleado where user= :user");
//		query.setParameter("user", user);
//		List<Empleado> list = query.list();
		
		List<Empleado> list = getHibernateOperations().findByNamedParam("from Empleado where (:user)", "user", user);
		if (!list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public Empleado getEmpleadoById(int id) throws HibernateException, SQLException {

//		SessionFactory sf = HibernateUtil.getSessionFactory();
//		Session sesion = sf.openSession();
//		Query query = sesion.createQuery("from Empleado where id= :id");
//		query.setParameter("id", id);
//		List<Empleado> list = query.list();
		List<Empleado> list = getHibernateOperations().findByNamedParam("from Empleado where id = :id", "id", id);

		if (!list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public void actualizarEmpleado(Empleado emp) throws HibernateException, SQLException {
		getHibernateOperations().update(emp);
	}
}
