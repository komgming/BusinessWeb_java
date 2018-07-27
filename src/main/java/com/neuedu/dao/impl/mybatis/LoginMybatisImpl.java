package com.neuedu.dao.impl.mybatis;

import com.neuedu.dao.ILoginDao;
import com.neuedu.entity.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class LoginMybatisImpl implements ILoginDao {
    @Override
    public Account doLogin(String _username, String _password) {

        String resource = "mybatis-config.xml";

        Reader reader = null;

        SqlSession session;

        try  {

            reader = Resources.getResourceAsReader(resource);

        } catch (IOException e)  {

            // TODO Auto-generated  catch block

            e.printStackTrace();

        }

        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder()

                .build (reader);

        session = sqlMapper.openSession();
        /**
         * argsl:namespace+id
         * */
        Map<String,String> map=new HashMap<String, String>();
        map.put("username",_username);
        map.put("passowrd",_password);
        Account account= session.selectOne("com.neuedu.entity.Account.findByUsernameAndPassword",map);

        System.out.println(account);
        session.close();




        return account;
    }

    @Override
    public void addToken(String token, Account acc) {

    }

    @Override
    public String findTokenAccountId(int accountid) {
        return null;
    }
}
