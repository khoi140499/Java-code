/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frmlogup;

import java.io.Serializable;

/**
 *
 * @author Khoi
 */
public class Message implements Serializable{
    private int type;
    private Object obj;

    public Message() {
    }

    public Message(int type, Object obj) {
        this.type = type;
        this.obj = obj;
    }

    public int getType() {
        return type;
    }

    public Object getObj() {
        return obj;
    }
    
}
