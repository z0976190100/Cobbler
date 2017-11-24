package com.daProject.dao.entity;
import javax.servlet.http.Cookie;
import java.net.HttpCookie;

public class Errors {
    public static Cookie roleIdentifier = new Cookie("roleIdentifier", "none");
    public static String errorMessage;
public static volatile boolean multiplayerCheck = false;

}
