package QuanLyCongNhan;
public class ConNhan {
    //(mã công nhân, Họ tên, Địa chỉ, Số điện thoại, Bậc thợ
    private int maCN;
    private String tenCN;
    private String diaChi;
    private String sdt;
    private int bacTho;
    public ConNhan() {
    }
    public ConNhan(int maCN, String tenCN, String diaChi, String sdt, int bacTho) {
        this.maCN = maCN;
        this.tenCN = tenCN;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.bacTho = bacTho;
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
    public int getBacTho() {
        return bacTho;
    }
    @Override
    public String toString() {
        return this.maCN+"\r\n"+this.tenCN+"\r\n"+this.diaChi+"\r\n"+this.sdt+"\r\n"+this.bacTho;
    } 
}
