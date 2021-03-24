package QuanLyDiem;
public class SinhVien {
    //(mã SV, Họ tên, Địa chỉ, SĐT, Lớp
    private int maSV;
    private String tenSV;
    private String diaChi;
    private String sdt;
    private String lop;

    public SinhVien() {
    }

    public SinhVien(int maSV, String tenSV, String diaChi, String sdt, String lop) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.lop = lop;
    }

    public int getMaSV() {
        return maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public String getLop() {
        return lop;
    }

    @Override
    public String toString() {
        return this.maSV+"\r\n"+this.tenSV+"\r\n"+this.diaChi+"\r\n"+this.sdt+"\r\n"+this.lop;
    }
    
}
