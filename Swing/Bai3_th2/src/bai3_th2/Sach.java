package bai3_th2;
public class Sach {
    private int maSach;
    private String tenSach;
    private String loaiSach;
    private double giaBan;
    public Sach() {
    }
    public Sach(int maSach, String tenSach, String loaiSach, double giaBan) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.loaiSach = loaiSach;
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
    public String getLoaiSach() {
        return loaiSach;
    }
    public void setLoaiSach(String loaiSach) {
        this.loaiSach = loaiSach;
    }
    public double getGiaBan() {
        return giaBan;
    }
    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }
    @Override
    public String toString() {
        return this.maSach+"\n"+this.tenSach+"\n"+this.loaiSach+"\n"+this.giaBan;
    }
    
    
}
