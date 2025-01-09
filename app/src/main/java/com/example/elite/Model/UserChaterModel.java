package com.example.elite.Model;

public class UserChaterModel {
    int User_img;
    String User_username,User_lastMsg;

    public int getUser_img() {
        return User_img;
    }

    public void setUser_img(String user_img) {
        User_img = Integer.parseInt(user_img);
    }

    public String getUser_username() {
        return User_username;
    }

    public void setUser_username(String user_username) {
        User_username = user_username;
    }

    public String getUser_lastMsg() {
        return User_lastMsg;
    }

    public void setUser_lastMsg(String user_lastMsg) {
        User_lastMsg = user_lastMsg;
    }

    public UserChaterModel(int user_img, String user_username, String user_lastMsg) {
        User_img = user_img;
        User_username = user_username;
        User_lastMsg = user_lastMsg;
    }
}
