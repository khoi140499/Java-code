package QuanLyTinhCongBanHang;
public class DanhSachBanHang {
    private Pair<NhanVien,MatHang> pair;
    private int soLuong;

    public DanhSachBanHang() {
    }

    public DanhSachBanHang(Pair<NhanVien, MatHang> pair, int soLuong) {
        this.pair = pair;
        this.soLuong = soLuong;
    }

    public Pair<NhanVien, MatHang> getPair() {
        return pair;
    }

    public int getSoLuong() {
        return soLuong;
    }
    
}
