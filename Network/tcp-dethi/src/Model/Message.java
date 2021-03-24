/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Khoi
 */
public class Message implements Serializable{
    private static final long serialVersionUID = 1L;
    private int type;
    private Object obj;
    private ArrayList<SinhVien> sv;

    public Message() {
    }

    public Message(int type,ArrayList<SinhVien> sv) {
        this.type = type;
        this.sv = sv;
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

    public ArrayList<SinhVien> getSv() {
        return sv;
    }
    
}
