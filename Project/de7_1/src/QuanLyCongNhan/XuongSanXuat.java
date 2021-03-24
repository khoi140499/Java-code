package QuanLyCongNhan;
public class XuongSanXuat {
    //mã xưởng, tên xưởng, mô tả, Hệ số công việc
    private int maXuong;
    private String tenXuong;
    private String moTa;
    private int heSo;
    public XuongSanXuat() {
    }
    public XuongSanXuat(int maXuong, String tenXuong, String moTa, int heSo) {
        this.maXuong = maXuong;
        this.tenXuong = tenXuong;
        this.moTa = moTa;
        this.heSo = heSo;
    }
    public int getMaXuong() {
        return maXuong;
    }
    public String getTenXuong() {
        return tenXuong;
    }
    public String getMoTa() {
        return moTa;
    }
    public int getHeSo() {
        return heSo;
    }
    @Override
    public String toString() {
        return this.maXuong+"\r\n"+this.tenXuong+"\r\n"+this.moTa+"\r\n"+this.heSo;
    }
    
}
