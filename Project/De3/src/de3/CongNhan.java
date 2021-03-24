package de3;
public class CongNhan {
    //mã CN, Họ tên, Địa chỉ, SĐT, Ca sản xuất
    private int maCN;
    private String hoTen;
    private String diaChi;
    private String sdt;
    private String ca;

    public CongNhan() {
    }

    public CongNhan(int maCN, String hoTen, String diaChi, String sdt, String ca) {
        this.maCN = maCN;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.ca = ca;
    }

    public int getMaCN() {
        return maCN;
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

    public String getCa() {
        return ca;
    }

    @Override
    public String toString() {
        return this.maCN+"\r\n"+this.hoTen+"\r\n"+this.diaChi+"\r\n"+this.sdt+"\r\n"+this.ca;
    }
    
}
