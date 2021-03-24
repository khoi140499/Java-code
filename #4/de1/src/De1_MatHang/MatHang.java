package De1_MatHang;
public class MatHang {
    private int maHang;
    private String tenHang;
    private String nhomHang;
    private double giaBan;

    public MatHang() {
    }

    public MatHang(int maHang, String tenHang, String nhomHang, double giaBan) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.nhomHang = nhomHang;
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

    public double getGiaBan() {
        return giaBan;
    }

    @Override
    public String toString() {
        return this.maHang+" "+this.tenHang+" "+this.nhomHang+" "+this.giaBan;
    }
    
}
