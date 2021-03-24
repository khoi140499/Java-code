package oop_kethua;
public class Nhanvienthoivu extends Nhanvien{
        public Nhanvienthoivu(){
            super();
        }
        public Nhanvienthoivu(int ma, String ten){
            super(ma, ten);
        }
        public void tinhLuong(){
            super.tinhLuong();
            System.out.println("===> đây là nhân viên thời vụ");
        }
}
