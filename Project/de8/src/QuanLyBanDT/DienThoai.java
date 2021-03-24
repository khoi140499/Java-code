package QuanLyBanDT;
public class DienThoai {
   //mã sp, hãng sản xuất, phiên bản, đơn giá
    private int maSP;
    private String hangSX;
    private int phienBan;
    private double donGia;
    public DienThoai() {
    }
    public DienThoai(int maSP, String hangSX, int phienBan, double donGia) {
        this.maSP = maSP;
        this.hangSX = hangSX;
        this.phienBan = phienBan;
        this.donGia = donGia;
    }
    public int getMaSP() {
        return maSP;
    }
    public String getHangSX() {
        return hangSX;
    }
    public int getPhienBan() {
        return phienBan;
    }
    public double getDonGia() {
        return donGia;
    }
    @Override
    public String toString() {
        return this.maSP+"\r\n"+this.hangSX+"\r\n"+this.phienBan+"\r\n"+this.donGia;
    }
    
}
