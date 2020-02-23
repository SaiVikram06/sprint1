package com.capg.oms.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capg.oms.model.User;

public class UserDaoImpl implements UserDao {

	public static Map<Long,User> userList=new HashMap<Long , User>();
	public static Map<Long,User> userList2=new HashMap<Long , User>();
	public void addSomeAdmins() {
		User admin1=new User(1234L,"Vikram1","dfgh456",9876543211L,"vikram123@gmail.com");
		User admin2=new User(1235L,"Harsha1","34fsgj",9876543212L,"harsha123@gmail.com");
		userList.put(admin1.getUserId(),admin1);
		userList.put(admin2.getUserId(),admin2);
	}
	
	public void addSomeCustomers() {
		User customer1=new User(123456L,"Vikram","vikram123",9876543213L,"vikram@gmail.com");
		User customer2=new User(123567L,"Harsha","harsha143",9876543214L,"harsha@gmail.com");
		userList2.put(customer1.getUserId(),customer1);
		userList2.put(customer2.getUserId(),customer2);
	}
	

	public boolean addUser(User user) {
		if(userList.containsKey(user.getUserId())){
			return false;
		}
		userList.put(user.getUserId(), user);
		return true;
	}


	public Map<Long, User> getAdmin() {
		return userList;
	}
	
	public Map<Long, User> getCustomer() {
		return userList2;
	}
	
	
	public User viewAdmin(long userId) {
		
		if(userList.containsKey(userId)) {
			return userList.get(userId);
		}
		return null;
	}
public User viewCustomer(long userId) {
		
		if(userList2.containsKey(userId)) {
			return userList2.get(userId);
		}
		return null;
	}



	
}
