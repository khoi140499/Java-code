package QuanLyTinhCong;
public class NhanVien {
    private int maNV;
    private String tenNV;
    private String diaChi;
    private String sdt;
    private int bacLuong;
    private PhongBan phongBan=new PhongBan();

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

    public String getTenNV() {
        return tenNV;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public int getBacLuong() {
        return bacLuong;
    }

    public PhongBan getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(PhongBan phongBan) {
        this.phongBan = phongBan;
    }

    @Override
    public String toString() {
        return this.maNV+"\r\n"+this.tenNV+"\r\n"+this.diaChi+"\r\n"+this.sdt+"\r\n"+this.bacLuong;
    }
    
}
