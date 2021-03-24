package baithi;

import java.util.Date;

public class HoaDon {
    private int maHD;
    private int maKH;
    private String tenMh;
    private int soLuong;
    private String date;
    private double tongTien;

    public HoaDon() {
    }

    public HoaDon(int maHD, int maKH, String tenMh, int soLuong, String date, double tongTien) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.tenMh = tenMh;
        this.soLuong = soLuong;
        this.date = date;
        this.tongTien = tongTien;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getTenMh() {
        return tenMh;
    }

    public void setTenMh(String tenMh) {
        this.tenMh = tenMh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    

    
}
