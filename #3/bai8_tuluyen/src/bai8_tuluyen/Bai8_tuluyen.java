package bai8_tuluyen;

import java.util.*;

public class Bai8_tuluyen {
    public static ArrayList<Cd> ar=new ArrayList<Cd>(3);
    public static Cd cd;
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        while(true){
            menu();
        }
    }
    public static void menu(){
        System.out.println("1. Them CD");
        System.out.println("2. So luong CD");
        System.out.println("3. Tong gia thanh");
        System.out.println("4. Sap xep theo gia");
        System.out.println("5. Sap xep theo tua CD");
        System.out.println("6. Xuat danh sach");
        System.out.println("7. Thoat");
        System.out.println("Ban chon: ");
        int n=sc.nextInt();
        switch(n){
            case 1: 
                them();
                break;
            case 2: 
                Soluong();
                break;
            case 3: 
                Tonggiathanh();
                break;
            case 4: 
                Sapxeptheogia();
                break;
            case 5: 
                Sapxeptheotua();
                break;
            case 6: 
                Sapxeptheoten();
                break;    
            case 7: 
                System.err.println("Bye!!");
                System.exit(0);
                break;    
        }
    }
    public static void them(){
          cd=new Cd();
          cd.nhap();
          ar.add(cd);
    }
    public static void Soluong() {
        
    }
    public static void Tonggiathanh() {
        
    }
    public static void Sapxeptheogia() {
        
    }
    public static void Sapxeptheotua() {
        
    }
    public static void Sapxeptheoten() {
        
    }
}
