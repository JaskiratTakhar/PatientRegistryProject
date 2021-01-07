package com.fdmgroup.dao;



import com.fdmgroup.model.User;

public interface IUserDao extends IStorage<User>,IEditable<User>, IRemovable<User>{
 
	public User findByUserName(String username);

	
	
}
