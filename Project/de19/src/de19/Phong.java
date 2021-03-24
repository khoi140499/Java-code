/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de19;

import java.io.Serializable;

/**
 *
 * @author Dang Khoi
 */
public class Phong implements Serializable{
    private int ma;
    private String tenPhong;
    private String loaiPhong;

    public Phong(int ma, String tenPhong, String loaiPhong) {
        this.ma = ma;
        this.tenPhong = tenPhong;
        this.loaiPhong = loaiPhong;
    }

    public int getMa() {
        return ma;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }
    
}
