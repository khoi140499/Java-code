package bai3_3.sach;
public class Sach {
    private int maSach;
    private String tenSach;
    private String loaiSach;
    private double gia;
    public Sach() {
    }
    public Sach(int maSach, String tenSach, String loaiSach, double gia) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.loaiSach = loaiSach;
        this.gia = gia;
    }
    public int getMaSach() {
        return maSach;
    }
    public String getTenSach() {
        return tenSach;
    }
    public String getLoaiSach() {
        return loaiSach;
    }
    public double getGia() {
        return gia;
    }
    @Override
    public String toString() {
        return this.maSach+"\r\n"+this.tenSach+"\r\n"+this.loaiSach+"\r\n"+this.gia;
    }
    
}
