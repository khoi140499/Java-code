package bai1;
public class SinhVien {
    private int masv;
    private double dtb;
    private String ten;
    private String lop;
    public SinhVien() {
    }
    public SinhVien(int masv, String ten, String lop ,double dtb) {
        this.masv = masv;
        this.dtb = dtb;
        this.ten = ten;
        this.lop = lop;
    }
    public double getDtb() {
        return dtb;
    }
    public String getLop() {
        return lop;
    }
    public String getTen() {
        return ten;
    }
    public void setDtb(double dtb) {
        this.dtb = dtb;
    }
    public void setLop(String lop) {
        this.lop = lop;
    }
    public void setMasv(int masv) {
        this.masv = masv;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public String toString(){
        return this.masv+" "+this.ten+" "+this.lop+" "+this.dtb;
    }
}
