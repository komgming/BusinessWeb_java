package com.neuedu;

import com.neuedu.dao.ILoginDao;

import com.neuedu.dao.impl.mybatis.LoginMybatisImpl;
import org.junit.Test;

public class UserTest {
    @Test
    public  void testDoLogin(){

        ILoginDao loginDao=new LoginMybatisImpl();
        loginDao.doLogin("admin","admin");

    }

}
