package oop_kethua;
public class Nhanvien {
    protected int ma;
    protected String ten;
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
        return this.ten;
    }
    public Nhanvien(){
        
    }
    public Nhanvien(int ma, String ten){
        this.ma=ma;
        this.ten=ten;
    }
    public void tinhLuong(){
        System.out.println("Nhân viên "+ten+" gọi tính lương");
    }
}
