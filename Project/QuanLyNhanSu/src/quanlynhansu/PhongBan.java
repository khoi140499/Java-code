package quanlynhansu;
public class PhongBan {
    //mã phòng, tên phòng, mô tả, Hệ số công việc
    private int maPhong;
    private String tenPhong;
    private String moTa;
    private int hsCong;

    public PhongBan() {
    }

    public PhongBan(int maPhong, String tenPhong, String moTa, int hsCong) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.moTa = moTa;
        this.hsCong = hsCong;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getHsCong() {
        return hsCong;
    }

    public void setHsCong(int hsCong) {
        this.hsCong = hsCong;
    }

    @Override
    public String toString() {
        return this.maPhong+"\r\n"+this.tenPhong+"\r\n"+this.moTa+"\r\n"+this.hsCong;
    }
    
}
