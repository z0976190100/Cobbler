package com.daProject.manager.executable;

import com.daProject.dao.entity.User;
import com.daProject.dao.hibernateFactory.Factory;

import java.sql.SQLException;
import java.util.Map;

/**
 * Created by Nataliya on 17.02.2017.
 */
public class LoginManager {

    public String[] loginController(Map<String, String[]> paramMap) throws Exception {
        String[] resultData = new String [2];
        String name = paramMap.get("login")[0];
        String password = paramMap.get("password")[0];
        User currentUser = null;
        try {
            currentUser = Factory.getInstance().getUserDAO().getUserBySurame(name);
            }catch(SQLException e){
            System.err.println("Enable to connect");
            e.printStackTrace();
        }finally {


        /*if(currentUser!=null){
            String tempPassword = currentUser.getSurName();
            if(password.equals(tempPassword)) {*/
                resultData[0] = "sucksess"; //currentUser.getFirstName();
                resultData[1] = String.valueOf(currentUser.getId());
                return resultData;}
          /*  } throw new Exception();
        }else{
            throw new Exception();
        }*/


    }
}
