package bai19.sinhvien;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

public class PhongBan implements Serializable{
    private String maPhong;
    private String tenPhong;
    private Vector<NhanVien> nhanVien;
    public PhongBan() {
        super();
        this.nhanVien=new Vector<NhanVien>();
    }
    public String getMaPhong() {
        return maPhong;
    }
    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }
    public String getTenPhong() {
        return tenPhong;
    }
    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }
    public Vector<NhanVien> getNhanVien() {
        return nhanVien;
    }
    public void setNhanVien(Vector<NhanVien> nhanVien) {
        this.nhanVien = nhanVien;
    }
    public void themNhanVien(NhanVien nv){
        this.nhanVien.add(nv);
        nv.setPhong(this);
    }

    @Override
    public String toString() {
        return this.tenPhong;
    }
    
}
