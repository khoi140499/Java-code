package oop_alias;
public class OOP_ALIAS {
    public static void main(String[] args) {
        NewClass nv1=new NewClass(1, "Hoàng Đăng Khôi");
        NewClass nv2=new NewClass(2, "Đinh Thế Vinh");
        nv1=nv2;
        nv2.setTen("An Quang Ngọc");
        System.out.println("Tên của nhân viên 1: "+nv1.getTen());
        nv1.setTen("Đinh Thế Vinh");
        System.out.println("Tên của nhân viên 2: "+nv2.getTen());
        NewClass nv3=new NewClass(3,"Hoang Dang Khoi");
        NewClass nv4=new NewClass(4, "Dinh The Vinh");
        nv3=nv4.copy();
        System.out.println("Tên nhân viên 3: "+nv3.getTen());
        nv3.setTen("Dao Anh Thang");
        System.out.println("Tên nhân viên 3: "+nv3.getTen());
        System.out.println("Tên nhân viên 4: "+nv4.getTen());
    }
    
}
