package QuanLyCongNhan;
public class DanhSachCong {
    private Pair<CongNhan, XuongSanXuat> pair;
    private int soNgayLV;
    public DanhSachCong() {
    }

    public DanhSachCong(Pair<CongNhan, XuongSanXuat> pair, int soNgayLV) {
        this.pair = pair;
        this.soNgayLV = soNgayLV;
    }

    public Pair<CongNhan, XuongSanXuat> getPair() {
        return pair;
    }
    
    public int getSoNgayLV() {
        return soNgayLV;
    }
}
