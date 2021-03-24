package QuanLyTinhCongBanHang;
public class MatHang {
    private int maHang;
    private String tenHang;
    private String nhomHang;
    private double giaMua;
    private double giaBan;
    public MatHang() {
    }
    public MatHang(int maHang, String tenHang, String nhomHang, double giaMua, double giaBan) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.nhomHang = nhomHang;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }
    public int getMaHang() {
        return maHang;
    }
    public String getTenHang() {
        return tenHang;
    }
    public String getNhomHang() {
        return nhomHang;
    }
    public double getGiaMua() {
        return giaMua;
    }
    public double getGiaBan() {
        return giaBan;
    }
    @Override
    public String toString() {
        return this.maHang+"\r\n"+this.tenHang+"\r\n"+this.nhomHang+"\r\n"+this.giaMua+"\r\n"+this.giaBan;
    }
}
