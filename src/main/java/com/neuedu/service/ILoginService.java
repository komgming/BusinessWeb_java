package com.neuedu.service;

import com.neuedu.entity.Account;

public interface ILoginService {

	public Account  doLogin(String username, String password);
	
	public void addToken(String toekn, Account acc);
	
	String findTokenAccountId(int accountid);
}
