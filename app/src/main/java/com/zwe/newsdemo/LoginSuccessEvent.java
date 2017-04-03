package com.zwe.newsdemo;

/**
 * Created by Asus on 2017/4/2.
 */

public class LoginSuccessEvent {
    private String user;
    public LoginSuccessEvent(String user){
        this.user=user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }
}
