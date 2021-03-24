package bai11_b;

import java.util.ArrayList;

public class Bai11_b {
    public static void main(String[] args) {
        ArrayList<KhanhHang> ds=new ArrayList<>();
            ds.add(new KhanhHang("KH01", "Hoang Dang Khoi"));
            ds.add(new KhanhHang("KH02", "To Van Quyen"));
            ds.add(new KhanhHang("KH03", "An Quang Ngoc"));
            ds.add(new KhanhHang("KH04", "Dinh The Vinh"));
            boolean kt=File.luuFile(ds, "LUU.OUT");
            if(kt==true){
                System.out.println("Luu file thanh cong");
            }
            else{
                System.out.println("Luu file that bai");
            }
    }
    
}
