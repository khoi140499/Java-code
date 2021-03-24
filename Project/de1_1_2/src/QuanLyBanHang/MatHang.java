package QuanLyBanHang;
public class MatHang {
    private int ma;
    private String tenMa;
    private String nhomMa;
    private double gia;
    public MatHang() {
    }
    public MatHang(int ma, String tenMa, String nhomMa, double gia) {
        this.ma = ma;
        this.tenMa = tenMa;
        this.nhomMa = nhomMa;
        this.gia = gia;
    }
    public int getMa() {
        return ma;
    }
    public String getTenMa() {
        return tenMa;
    }
    public String getNhomMa() {
        return nhomMa;
    }
    public double getGia() {
        return gia;
    }
    @Override
    public String toString() {
        return this.ma+"\r\n"+this.tenMa+"\r\n"+this.nhomMa+"\r\n"+this.gia;
    }
}
