package de4_main;
public class HoaDon {
    private int maHD;
    private String tenKH;
    private String tenDV;
    private double giaDV;

    public HoaDon() {
    }

    public HoaDon(int maHD, String tenKH, String tenDV, double giaDV) {
        this.maHD = maHD;
        this.tenKH = tenKH;
        this.tenDV = tenDV;
        this.giaDV = giaDV;
    }

    public int getMaHD() {
        return maHD;
    }

    public String getTenKH() {
        return tenKH;
    }

    public String getTenDV() {
        return tenDV;
    }

    public double getGiaDV() {
        return giaDV;
    }
    
}
