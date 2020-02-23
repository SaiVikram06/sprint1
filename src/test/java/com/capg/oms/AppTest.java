
package com.capg.oms;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capg.oms.dao.UserDao;
import com.capg.oms.dao.UserDaoImpl;
import com.capg.oms.model.User;
import com.capg.oms.service.InvalidDetailsException;
import com.capg.oms.service.UserService;
import com.capg.oms.service.UserServiceImpl;


public class AppTest
{
UserDao dao=new UserDaoImpl();
UserService service=new UserServiceImpl();
static Map<Long,User> userList=new HashMap<Long , User>();
static Map<Long,User> userList2=new HashMap<Long , User>();
static User user;

@Before
public static void addSomeAdmins() {
User user=new User(1234L,"Vikram","dfgh456",9876543211L,"vikram123@gmail.com");
userList.put(user.getUserId(),user);
}

@Test
public void testGetAdmin() {
assertEquals(userList, service.getAdmin());
}

@Before
public static void addSomeCustomers() {
User customer1=new User(123456L,"Vikram","vikram123",9876543213L,"vikram@gmail.com");
userList2.put(customer1.getUserId(),customer1);
}

@Test
public void testGetCustomer() {
assertEquals(userList, service.getCustomer());
}

	/*
	 * @Test public void testValidateCustomerEmail() throws InvalidDetailsException
	 * { assertEquals(userList2, service.validateEmail("vikram@gmail.com")); }
	 * 
	 * @Test public void testValidateCustomerPassword() throws
	 * InvalidDetailsException { assertEquals(userList2,
	 * service.validatePhoneNo(9876543213L)); }
	 */

@Test
public void testViewAdmin() {
assertEquals(user, service.viewAdmin(1234L));
}

@Test
public void testViewCustomer() {
assertEquals(user, service.viewCustomer(123456L));
}


}