package QuanLyDiem;
public class BangDiem {
   private String tenSV;
   private String tenMon;
   private double diem;
    public BangDiem() {
    }
    public BangDiem(String tenSV, String tenMon, double diem) {
        this.tenSV = tenSV;
        this.tenMon = tenMon;
        this.diem = diem;
    }
    public String getTenSV() {
        return tenSV;
    }
    public String getTenMon() {
        return tenMon;
    }
    public double getDiem() {
        return diem;
    }
}
