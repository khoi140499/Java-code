package de3;
public class SanPham {
    //mã SP, tên SP, nhóm SP, đơn giá
    private int maSP;
    private String tenSP;
    private String nhomSP;
    private double donGia;

    public SanPham() {
    }

    public SanPham(int maSP, String tenSP, String nhomSP, double donGia) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.nhomSP = nhomSP;
        this.donGia = donGia;
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

    public double getDonGia() {
        return donGia;
    }
    
    @Override
    public String toString() {
        return this.maSP+"\r\n"+this.tenSP+"\r\n"+this.nhomSP+"\r\n"+this.donGia;
    }
    
}
