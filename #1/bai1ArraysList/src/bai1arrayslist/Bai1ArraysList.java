package bai1arrayslist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Bai1ArraysList {
    static ArrayList<String> ds=new ArrayList<String>();
    public static void menu(){
        Scanner sc=new Scanner(System.in);
        System.out.println("1.Thêm Sinh Viên");
        System.out.println("2.Xuất Sinh Viên");
        System.out.println("3.Sửa Sinh Viên");
        System.out.println("4.Xóa Sinh Viên");
        System.out.println("5.Tìm Sinh Viên");
        System.out.println("6.Sắp xếp Sinh Viên");
        System.out.println("7.Đếm số lượng Sinh Viên");
        System.out.println("8.Thoát");
        System.out.print("Bạn chọn: ");
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
                dem();
                break;
            case 8:
                System.err.println("Bye!!!");
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
        String s=(new Scanner(System.in)).nextLine();
        ds.add(s);
    }
    public static void xuat() {
        for(int i=0;i<ds.size();i++){
            System.out.print(ds.get(i)+"\t");
            System.out.println();
        }
    }

    public static void sua() {
        System.out.println("Nhap vi tri ban muon sua: ");
        int vtri=(new Scanner(System.in)).nextInt();
        System.out.println("Nhap chuoi can sua: ");
        String s=(new Scanner(System.in)).nextLine();
        ds.set(vtri, s);
    }

    public static void xoa(){
        System.out.println("Nhap vi tri ban muon xoa: ");
        int vtri=(new Scanner(System.in)).nextInt();
        ds.remove(vtri);
    }

    public static void timkiem() {
        String s=(new Scanner(System.in)).nextLine();
        if(ds.contains(s)){
            System.out.println("co xuat hien trong danh sach");
        }
        else System.out.println("khong co trong danh sach");
    }

    public static void sapxep() {
        Collections.sort(ds);
    }

    public static void dem() {
        int dem=0;
        for(int i=0;i<ds.size();i++){
            dem++;
        }
        System.out.println(dem+" Hoc Sinh");
    }
    
}
