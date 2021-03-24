package bai11_b;
public class KhanhHang {
    private String ma;
    private String ten;
    public KhanhHang() {
    }
    public KhanhHang(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
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

    @Override
    public String toString() {
        return this.ma+" "+this.ten;
    }
    
    
}
