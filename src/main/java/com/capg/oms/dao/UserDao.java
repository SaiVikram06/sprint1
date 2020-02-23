package com.capg.oms.dao;

import java.util.List;
import java.util.Map;

import com.capg.oms.model.User;

public interface UserDao {
	
	public boolean addUser(User user);
	public Map<Long,User> getAdmin();
	public Map<Long,User> getCustomer();
	public User viewAdmin(long userId);
	public User viewCustomer(long userId);
	public void addSomeAdmins();
	public void addSomeCustomers();

}
