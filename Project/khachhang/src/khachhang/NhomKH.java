package khachhang;

import java.util.Vector;

public class NhomKH {
    private String ma;
    private String ten;
    private Vector<KHang>khang;
    public NhomKH() {
        super();
        this.khang=new Vector<KHang>();
    }
    public void themKhachHang(KHang kh1){
        this.khang.add(kh1);
        kh1.setKh(this);
    }

    public NhomKH(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
        this.khang = new Vector<KHang>();
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

    public Vector<KHang> getKhang() {
        return khang;
    }

    public void setKhang(Vector<KHang> khang) {
        this.khang = khang;
    }
    
    @Override
    public String toString() {
        return this.ten;
    }
    
}
