package QuanLyCongNhan;

import java.io.Serializable;

public class SanPham implements Serializable{
    private int maSP;
    private String tenSP;
    private String nhomSP;
    private double giaSP;

    public SanPham() {
    }

    public SanPham(int maSP, String tenSP, String nhomSP, double giaSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.nhomSP = nhomSP;
        this.giaSP = giaSP;
    }

    public int getMaSP() {
        return maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public String getNhomSP() {
        return nhomSP;
    }

    public double getGiaSP() {
        return giaSP;
    }
    
}
