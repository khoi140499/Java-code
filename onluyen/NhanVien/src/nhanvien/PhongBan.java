package nhanvien;

import java.io.Serializable;
import java.util.Vector;

public class PhongBan implements Serializable{
    private String maPhong;
    private String tenPhong;
    private Vector<NV>nhanVien;
    public PhongBan(String maPhong, String tenPhong, Vector<NV> nhanVien) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.nhanVien = nhanVien;
    }

    public PhongBan() {
        super();
        this.nhanVien=new Vector<NV>();
    }
    public void themNhanVien(NV nv1){
        this.nhanVien.add(nv1);
        nv1.setPhong(this);
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
    public Vector<NV> getNhanVien() {
        return nhanVien;
    }
    public void setNhanVien(Vector<NV> nhanVien) {
        this.nhanVien = nhanVien;
    }
    public String toString(){
        return this.tenPhong;
    }
}
