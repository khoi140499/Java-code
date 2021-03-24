package de1_baithuchanh2;
public class SinhVien {
    private int maSV;
    private String ten;
    private String lop;
    private double dtb;
    public SinhVien() {
    }
    public SinhVien(int maSV, String ten, String lop, double dtb) {
        this.maSV = maSV;
        this.ten = ten;
        this.lop = lop;
        this.dtb = dtb;
    }
    public int getMaSV() {
        return maSV;
    }
    public void setMaSV(int maSV) {
        this.maSV = maSV;
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
    public String toString(){
        return this.maSV+" "+this.ten+" "+this.lop+" "+this.dtb;
    }
}
