/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de1;

import java.io.Serializable;

/**
 *
 * @author Dang Khoi
 */
public class Sach implements Serializable{
    private int maSach;
    private String tenSach;
    private String tacGia;
    private String chuyenNghanh;
    private int namXB;
    private int soLuong;

    public Sach(int maSach, String tenSach, String tacGia, String chuyenNghanh, int namXB, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.chuyenNghanh = chuyenNghanh;
        this.namXB = namXB;
        this.soLuong = soLuong;
    }

    public int getMaSach() {
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public String getChuyenNghanh() {
        return chuyenNghanh;
    }

    public int getNamXB() {
        return namXB;
    }

    public int getSoLuong() {
        return soLuong;
    }
    
}
