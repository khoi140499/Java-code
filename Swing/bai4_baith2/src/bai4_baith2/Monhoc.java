package bai4_baith2;
public class Monhoc {
    private String maMon;
    private String tenMon;
     private String nhomMon;
    private String soTinChi;

    public Monhoc() {
    }

    public Monhoc(String maMon, String tenMon, String nhomMon, String soTinChi) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.nhomMon = nhomMon;
        this.soTinChi = soTinChi;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getNhomMon() {
        return nhomMon;
    }

    public void setNhomMon(String nhomMon) {
        this.nhomMon = nhomMon;
    }

    public String getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(String soTinChi) {
        this.soTinChi = soTinChi;
    }

    
    
    @Override
    public String toString() {
        return this.maMon+" "+this.tenMon+" "+this.soTinChi+" "+this.nhomMon;
    }
    
    
}
