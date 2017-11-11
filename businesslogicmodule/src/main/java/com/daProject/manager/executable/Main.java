package com.daProject.manager.executable;

import com.daProject.dao.entity.User;
import com.daProject.dao.entity.ValiData;
import com.daProject.dao.hibernateFactory.Factory;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        User user1 = new User();
        User user2 = new User();

        ValiData valUser1 = new ValiData();
        ValiData valUser2 = new ValiData();



        user1.setFirstName("Cartman");
        user1.setSurName("Eric");
        user1.setAge(12);
        user2.setFirstName("Broflowwwsky");
        user2.setSurName("Kyle");
        user2.setAge(13);



        valUser1.setLogin("login1");
        valUser1.setPass("pass1");
        valUser2.setLogin("login2");
        valUser2.setPass("pass2");
        valUser1.setUser(user1);
        valUser2.setUser(user1);

        Factory.getInstance().getUserDAO().addUser(user1);
        Factory.getInstance().getUserDAO().addUser(user2);


        Factory.getInstance().getValiDataDAO().addValiData(valUser1);
        Factory.getInstance().getValiDataDAO().addValiData(valUser2);

       // user1.setValiData(valUser1);
       // user1.setValiData(user1.getValiData());

        //user1.setValiData(valUser2);
        //user1.setValiData(user1.getValiData());


        /*Factory.getInstance().getUserDAO().updateUser(user1);
        Factory.getInstance().getValiDataDAO().updateValiData(valUser1);
        Factory.getInstance().getValiDataDAO().updateValiData(valUser2);
*/
/*

        Factory.getInstance().getValiDataDAO().addValiData(valUser1);

        user2.setFirstName("Broflowsky");
        user2.setSurName("Kyle");
        user2.setAge(13);
        User userNext = Factory.getInstance().getUserDAO().getUserById(2);
        System.out.println("User  " + userNext.getId());
        System.out.println("User's 2 name is " + Factory.getInstance().getUserDAO().getUserById(userNext.getId()).getFirstName());

        Factory.getInstance().getUserDAO().updateUser(user2);

        User user = Factory.getInstance().getUserDAO().getUserById(1);
        User userNext2 = Factory.getInstance().getUserDAO().getUserById(2);

        System.out.println("User  " + user.getId());
        System.out.println("User's 1 name is " + Factory.getInstance().getUserDAO().getUserById(user.getId()).getFirstName());
        System.out.println("User  " + userNext.getId());
        System.out.println("User's 2 name is " + Factory.getInstance().getUserDAO().getUserById(userNext2.getId()).getFirstName());
*/


    }

}
