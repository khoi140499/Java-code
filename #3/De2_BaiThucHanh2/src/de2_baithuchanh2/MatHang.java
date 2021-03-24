package de2_baithuchanh2;
public class MatHang {
    private int maHang;
    private String ten;
    private String nhom;
    private double giaBan;
    public MatHang() {
    }
    public MatHang(int maHang, String ten, String nhom, double giaBan) {
        this.maHang = maHang;
        this.ten = ten;
        this.nhom = nhom;
        this.giaBan = giaBan;
    }
    public int getMaHang() {
        return maHang;
    }
    public void setMaHang(int maHang) {
        this.maHang = maHang;
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public String getNhom() {
        return nhom;
    }
    public void setNhom(String nhom) {
        this.nhom = nhom;
    }
    public double getGiaBan() {
        return giaBan;
    }
    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }
    public String toString(){
        return this.maHang+" "+this.ten+" "+this.nhom+" "+this.giaBan+" Vnd";
    }
}