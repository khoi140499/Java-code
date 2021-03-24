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
public class SinhVien implements Serializable{
    private int ma;
    private String ten;
    private String diaChi;
    private String ngaySinh;
    private String lop;

    public SinhVien(int ma, String ten, String diaChi, String ngaySinh, String lop) {
        this.ma = ma;
        this.ten = ten;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.lop = lop;
    }

    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getLop() {
        return lop;
    }
    
}
