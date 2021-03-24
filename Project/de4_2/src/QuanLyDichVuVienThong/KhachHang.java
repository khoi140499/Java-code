package QuanLyDichVuVienThong;
public class KhachHang {
   private int maKH;
    private String hoTen;
    private String diaChi;
    private String sdt;
    private String loaiKH;
    private DichVu v=new DichVu();
    public KhachHang() {
    }
    public KhachHang(int maKH, String hoTen, String diaChi, String sdt, String loaiKH) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.loaiKH = loaiKH;
    }
    public int getMaKH() {
        return maKH;
    }
    public String getHoTen() {
        return hoTen;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public String getSdt() {
        return sdt;
    }
    public String getLoaiKH() {
        return loaiKH;
    }
    public DichVu getV() {
        return v;
    }
    public void setV(DichVu v) {
        this.v = v;
    }
    @Override
    public String toString() {
        return this.maKH+"\r\n"+this.hoTen+"\r\n"+this.diaChi+"\r\n"+this.sdt+"\r\n"+this.loaiKH;
    } 
}
