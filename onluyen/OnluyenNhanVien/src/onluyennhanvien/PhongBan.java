package onluyennhanvien;

import java.util.Vector;

public class PhongBan {
    private String maPhong;
    private String tenPhong;
    private Vector<NhanVien>nhanvien;
    public PhongBan() {
        super();
        this.nhanvien= new Vector<NhanVien>();
    }
    public PhongBan(String maPhong, String tenPhong, Vector<NhanVien> nhanVien) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.nhanvien = nhanvien;
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
        return nhanvien;
    }
    public void setNhanVien(Vector<NhanVien> nhanVien) {
        this.nhanvien = nhanvien;
    }
    public void themNhanVien(NhanVien nv1){
        this.nhanvien.add(nv1);
        nv1.setPhongban(this);
    }
    @Override
    public String toString() {
        return this.tenPhong;
    }
    
}
