package QuanLyBanDT;
public class HoaDon {
    private Pair<KhachHang, DienThoai> pair;
    private double soLuong;
    public HoaDon() {
    }

    public HoaDon(Pair<KhachHang, DienThoai> pair, double soLuong) {
        this.pair = pair;
        this.soLuong = soLuong;
    }

    public Pair<KhachHang, DienThoai> getPair() {
        return pair;
    }

    public double getSoLuong() {
        return soLuong;
    }
    
    
}
