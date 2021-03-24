package QuanLyTinhCongBanHang;
public class NhanVien {
    private int maNV;
    private String tenNV;
    private String diaChi;
    private String sdt;
    private MatHang mathang=new MatHang();
    public NhanVien() {
    }
    public NhanVien(int maNV, String tenNV, String diaChi, String sdt) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }
    public int getMaNV() {
        return maNV;
    }
    public String getTenNV() {
        return tenNV;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public String getSdt() {
        return sdt;
    }
    public MatHang getMathang() {
        return mathang;
    }
    public void setMathang(MatHang mathang) {
        this.mathang = mathang;
    }   
    @Override
    public String toString() {
        return this.maNV+"\r\n"+this.tenNV+"\r\n"+this.diaChi+"\r\n"+this.sdt;
    }
}
