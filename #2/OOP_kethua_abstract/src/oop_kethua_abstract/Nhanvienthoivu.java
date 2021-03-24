package oop_kethua_abstract;
public class Nhanvienthoivu extends Nhanvien{
    public Nhanvienthoivu(){
        super();
    }
    public Nhanvienthoivu(int ma, String ten){
        super(ma, ten);
    }
    @Override
    public void tinhLuong() {
        System.out.println("Nhân viên thời vụ tính lương");
    }
    
}
