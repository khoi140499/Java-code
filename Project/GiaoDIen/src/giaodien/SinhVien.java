package giaodien;

import java.io.Serializable;

public class SinhVien implements Serializable{
    private String ma;
    private String ten;
    private String tuoi;
    private String quequan;
    private LopHoc lophoc;
    public SinhVien() {
    }

    public SinhVien(String ma, String ten, String tuoi, String quequan) {
        this.ma = ma;
        this.ten = ten;
        this.tuoi = tuoi;
        this.quequan = quequan;
        this.lophoc = lophoc;
    }
    
    public String getMa() {
        return ma;
    }
    public void setMa(String ma) {
        this.ma = ma;
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public String getTuoi() {
        return tuoi;
    }
    public void setTuoi(String tuoi) {
        this.tuoi = tuoi;
    }
    public String getQuequan() {
        return quequan;
    }
    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }
    public LopHoc getLophoc() {
        return lophoc;
    }
    public void setLophoc(LopHoc lophoc) {
        this.lophoc = lophoc;
    }
    @Override
    public String toString() {
        return this.ten;
    }
    
}
