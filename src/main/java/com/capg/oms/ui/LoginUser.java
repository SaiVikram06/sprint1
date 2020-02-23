package com.capg.oms.ui;

import java.util.Scanner;

import com.capg.oms.model.User;
import com.capg.oms.service.InvalidDetailsException;
import com.capg.oms.service.UserService;
import com.capg.oms.service.UserServiceImpl;

public class LoginUser {
	static Scanner sc=new Scanner(System.in);
	static User user=new User();
	static UserService service=new UserServiceImpl();
	public static void main(String[] args) {
		login();
	}
	
	public static void newUser() {
		
		System.out.println("Enter the userId:");
		long id=sc.nextLong();
		service.initialCustomerList();
		if(service.getCustomer().containsKey(id))
		{
			System.out.println("Exsisted id");
			login();
		}
		
   		try {
			if(service.validateCustomerId(id)) {
				user.setUserId(id);
			}
		System.out.println("Enter the password: ");
		String pw=sc.next()+sc.nextLine();
		if(service.validatePassword(pw)) {
			user.setUserPassword(pw);
		}

		System.out.println("Enter the Name: ");
		String name=sc.next()+sc.nextLine();
		user.setUserName(name);
		
		System.out.println("Enter the phone: ");
		long ph=sc.nextLong();
		if(service.validatePhoneNo(ph)) {
			user.setUserPhone(ph);
		}
		
		System.out.println("Enter the email: ");
		String mail=sc.next()+sc.nextLine();
		if(service.validateEmail(mail)) {
			user.setUserEmail(mail);
		}
		
		
		if(service.addUser(user)) {
			System.out.println("Account created Successfully!!!.....you can login into your account now");
			login();
		}
		else {
			System.out.println("User id already exists....");
			login();
		}
		}
		catch (InvalidDetailsException e1) {
			System.out.println(e1.getMessage());
		}
		
	}

	public static void customerLogin() {
		service.initialCustomerList();
		System.out.println("Enter the userId: ");
		long cId = sc.nextLong();
		String cPw=null ;
		if(service.getCustomer().containsKey(cId)) {
			System.out.println("Enter the password: ");
			cPw = sc.next()+sc.nextLine();
			String p=service.viewCustomer(cId).getUserPassword();
			if(p.equals(cPw)) {
				System.out.println("Login Successful");
			}
			else {
					System.out.println("Invalid password!!!.....try again");
					System.out.println("If new user then create a new account...");
					login();
			}
		}
		else {
			System.out.println("Invalid Id");
			System.out.println("If new user then create a new account...");
			login();
		}		
	}
	
	public static void adminLogin() {
		service.initialAdminList();
		System.out.println("Enter the userId: ");
		long aId = sc.nextLong();
		String aPw=null ;
		if(service.getAdmin().containsKey(aId)) {
			System.out.println("Enter the password: ");
			aPw = sc.next()+sc.nextLine();
			String p=service.viewAdmin(aId).getUserPassword();
			if(p.equals(aPw)) {
				System.out.println("Login Successful");
			}
			else {
					System.out.println("Invalid password!!!......try again");
					login();
			}
		}
		else {
			System.out.println("Invalid id");
			login();
		}
	}
	
	public static void login() {
		
		System.out.println("Choose the type of user : ");
		System.out.println("1 - Admin");
		System.out.println("2 - Customer");
		System.out.println("3 - New User");
		int choice=sc.nextInt();
		switch(choice) {
			case 1:
				adminLogin();
				break;
			
			case 2:
				customerLogin();
				break;
				
			case 3:
				newUser();
				break;
				
			default:
				System.out.println("Invalid choice");
		}
	}
}
