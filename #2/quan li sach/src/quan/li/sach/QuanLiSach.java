package quan.li.sach;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLiSach {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<QuanLi> ql=new ArrayList<>();
        QuanLi quanli=new QuanLi();
        quanli.nhap3();
        for(int i=0;i<quanli.getSosach();i++){
            quanli=new QuanLi();
            quanli.nhap();
            ql.add(quanli);
        }
        quanli.nhap2();
        System.out.println("Sach trong thu vien ");
        for(QuanLi x  :ql){
            System.out.println(x);
        }
        quanli.xuat1();
    }
}
