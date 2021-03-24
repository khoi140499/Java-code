package QuanLyDichVuVienThong;
public class HoaDon {
    private int maHD;
    private Pair<KhachHang, DichVu> pair;
    public HoaDon() {
    }
    public HoaDon(int maHD, Pair<KhachHang, DichVu> pair) {
        this.maHD = maHD;
        this.pair = pair;
    }

    public int getMaHD() {
        return maHD;
    }

    public Pair<KhachHang, DichVu> getPair() {
        return pair;
    }
    
}
