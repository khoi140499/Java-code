package bai3_4.monhoc;
public class MonHoc {
    private int maMon;
    private String tenMon;
    private String chuyenNghanh;
    private int soTinChi;
    public MonHoc() {
    }
    public MonHoc(int maMon, String tenMon, String chuyenNghanh, int soTinChi) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.chuyenNghanh = chuyenNghanh;
        this.soTinChi = soTinChi;
    }
    public int getMaMon() {
        return maMon;
    }
    public String getTenMon() {
        return tenMon;
    }
    public String getChuyenNghanh() {
        return chuyenNghanh;
    }
    public int getSoTinChi() {
        return soTinChi;
    }
    @Override
    public String toString() {
        return this.maMon+"\r\n"+this.tenMon+"\r\n"+this.chuyenNghanh+"\r\n"+this.soTinChi;
    }
    
}
