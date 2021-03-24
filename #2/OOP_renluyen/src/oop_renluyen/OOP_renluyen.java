package oop_renluyen;
public class OOP_renluyen {
    public static void main(String[] args) {
        NhanVien nv1=new NhanVien(188, "Hoàng Đăng Khôi");
        NhanVien nv2=new NhanVien(300, "An Quang Ngoc");
        System.out.println("Ten: "+nv1.getTen()+" so san pham: "+nv1.getMa());
        System.out.println("Ten: "+nv2.getTen()+" so san pham: "+nv2.getMa());
    if(nv1.lonHon(nv2)){
        System.out.println("1 nhieu san pham hon 2");
        System.out.println("cu the : "+(nv1.getMa()-nv2.getMa()));
      }else 
        System.out.println("1 it san pham hon 2");
        System.out.println("cu the : "+(-nv1.getMa()+ nv2.getMa()));
    }
}
