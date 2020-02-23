package com.capg.oms.service;

import com.capg.oms.ui.LoginUser;

public class InvalidDetailsException extends Exception{

	public InvalidDetailsException(String message) {
		super(message);
	}

}
