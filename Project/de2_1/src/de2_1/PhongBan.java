package de2_1;
public class PhongBan {
    private int maPb;
    private String tenPhong;
    private String moTa;
    private  int hesoCV;
    public PhongBan() {
    }
    public PhongBan(int maPb, String tenPhong, String moTa, int hesoCV) {
        this.maPb = maPb;
        this.tenPhong = tenPhong;
        this.moTa = moTa;
        this.hesoCV = hesoCV;
    }
    public int getMaPb() {
        return maPb;
    }
    public String getTenPhong() {
        return tenPhong;
    }
    public String getMoTa() {
        return moTa;
    }
    public int getHesoCV() {
        return hesoCV;
    }
    @Override
    public String toString() {
        return this.maPb+"\r\n"+this.tenPhong+"\r\n"+this.moTa+"\r\n"+this.hesoCV;
    }
    
}
