package de3_baithuchanh2;
public class Sach {
    private int maSach;
    private String tenSach;
    private String chuyenNghanh;
    private double giaBan;
    public Sach() {
    }
    public Sach(int maSach, String tenSach, String chuyenNghanh, double giaBan) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.chuyenNghanh = chuyenNghanh;
        this.giaBan = giaBan;
    }
    public int getMaSach() {
        return maSach;
    }
    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }
    public String getTenSach() {
        return tenSach;
    }
    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }
    public String getChuyenNghanh() {
        return chuyenNghanh;
    }
    public void setChuyenNghanh(String chuyenNghanh) {
        this.chuyenNghanh = chuyenNghanh;
    }
    public double getGiaBan() {
        return giaBan;
    }
    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }
    public String toString(){
        return this.maSach+" "+this.tenSach+" "+this.chuyenNghanh+" "+this.giaBan+" VND";
    }
}
