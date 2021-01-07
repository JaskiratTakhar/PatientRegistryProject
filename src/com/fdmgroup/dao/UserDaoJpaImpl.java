package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.EntityManager;


import com.fdmgroup.dao.IUserDao;
import com.fdmgroup.model.Appointment;
import com.fdmgroup.model.User;
import com.fdmgroup.util.JpaUtility;

public class UserDaoJpaImpl implements IUserDao {
	
	

	@Override
	public void createTable(User t) {
		
	System.out.println(t);		
	JpaUtility jpa = JpaUtility.getInstance();
	EntityManager em = jpa.getEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();				
	}

	@Override
	public User findByUserName(String username) {	
		JpaUtility jpa = JpaUtility.getInstance();
		EntityManager em = jpa.getEntityManager();
		em.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<User> user =  em.createNamedQuery("User.findAllUsers").setParameter("lName", username).getResultList();
		 
		if(user != null && user.size()==1) {
			em.getTransaction().commit();
				return user.get(0);		
				
				}
		em.getTransaction().commit();
		return null;
		
	}

	@Override
	public void createBookingTable(Appointment appointment) {
		JpaUtility jpa = JpaUtility.getInstance();
		EntityManager em = jpa.getEntityManager();
		System.out.println(appointment);	
		em.getTransaction().begin();	
		em.persist(appointment);
		em.getTransaction().commit();			
	}

	@Override
	public void enterDataInBookingTable(Appointment appointment) {
		//This method is implemented in AppointmentDao
		
	}
	
}
