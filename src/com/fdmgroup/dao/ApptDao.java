package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fdmgroup.model.Appointment;
import com.fdmgroup.model.IStorable;

import com.fdmgroup.util.JpaUtility;
import com.fdmgroup.view.DashBoardView;


public class ApptDao implements IStorage<IStorable>{
	private DashBoardView dashBoardView;
	JpaUtility jpa = JpaUtility.getInstance();
	EntityManager em = jpa.getEntityManager();
	

	
//Added a comment
	@Override//////This method persists data into the All_appointment table.
	public void enterDataInBookingTable(Appointment appointment) {
		
		System.out.println(appointment);		
		em.getTransaction().begin();		
		em.persist(appointment);
		em.getTransaction().commit();	
		
	}
	
	@Override
	public void createTable(IStorable t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createBookingTable(Appointment appointment) {
		// TODO Auto-generated method stub
		
	}
	
	public Appointment viewAppointments(int id) throws IndexOutOfBoundsException{						
		try {
			em.getTransaction().begin();		
			@SuppressWarnings("unchecked")
			List<Appointment> appointment =  em.createNamedQuery("Appointment.findAllAppointments").setParameter("lId", id).getResultList();
			 System.out.println(appointment);
			 System.out.println(appointment.size());
			 System.out.println(appointment.get(0));
			if(appointment != null && appointment.size()==1) {
				em.getTransaction().commit();
				return appointment.get(0);		
				}
			em.getTransaction().commit();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("No appointments found!!!!!!!!!!");
			em.getTransaction().commit();
		}
		return null;
		
					
	}

	public void removeAppointments(int id) {
		em.getTransaction().begin();		
//		 @SuppressWarnings("unchecked") 
		Query query =  em.createNamedQuery("Appointment.removeAppointments").setParameter("lId", id);
		query.executeUpdate();
		em.getTransaction().commit();
		
	}

	

	public void setDashBoardView(DashBoardView dashBoardView) {
		this.dashBoardView = dashBoardView;
	}

	public List<Appointment> ScheduleCheck(String doctor, String date, String appointmenttime) throws IndexOutOfBoundsException{try {
		em.getTransaction().begin();		
		Query positionedParameterQuery = em.createNamedQuery("Appointment.CheckAppointmentSchedule");
		positionedParameterQuery.setParameter("dDoctor", doctor);
		positionedParameterQuery.setParameter("dDate", date);
		positionedParameterQuery.setParameter("tTime", appointmenttime);
		@SuppressWarnings("unchecked")
		List<Appointment> appointments = positionedParameterQuery.getResultList();
		 
		if(appointments != null && appointments.size()>= 1) {
			em.getTransaction().commit();
			return appointments ;		
			}
		em.getTransaction().commit();
	} catch (IndexOutOfBoundsException e) {
		System.out.println("No appointments found!!!!!!!!!!");
		em.getTransaction().commit();
	}
	return null;
	}

	

	
}
