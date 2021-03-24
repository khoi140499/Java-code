/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de15;

import java.io.Serializable;

/**
 *
 * @author Dang Khoi
 */
public class HoaDon implements Serializable{
    private String tenKH;
    private String tenDV;
    private int soLuong;
    private double giaDV;

    public HoaDon(String tenKH, String tenDV, int soLuong, double giaDV) {
        this.tenKH = tenKH;
        this.tenDV = tenDV;
        this.soLuong = soLuong;
        this.giaDV = giaDV;
    }

    public String getTenKH() {
        return tenKH;
    }

    public String getTenDV() {
        return tenDV;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double getGiaDV() {
        return giaDV;
    }
    
}
