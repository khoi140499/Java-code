package QuanLyCongNhan;

import java.io.Serializable;

public class CongNhan implements Serializable{
    private int maCN;
    private String tenCN;
    private String diaChi;
    private String sdt;
    private String casx;
    private SanPham sp=new SanPham();

    public CongNhan() {
    }

    public CongNhan(int maCN, String tenCN, String diaChi, String sdt, String casx) {
        this.maCN = maCN;
        this.tenCN = tenCN;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.casx = casx;
    }

    public int getMaCN() {
        return maCN;
    }

    public String getTenCN() {
        return tenCN;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public String getCasx() {
        return casx;
    }

    public SanPham getSp() {
        return sp;
    }

    public void setSp(SanPham sp) {
        this.sp = sp;
    }
    
}
