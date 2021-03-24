package QuanLyBanHang;

import java.io.Serializable;

public class HoaDon implements Serializable{
    private int maHD;
    private String thoigian;
    private Pair<KhachHang, MatHang> pair;
    private int soLuong;
    public HoaDon() {
    }
    public HoaDon(int maHD, String thoigian, Pair<KhachHang, MatHang> pair, int soLuong) {
        this.maHD = maHD;
        this.thoigian = thoigian;
        this.pair = pair;
        this.soLuong = soLuong;
    }
    
    public int getMaHD() {
        return maHD;
    }
    public String getThoigian() {
        return thoigian;
    }
    public Pair<KhachHang, MatHang> getPair() {
        return pair;
    }
    public int getSoLuong() {
        return soLuong;
    }
    
}
