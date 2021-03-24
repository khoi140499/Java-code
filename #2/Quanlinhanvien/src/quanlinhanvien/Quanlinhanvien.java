package quanlinhanvien;

import java.util.ArrayList;
import java.util.Scanner;

public class Quanlinhanvien {
    public static void main(String[] args) {
        ArrayList sv=new ArrayList();
        QuanLi al=new QuanLi();
        for(int i=0;i<3;i++){
            al.nhap();
            sv.add(al);
        }
        Scanner  sc=new Scanner(System.in);
        System.out.println("Nhap nhan vien can tim: ");
        String s=sc.nextLine();
    }
  //  public static void timnhanvien(){
       // QuanLi al=new QuanLi();
        
      //  String s[]=al.(al.getSdt()+al)
    }
   
