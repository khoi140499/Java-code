package QuanLyTinhCong;
public class PhongBan {
    private int maPB;
    private String tenPb;
    private String moTa;
    private int hs;

    public PhongBan() {
    }

    public PhongBan(int maPB, String tenPb, String moTa, int hs) {
        this.maPB = maPB;
        this.tenPb = tenPb;
        this.moTa = moTa;
        this.hs = hs;
    }

    public int getMaPB() {
        return maPB;
    }

    public String getTenPb() {
        return tenPb;
    }

    public String getMoTa() {
        return moTa;
    }

    public int getHs() {
        return hs;
    }

    @Override
    public String toString() {
        return this.maPB+"\r\n"+this.tenPb+"\r\n"+this.moTa+"\r\n"+this.hs;
    }
    
}
