package sinhvien;

import java.util.Scanner;

public class Sv {
    private int ma;
    private String ten;
    private String lop;
    private double dtb;
    public Sv() {
    }
    public Sv(int ma, String ten, String lop, double dtb) {
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
        this.dtb = dtb;
    }
    public int getMa() {
        return ma;
    }
    public void setMa(int ma) {
        this.ma = ma;
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public String getLop() {
        return lop;
    }
    public void setLop(String lop) {
        this.lop = lop;
    }
    public double getDtb() {
        return dtb;
    }
    public void setDtb(double dtb) {
        this.dtb = dtb;
    }
    public void nhap(){
        
    }
    public String toString() {
        return this.ma+" "+this.ten+" "+this.lop+" "+this.dtb;
    }
}
