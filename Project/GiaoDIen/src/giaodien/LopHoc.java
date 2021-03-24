package giaodien;

import java.io.Serializable;
import java.util.Vector;

public class LopHoc implements Serializable{
    private String ma;
    private String tenLop;
    private Vector<SinhVien>sinhvien;
    public LopHoc() {
        super();
        this.sinhvien=new Vector<SinhVien>();
    }
    public LopHoc(String ma, String tenLop, Vector<SinhVien> sinhvien) {
        this.ma = ma;
        this.tenLop = tenLop;
        this.sinhvien = sinhvien;
    }
    public String getMa() {
        return ma;
    }
    public void setMa(String ma) {
        this.ma = ma;
    }
    public String getTenLop() {
        return tenLop;
    }
    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }
    public Vector<SinhVien> getSinhvien() {
        return sinhvien;
    }
    public void setSinhvien(Vector<SinhVien> sinhvien) {
        this.sinhvien = sinhvien;
    }
    public void themSinhVien(SinhVien a){
        this.sinhvien.add(a);
        a.setLophoc(this);
    }
    @Override
    public String toString() {
        return this.tenLop;
    }
    
}
