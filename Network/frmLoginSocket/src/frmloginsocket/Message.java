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
public class Message implements Serializable{
    private int type;
    private Object object;

    public Message() {
    }

    public Message(int type, Object object) {
        this.type = type;
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public int getType() {
        return type;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public void setType(int type) {
        this.type = type;
    }
    
}
