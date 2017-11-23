package com.daProject.manager.executable;

import com.daProject.dao.entity.User;
import com.daProject.dao.hibernateFactory.Factory;

import java.sql.SQLException;
import java.util.Map;


public class LoginManager {

    public String[] loginController(Map<String, String[]> paramMap) throws Exception {
        String[] resultData = new String[2];
        String phoneneumber = paramMap.get("phoneneumber")[0];
        String secret = paramMap.get("secret")[1];
        User currentUser = null;
        try {
            currentUser = Factory.getInstance().getUserDAO().getUserByPhonenumber(phoneneumber);
        } catch (SQLException e) {
            System.err.println("Enable to connect");
            e.printStackTrace();
        } finally {


            if (currentUser != null) {
                String tempPassword = currentUser.getPassword();
                if (secret.equals(tempPassword)) {
                    resultData[0] = "sucksess"; //currentUser.getFirstName();
                    resultData[1] = String.valueOf(currentUser.getId());

                    return resultData;
                }
          /*  } throw new Exception();
        }else{
            throw new Exception();
        }*/


            }


        }
        return null;
    }
}