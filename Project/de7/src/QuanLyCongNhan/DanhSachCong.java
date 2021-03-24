package QuanLyCongNhan;
public class DanhSachCong {
    private String tenCN;
    private String tebXuong;
    private int soNgayLV;
    public DanhSachCong() {
    }
    public DanhSachCong(String tenCN, String tebXuong, int soNgayLV) {
        this.tenCN = tenCN;
        this.tebXuong = tebXuong;
        this.soNgayLV = soNgayLV;
    }
    public String getTenCN() {
        return tenCN;
    }
    public String getTebXuong() {
        return tebXuong;
    }
    public int getSoNgayLV() {
        return soNgayLV;
    }
}
