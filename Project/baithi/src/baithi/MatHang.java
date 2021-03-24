/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baithi;

/**
 *
 * @author Dang Khoi
 */
public class MatHang {
    private int ma;
    private String tenMa;
    private String nhomMa;
    private double gia;

    public MatHang() {
    }

    public MatHang(int ma, String tenMa, String nhomMa, double gia) {
        this.ma = ma;
        this.tenMa = tenMa;
        this.nhomMa = nhomMa;
        this.gia = gia;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTenMa() {
        return tenMa;
    }

    public void setTenMa(String tenMa) {
        this.tenMa = tenMa;
    }

    public String getNhomMa() {
        return nhomMa;
    }

    public void setNhomMa(String nhomMa) {
        this.nhomMa = nhomMa;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return this.ma+"\r\n"+this.tenMa+"\r\n"+this.nhomMa+"\r\n"+this.gia;
    }
    
}
