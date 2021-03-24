/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3_2.mathang;

/**
 *
 * @author Dang Khoi
 */
public class MatHang {
    private int maHang;
    private String tenHang;
    private String nhomHang;
    private double gia;

    public MatHang() {
    }

    public MatHang(int maHang, String tenHang, String nhomHang, double gia) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.nhomHang = nhomHang;
        this.gia = gia;
    }

    public int getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public String getNhomHang() {
        return nhomHang;
    }

    public double getGia() {
        return gia;
    }

    @Override
    public String toString() {
        return this.maHang+"\r\n"+this.tenHang+"\r\n"+this.nhomHang+"\r\n"+this.gia;
    }
    
}
