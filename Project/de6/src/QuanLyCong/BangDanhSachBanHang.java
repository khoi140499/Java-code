package QuanLyCong;

import java.io.Serializable;

public class BangDanhSachBanHang implements Serializable{
    private String tenNV;
    private String tenMH;
    private int soLuong;
    public BangDanhSachBanHang() {
    }
    public BangDanhSachBanHang(String tenNV, String tenMH, int soLuong) {
        this.tenNV = tenNV;
        this.tenMH = tenMH;
        this.soLuong = soLuong;
    }
    public String getTenNV() {
        return tenNV;
    }
    public String getTenMH() {
        return tenMH;
    }
    public int getSoLuong() {
        return soLuong;
    }
}
