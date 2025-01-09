package com.example.elite.Model;

public class CounsellorChatModel {
    int User;
    String message;

    public CounsellorChatModel(int user, String message) {
        User = user;
        this.message = message;
    }

    public int getUser() {
        return User;
    }

    public void setUser(int user) {
        User = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
