package QuanLyBanHang;

import java.io.Serializable;

public class KhachHang implements Serializable{
    private int maKH;
    private String hoTen;
    private String diaChi;
    private String sdt;
    private MatHang hd=new MatHang();
    public KhachHang() {
    }
    public KhachHang(int maKH, String hoTen, String diaChi, String sdt) {
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
    public String getSdt() {
        return sdt;
    }
    public MatHang getHd() {
        return hd;
    }

    public void setHd(MatHang hd) {
        this.hd = hd;
    }
    
    @Override
    public String toString() {
        return this.maKH+"\r\n"+this.hoTen+"\r\n"+this.diaChi+"\r\n"+this.sdt;
    }
}
