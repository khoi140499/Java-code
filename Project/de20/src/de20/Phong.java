/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de20;

import java.io.Serializable;

/**
 *
 * @author Dang Khoi
 */
public class Phong implements Serializable{
    private int maPhong;
    private String tenPhong;
    private String loaiPhong;

    public Phong(int maPhong, String tenPhong, String loaiPhong) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.loaiPhong = loaiPhong;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }
    
}
