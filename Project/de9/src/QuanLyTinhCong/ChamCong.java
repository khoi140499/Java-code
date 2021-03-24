package QuanLyTinhCong;
public class ChamCong {
    private Pair<NhanVien, PhongBan> pair;
    private int soNgay;

    public ChamCong() {
    }

    public ChamCong(Pair<NhanVien, PhongBan> pair, int soNgay) {
        this.pair = pair;
        this.soNgay = soNgay;
    }

    public Pair<NhanVien, PhongBan> getPair() {
        return pair;
    }

    public int getSoNgay() {
        return soNgay;
    }
    
}
