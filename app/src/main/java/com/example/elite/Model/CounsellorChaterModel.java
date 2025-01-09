package com.example.elite.Model;

public class CounsellorChaterModel {
    int img;
    String username,lastmsg;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastmsg() {
        return lastmsg;
    }

    public void setLastmsg(String lastmsg) {
        this.lastmsg = lastmsg;
    }

    public CounsellorChaterModel(int img, String username, String lastmsg) {
        this.img = img;
        this.username = username;
        this.lastmsg = lastmsg;
    }



}
