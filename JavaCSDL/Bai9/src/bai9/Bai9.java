package bai9;
public class Bai9 {
    public static void main(String[] args) {
       NhanVien a=new NhanVienChinhThuc();
       a.setTen("Hoang Dang Khoi");
       System.out.println(a);
       NhanVienChinhThuc b=new NhanVienChinhThuc();
       b.setTen("An Quang Ngọc");
       System.out.println(b.toString());
       a=new NhanVienThoiVu();
       a.setTen("Hoàng Đăng Khôi");
       System.out.println(a.toString());
       
    }
    
}
