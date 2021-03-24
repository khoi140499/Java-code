package nhanvien;

import java.io.Serializable;
import java.util.Date;

public class NV implements Serializable{
    private String maNV;
    private String tenNV;
    private Date ngayVaoLamViec;
    private Date namSinh;
    private PhongBan phong;
    public NV(String maNV, String tenNV, Date ngayVaoLamViec, Date namSinh) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.ngayVaoLamViec = ngayVaoLamViec;
        this.namSinh = namSinh;
    }

    public NV() {
    }
    
    public String getMaNV() {
        return maNV;
    }
    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
    public String getTenNV() {
        return tenNV;
    }
    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }
    public Date getNgayVaoLamViec() {
        return ngayVaoLamViec;
    }
    public void setNgayVaoLamViec(Date ngayVaoLamViec) {
        this.ngayVaoLamViec = ngayVaoLamViec;
    }
    public Date getNamSinh() {
        return namSinh;
    }
    public void setNamSinh(Date namSinh) {
        this.namSinh = namSinh;
    }

    public PhongBan getPhong() {
        return phong;
    }

    public void setPhong(PhongBan phong) {
        this.phong = phong;
    }
    
    @Override
    public String toString() {
        return this.tenNV;
    }
    
}
