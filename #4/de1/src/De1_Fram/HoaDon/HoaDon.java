package De1_Fram.HoaDon;

import De1_KhachHang.KhachHang;
import De1_MatHang.MatHang;
import java.util.ArrayList;
import java.util.Date;

public class HoaDon {
    private int maHoaDon;
    private Date date;
    private KhachHang kh;
    private ArrayList<MatHang> mh;
    public HoaDon() {
        super();
        this.mh=new ArrayList<MatHang>();
    }
    public HoaDon(int maHoaDon, Date date, KhachHang kh, ArrayList<MatHang> mh) {
        this.maHoaDon = maHoaDon;
        this.date = date;
        this.kh = kh;
        this.mh = mh;
    }
    public int getMaHoaDon() {
        return maHoaDon;
    }
    public Date getDate() {
        return date;
    }
    public KhachHang getKh() {
        return kh;
    }
    public ArrayList<MatHang> getMh() {
        return mh;
    }
}
