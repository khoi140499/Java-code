package QuanLyCong;
public class NhanVienBanHang {
    //mã NV, Họ tên, địa chỉ, Số ĐT
    private int maNV;
    private String tenNV;
    private String diaChi;
    private String sdt;
    public NhanVienBanHang() {
    }
    public NhanVienBanHang(int maNV, String tenNV, String diaChi, String sdt) {
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
    @Override
    public String toString() {
        return this.maNV+"\r\n"+this.tenNV+"\r\n"+this.diaChi+"\r\n"+this.sdt;
    }
    
}
