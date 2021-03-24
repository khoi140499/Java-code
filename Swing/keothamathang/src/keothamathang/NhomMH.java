package keothamathang;

import java.util.Vector;

public class NhomMH {
    private String ten;
    private Vector<MatHang>mh;
    public NhomMH() {
        super();
        this.mh=new Vector<>();
    }
    public NhomMH(String ten) {
        this.ten = ten;
        this.mh = mh;
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public Vector<MatHang> getMh() {
        return mh;
    }
    public void setMh(Vector<MatHang> mh) {
        this.mh = mh;
    }
    @Override
    public String toString() {
        return this.ten;
    }
    
}
