package oop_kethua;
public class Nhanvienchinhthuc extends Nhanvien{
    public Nhanvienchinhthuc(){
        super();
    }
    public Nhanvienchinhthuc(int ma, String ten){
        super(ma, ten);
    }
    public void tinhLuong(){
        super.tinhLuong();
        System.out.println("===>nhân viên chính thức");
    }
    
}
