package QuanLyDichVuVienThong;
public class DichVu {
    private int maDV;
    private String tenDV;
    private double gia;
    private String donVi;
    public DichVu() {
    }
    public DichVu(int maDV, String tenDV, double gia, String donVi) {
        this.maDV = maDV;
        this.tenDV = tenDV;
        this.gia = gia;
        this.donVi = donVi;
    }
    public int getMaDV() {
        return maDV;
    }
    public String getTenDV() {
        return tenDV;
    }
    public double getGia() {
        return gia;
    }
    public String getDonVi() {
        return donVi;
    }
    public String toString() {
        return this.maDV+"\r\n"+this.tenDV+"\r\n"+this.gia+"\r\n"+this.donVi;
    }
}
