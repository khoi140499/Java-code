package bai4_tuluyen;
public class Bai4_tuluyen {
    public static void main(String[] args) {
        Account a=new Account(15000123, "Hoang Dang Khoi");
        Account b=new Account(15002324, "An Quang Ngoc");
        a.napTien();
        System.out.println(a.toString());
        a.rutTien();
        System.out.println(a.toString());
        a.chuyenKhoan(b);
        System.out.println(a.toString());
        System.out.println(b.toString());
        a.daoHan();
        System.out.println(a.toString());
    }
    
}
