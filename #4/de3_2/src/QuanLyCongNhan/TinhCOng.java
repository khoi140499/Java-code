package QuanLyCongNhan;

import java.io.Serializable;

public class TinhCOng implements Serializable{
    private Pair<CongNhan, SanPham> pair;
    private int soLuong;

    public TinhCOng() {
    }

    public TinhCOng(Pair<CongNhan, SanPham> pair, int soLuong) {
        this.pair = pair;
        this.soLuong = soLuong;
    }

    public Pair<CongNhan, SanPham> getPair() {
        return pair;
    }

    public int getSoLuong() {
        return soLuong;
    }
    
}
