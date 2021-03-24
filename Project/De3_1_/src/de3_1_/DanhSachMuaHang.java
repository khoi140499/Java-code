/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de3_1_;

/**
 *
 * @author Dang Khoi
 */
public class DanhSachMuaHang {
    private String tenKH;
    private String tenMH;
    private int soLuong;
    private double gia;

    public DanhSachMuaHang(String tenKH, String tenMH, int soLuong, double gia) {
        this.tenKH = tenKH;
        this.tenMH = tenMH;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public String getTenKH() {
        return tenKH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double getGia() {
        return gia;
    }

    @Override
    public String toString() {
        return this.tenKH+"\r\n"+this.tenMH+"\r\n"+this.soLuong+"\r\n"+this.gia;
    }
    
}
