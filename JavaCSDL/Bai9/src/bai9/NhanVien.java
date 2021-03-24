package bai9;
public abstract class NhanVien {
    private String ten;
    private String cmnd;
    public abstract int xuatLuong(); //abstract dinh nghia ten ham

    public NhanVien() {
    }

    public NhanVien(String ten, String cmnd) {
        this.ten = ten;
        this.cmnd = cmnd;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    @Override
    public String toString() {
        return this.ten+"  "+xuatLuong();
    }
    
}
