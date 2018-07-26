package com.neuedu.service.impl;

import com.neuedu.dao.ILoginDao;
import com.neuedu.dao.impl.jdbc.LoginDaoImpl;
import com.neuedu.entity.Account;
import com.neuedu.service.ILoginService;

public class LoginServiceImpl implements ILoginService{

	ILoginDao loginDao=new LoginDaoImpl();
	
	public Account  doLogin(String  username,String password) {
		//���е�¼��ҵ���߼�����
		 //LoginDao loginDao=new LoginDao(); 
		//LoginDaoMysql loginDao=new LoginDaoMysql();
	
		return loginDao.doLogin(username,password);
		
		
	}

	@Override
	public void addToken(String token, Account acc) {
		// TODO Auto-generated method stub
		
	   loginDao.addToken(token, acc);
	    
	 
	}

	@Override
	public String findTokenAccountId(int accountid) {
		// TODO Auto-generated method stub
		return loginDao.findTokenAccountId(accountid);
	}
	
}
