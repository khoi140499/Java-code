/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyDichVu;

import java.io.Serializable;

/**
 *
 * @author Dang Khoi
 */
public class KhachHang implements Serializable{
    private int maKH;
    private String tenKh;
    private String diaChi;
    private String SDT;
    private String loaiKH;
    private DichVu dichvu=new DichVu();

    public KhachHang() {
    }

    public KhachHang(int maKH, String tenKh, String diaChi, String SDT, String loaiKH) {
        this.maKH = maKH;
        this.tenKh = tenKh;
        this.diaChi = diaChi;
        this.SDT = SDT;
        this.loaiKH = loaiKH;
    }

    public int getMaKH() {
        return maKH;
    }

    public String getTenKh() {
        return tenKh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public String getLoaiKH() {
        return loaiKH;
    }

    public DichVu getDichvu() {
        return dichvu;
    }

    public void setDichvu(DichVu dichvu) {
        this.dichvu = dichvu;
    }
    
}
