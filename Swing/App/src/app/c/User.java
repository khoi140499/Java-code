/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.c;

/**
 *
 * @author Dang Khoi
 */
public class User {
    private int stt;
    private String user;

    public User() {
    }

    public User(int stt, String user) {
        this.stt = stt;
        this.user = user;
    }

    public int getStt() {
        return stt;
    }

    public String getUser() {
        return user;
    }

    @Override
    public String toString() {
        return this.stt+" "+this.user;
    }
    
}
