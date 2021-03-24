/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frmsocket;

import java.io.Serializable;

/**
 *
 * @author Khoi
 */
public class User implements Serializable{
    private String user;
    private String pass;

    public User() {
    }

    public User(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
    
}
