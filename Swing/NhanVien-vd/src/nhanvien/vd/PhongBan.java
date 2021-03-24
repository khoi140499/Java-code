package nhanvien.vd;

import java.io.Serializable;
import java.util.Vector;

public class PhongBan implements Serializable{
    private String maPhong;
    private String tenPhong;
    private Vector<NhanVien>nvien;
    public PhongBan(){
        super();
        this.nvien=new Vector<NhanVien>();
    }
    public PhongBan(String maPhong, String tenPhong, Vector<NhanVien> nvien) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.nvien = nvien;
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
    public Vector<NhanVien> getNvien() {
        return nvien;
    }
    public void setNvien(Vector<NhanVien> nvien) {
        this.nvien = nvien;
    }
    public void themNhanVien(NhanVien nv1){
        this.nvien.add(nv1);
        nv1.setPban(this);
    }
    @Override
    public String toString() {
        return this.tenPhong;
    }
    
}
