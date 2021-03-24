/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de6_;

import java.io.Serializable;

/**
 *
 * @author Dang Khoi
 */
public class PhongHoc implements Serializable{
    private int ma;
    private String tenPhong;
    private int soGhe;

    public PhongHoc(int ma, String tenPhong, int soGhe) {
        this.ma = ma;
        this.tenPhong = tenPhong;
        this.soGhe = soGhe;
    }

    public int getMa() {
        return ma;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public int getSoGhe() {
        return soGhe;
    }
    
}
