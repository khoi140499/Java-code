/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginsocket;

/**
 *
 * @author Khoi
 */
public class User {
    private String usernam;
    private String pass;

    public User() {
    }

    public User(String usernam, String pass) {
        this.usernam = usernam;
        this.pass = pass;
    }

    public String getUsernam() {
        return usernam;
    }

    public String getPass() {
        return pass;
    }

    @Override
    public String toString() {
        return this.usernam+"\r\n"+this.pass;
    }
    
}
