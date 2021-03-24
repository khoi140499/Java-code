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
public class KhachHang {
    private int ma;
    private String ten;
    private String diaChi;
    private int sdt;

    public KhachHang(int ma, String ten, String diaChi, int sdt) {
        this.ma = ma;
        this.ten = ten;
        this.diaChi = diaChi;
        this.sdt = sdt;
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

    public int getSdt() {
        return sdt;
    }

    @Override
    public String toString() {
        return this.ma+"\r\n"+this.ten+"\r\n"+this.diaChi+"\r\n"+this.sdt;
    }
    
}
