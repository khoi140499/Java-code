package keothamathang;
public class MatHang {
    private int ma;
    private String ten;
    private String nhom;
    private double gia;
    private NhomMH nh;
    public MatHang() {
    }
    public MatHang(int ma, String ten, String nhom, double gia) {
        this.ma = ma;
        this.ten = ten;
        this.nhom = nhom;
        this.gia = gia;
        this.nh = nh;
    }
    public int getMa() {
        return ma;
    }
    public void setMa(int ma) {
        this.ma = ma;
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public String getNhom() {
        return nhom;
    }
    public void setNhom(String nhom) {
        this.nhom = nhom;
    }
    public double getGia() {
        return gia;
    }
    public void setGia(double gia) {
        this.gia = gia;
    }
    public NhomMH getNh() {
        return nh;
    }
    public void setNh(NhomMH nh) {
        this.nh = nh;
    }
    @Override
    public String toString() {
        return this.ma+"\r\n"+this.ten+"\r\n"+this.nhom+"\r\n"+this.gia;
    }
    
}
