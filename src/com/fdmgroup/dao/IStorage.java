package com.fdmgroup.dao;



import com.fdmgroup.model.Appointment;
import com.fdmgroup.model.IStorable;

public interface IStorage <T extends IStorable>{
       public void createTable(T t);

	

	void createBookingTable(Appointment appointment);
	 void enterDataInBookingTable(Appointment appointment);
}
