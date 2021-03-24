package onluyennhanvien;

import java.util.Date;

public class NhanVien {
    private String maNhanVen;
    private String tenNhanVien;
    private Date ngaySinh;
    private Date ngayVaoLam;
    private PhongBan phongban;
    public NhanVien() {
    }
    public NhanVien(String maNhanVen, String tenNhanVien, Date ngaySinh, Date ngayVaoLam) {
        this.maNhanVen = maNhanVen;
        this.tenNhanVien = tenNhanVien;
        this.ngaySinh = ngaySinh;
        this.ngayVaoLam = ngayVaoLam;
    }
    public String getMaNhanVen() {
        return maNhanVen;
    }
    public void setMaNhanVen(String maNhanVen) {
        this.maNhanVen = maNhanVen;
    }
    public String getTenNhanVien() {
        return tenNhanVien;
    }
    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }
    public Date getNgaySinh() {
        return ngaySinh;
    }
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }
    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }
    public PhongBan getPhongban() {
        return phongban;
    }
    public void setPhongban(PhongBan phongban) {
        this.phongban = phongban;
    }
    @Override
    public String toString() {
        return this.tenNhanVien;
    }
    
}
