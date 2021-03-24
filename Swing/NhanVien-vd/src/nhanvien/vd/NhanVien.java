package nhanvien.vd;

import java.io.Serializable;
import java.util.Date;

public class NhanVien implements Serializable{
    private String ma;
    private String tenNhanVien;
    private Date ngayVaoLam;
    private Date namSinh;
    private PhongBan pban;
    public NhanVien() {
    }
    public NhanVien(String ma, String tenNhanVien, Date ngayVaoLam, Date namSinh) {
        this.ma = ma;
        this.tenNhanVien = tenNhanVien;
        this.ngayVaoLam = ngayVaoLam;
        this.namSinh = namSinh;
    }
    public String getMa() {
        return ma;
    }
    public void setMa(String ma) {
        this.ma = ma;
    }
    public String getTenNhanVien() {
        return tenNhanVien;
    }
    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }
    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }
    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }
    public Date getNamSinh() {
        return namSinh;
    }
    public void setNamSinh(Date namSinh) {
        this.namSinh = namSinh;
    }
    public PhongBan getPban() {
        return pban;
    }
    public void setPban(PhongBan pban) {
        this.pban = pban;
    }
    @Override
    public String toString() {
        return this.ma+" "+this.tenNhanVien+" "+this.namSinh+" "+this.ngayVaoLam;
    }
}
