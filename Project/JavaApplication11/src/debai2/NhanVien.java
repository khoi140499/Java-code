/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package debai2;

/**
 *
 * @author hiepp
 */
public class NhanVien {
    private int maVN;
    private String hoTen;
    private String diaChi;
    private String sdt;
    private int bacLuong;
    private PhongBan phongBan = new PhongBan();

    public NhanVien() {
    }

    public NhanVien(int maVN, String hoTen, String diaChi, String sdt, int bacLuong) {
        this.maVN = maVN;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.bacLuong = bacLuong;
    }

    public int getMaVN() {
        return maVN;
    }

    public void setMaVN(int maVN) {
        this.maVN = maVN;
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getBacLuong() {
        return bacLuong;
    }

    public void setBacLuong(int bacLuong) {
        this.bacLuong = bacLuong;
    }

    public PhongBan getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(PhongBan phongBan) {
        this.phongBan = phongBan;
    }
   
}
