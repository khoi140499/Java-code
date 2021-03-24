/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banhangonline.Class;

/**
 *
 * @author Dang Khoi
 */
public class SanPham {
    private int maSp;
    private String tenSP;
    private String maLoai;
    private String hangSX;
    private double giaNhap;
    private double giaBan;
    private int soLuong;
    private String donviTinh;
    private String hinhAnh;

    public SanPham() {
    }

    public SanPham(int maSp, String tenSP, String maLoai, String hangSX, double giaNhap, double giaBan, int soLuong, String donviTinh,String hinhAnh) {
        this.maSp = maSp;
        this.tenSP = tenSP;
        this.maLoai = maLoai;
        this.hangSX = hangSX;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.donviTinh = donviTinh;
        this.hinhAnh = hinhAnh;
    }

    public int getMaSp() {
        return maSp;
    }

    public String getTenSP() {
        return tenSP;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public String getHangSX() {
        return hangSX;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public String getDonviTinh() {
        return donviTinh;
    }
    public String getHinhAnh() {
        return hinhAnh;
    }
    
}
