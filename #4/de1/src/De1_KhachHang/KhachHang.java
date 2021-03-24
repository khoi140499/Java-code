package De1_KhachHang;
public class KhachHang {
    private int maKH;
    private String hoTen;
    private String diaChi;
    private int sdt;

    public KhachHang() {
    }

    public KhachHang(int maKH, String hoTen, String diaChi, int sdt) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
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

    public int getSdt() {
        return sdt;
    }

    @Override
    public String toString() {
        return this.maKH+" "+this.hoTen+" "+this.diaChi+" "+this.sdt;
    }
    
}
