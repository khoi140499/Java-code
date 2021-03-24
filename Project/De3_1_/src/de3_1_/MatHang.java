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
public class MatHang {
    private int ma;
    private String ten;
    private String nhomHang;
    private double gia;
    public MatHang(int ma, String ten, String nhomHang, double gia) {
        this.ma = ma;
        this.ten = ten;
        this.nhomHang = nhomHang;
        this.gia = gia;
    }
    public int getMa() {
        return ma;
    }
    public String getTen() {
        return ten;
    }
    public String getNhomHang() {
        return nhomHang;
    }
    public double getGia() {
        return gia;
    }

    @Override
    public String toString() {
        return this.ma+"\r\n"+this.ten+"\r\n"+this.nhomHang+"\r\n"+this.gia;
    }
    
}
