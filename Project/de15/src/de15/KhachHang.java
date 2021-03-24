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
public class KhachHang implements Serializable{
    private int maKH;
    private String tenKH;
    private String diaChi;
    private String loaiKH;

    public KhachHang(int maKH, String tenKH, String diaChi, String loaiKH) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.loaiKH = loaiKH;
    }

    public int getMaKH() {
        return maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getLoaiKH() {
        return loaiKH;
    }
    
}
