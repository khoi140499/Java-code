package QuanLyTinhCong;
public class TinhCong {
    private Pair<CongNhan,SanPham> pair;
    private int soNgayLV;
    public TinhCong() {
    }
    public TinhCong(Pair<CongNhan, SanPham> pair, int soNgayLV) {
        this.pair = pair;
        this.soNgayLV = soNgayLV;
    }
    public Pair<CongNhan, SanPham> getPair() {
        return pair;
    }
    public int getSoNgayLV() {
        return soNgayLV;
    }
}
