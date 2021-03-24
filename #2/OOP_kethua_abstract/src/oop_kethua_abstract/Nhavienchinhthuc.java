package oop_kethua_abstract;
public class Nhavienchinhthuc extends Nhanvien{
    public Nhavienchinhthuc(){
        super();
    }
    public Nhavienchinhthuc(int ma, String ten){
        super(ma, ten);
    }
    public void tinhLuong(){
        System.out.println("Nhân viên chính thức tính lương");
    }
}
