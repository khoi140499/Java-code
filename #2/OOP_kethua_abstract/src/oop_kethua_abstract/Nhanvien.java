package oop_kethua_abstract;
public abstract class Nhanvien {
    private int ma;
    private String ten;
    public Nhanvien(){
        super();
    }
    public Nhanvien(int ma, String ten){
        super();
        this.ma=ma;
        this.ten=ten;
    }
    public void setMa(int ma){
        this.ma=ma;
    }
    public int getMa(){
        return this.ma;
    }
    public void setTen(String ten){
        this.ten=ten;
    }
    public String getTen(){
        return ten;
    }
    public abstract void tinhLuong();
}
