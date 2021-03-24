package de2_1;
public class NhanVien {
    private int maVN;
    private String hoTen;
    private String diaChi;
    private String sdt;
    private int bacLuong;
    private PhongBan b=new PhongBan();
    public NhanVien() {
    }
    public NhanVien(int maVN, String hoTen, String diaChi, String sdt, int bacLuong) {
        this.maVN = maVN;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.bacLuong = bacLuong;
    }
    public int getMaVN() {
        return maVN;
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
    public int getBacLuong() {
        return bacLuong;
    }
    public PhongBan getB() {
        return b;
    }
    public void setB(PhongBan b) {
        this.b = b;
    }
    
    @Override
    public String toString() {
        return this.maVN+"\r\n"+this.hoTen+"\r\n"+this.diaChi+"\r\n"+this.sdt+"\r\n"+this.bacLuong;
    }
    
}
