package luyenarraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LuyenArrayList {
    static ArrayList<Integer> ds=new ArrayList<Integer>();
    public static void menu(){
        System.out.println("1.Thêm");
        System.out.println("2.Xuất");
        System.out.println("3.Sửa");
        System.out.println("4.Xóa");
        System.out.println("5.Tìm Kiếm");
        System.out.println("6.Sắp Xếp");
        System.out.println("7.Thoát");
        System.out.println("Bạn chọn gì ??");
        Scanner sc=new Scanner(System.in);
        int chon=sc.nextInt();
        switch(chon){
            case 1: 
                them();
                break;
            case 2:
                xuat();
                break;
            case 3:
                sua();
                break;
            case 4:
                xoa();
                break;    
            case 5:
                timkiem();
                break;
            case 6:
                sapxep();
                break;
            case 7:
                System.err.println("Cảm ơn bạn");
                System.exit(0);
                break;    
        }
    }
    public static void main(String[] args) {
        while(true){
            menu();
        }
    }
    public static void them() {
       int value=(new Scanner(System.in)).nextInt();
       ds.add(value);
    }
     public static void xuat() {
      for(int i=0;i<ds.size();i++){
          System.out.print(ds.get(i)+"\t");
      }
      System.out.println();
    }
    public static void sua() {
        System.out.println("Vị trí muốn sửa : ");
        int vtri=(new Scanner(System.in)).nextInt();
        System.out.println("Giá trị mới: ");
        int value=(new Scanner(System.in)).nextInt();
        ds.set(vtri, value);
    }
    public static void xoa() {
        System.out.println("Vị trí muốn xóa : ");
        int vitri=(new Scanner(System.in)).nextInt();
        ds.remove(vitri);
    }

    public static void timkiem() {
        System.out.println("Bạn muốn tìm số nào: ");
        int k=(new Scanner(System.in)).nextInt();
        if(ds.contains(k)){
            System.out.println("có phần tử "+ k +" trong danh sách");
        }
        else System.out.println("Không có ");
    }

    public static void sapxep() {
        Collections.sort(ds);
    }
    
}
