/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frmloginsocket;

import java.io.Serializable;

/**
 *
 * @author Khoi
 */
public class User implements Serializable{
    private String username;
    private String pass;

    public User() {
    }

    public User(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }
    
}
