package khachhang;
public class KHang{
    private String ma;
    private String ten;
    private String phone;
    private String email;
    private NhomKH kh;
    public KHang() {
    }
    public KHang(String ma, String ten, String phone, String email) {
        this.ma = ma;
        this.ten = ten;
        this.phone = phone;
        this.email = email;
    }
    public String getMa() {
        return ma;
    }
    public void setMa(String ma) {
        this.ma = ma;
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public NhomKH getKh() {
        return kh;
    }
    public void setKh(NhomKH kh) {
        this.kh = kh;
    }
    @Override
    public String toString() {
        return this.ten;
    }
    
}
