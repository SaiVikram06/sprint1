package com.capg.oms.service;

import java.util.List;
import java.util.Map;

import com.capg.oms.model.User;

public interface UserService {
	
	public void initialAdminList();
	public void initialCustomerList();
	public boolean addUser(User user);
	public Map<Long,User> getAdmin();
	public Map<Long,User> getCustomer();
	public User viewCustomer(long userId);
	public User viewAdmin(long userId);
	public boolean validatePhoneNo(long phoneNo) throws InvalidDetailsException;
	public boolean validateEmail(String mail) throws InvalidDetailsException;
	public boolean validateCustomerId(long id) throws InvalidDetailsException;
	public boolean validatePassword(String pw) throws InvalidDetailsException;
}
