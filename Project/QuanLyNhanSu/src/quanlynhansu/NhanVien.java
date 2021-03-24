package quanlynhansu;
public class NhanVien {
   //Mã nhân viên, Họ tên, Địa chỉ, Số điện thoại, Bậc lương 
    private int maNV;
    private String tenNV;
    private String diaChi;
    private String sdt;
    private int bacLuong;

    public NhanVien() {
    }

    public NhanVien(int maNV, String tenNV, String diaChi, String sdt, int bacLuong) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.bacLuong = bacLuong;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getBacLuong() {
        return bacLuong;
    }

    public void setBacLuong(int bacLuong) {
        this.bacLuong = bacLuong;
    }

    @Override
    public String toString() {
        return this.maNV+"\r\n"+this.tenNV+"\r\n"+this.diaChi+"\r\n"+this.sdt+"\r\n"+this.bacLuong;
    }
    
}
