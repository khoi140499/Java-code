/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baithi;

/**
 *
 * @author Dang Khoi
 */
public class KhachHang {
    private int maKH;
    private String hoTen;
    private String diaChi;
    private int sdt;

    public KhachHang() {
    }

    public KhachHang(int maKH, String hoTen, String diaChi, int sdt) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return this.maKH+"\r\n"+this.hoTen+"\r\n"+this.diaChi+"\r\n"+this.sdt;
    }
    
}
