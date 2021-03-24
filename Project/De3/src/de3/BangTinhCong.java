package de3;
public class BangTinhCong {
    private int maTC;
    private String tenCN;
    private String loaiSP;
    private String tenSP;

    public BangTinhCong() {
    }

    public BangTinhCong(int maTC, String tenCN, String loaiSP, String tenSP) {
        this.maTC = maTC;
        this.tenCN = tenCN;
        this.loaiSP = loaiSP;
        this.tenSP = tenSP;
    }

    public int getMaTC() {
        return maTC;
    }

    public String getTenCN() {
        return tenCN;
    }

    public String getLoaiSP() {
        return loaiSP;
    }

    public String getTenSP() {
        return tenSP;
    }
    
}
