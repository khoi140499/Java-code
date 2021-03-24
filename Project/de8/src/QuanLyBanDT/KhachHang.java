package QuanLyBanDT;
public class KhachHang {
    //mã KH, Họ tên, Địa chỉ, SĐT, Nhóm KH
    private int maKH;
    private String tenKH;
    private String diaChi;
    private String sdt;
    private String nhomKH;
    private DienThoai dienthoai=new DienThoai();
    public KhachHang() {
    }
    public KhachHang(int maKH, String tenKH, String diaChi, String sdt, String nhomKH) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.nhomKH = nhomKH;
    }
    public int getMaKH() {
        return maKH;
    }
    public String getTenKH() {
        return tenKH;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public String getSdt() {
        return sdt;
    }
    public String getNhomKH() {
        return nhomKH;
    }
    public DienThoai getDienthoai() {
        return dienthoai;
    }
    public void setDienthoai(DienThoai dienthoai) {
        this.dienthoai = dienthoai;
    }
    @Override
    public String toString() {
        return this.maKH+"\r\n"+this.tenKH+"\r\n"+this.diaChi+"\r\n"+this.sdt+"\r\n"+this.nhomKH;
    }
    
}
