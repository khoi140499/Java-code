package luyenhashmap;

import java.util.HashMap;
import java.util.*;

public class LuyenHashMap {
    static HashMap<Integer, String> ds=new HashMap<Integer, String>();
    public static void menu(){
        System.out.println("1.Them");
        System.out.println("2.Xuat");
        System.out.println("3.Sua");
        System.out.println("4.Xoa");
        System.out.println("5.Tim Kiem");
        System.out.println("6.Thoat");
        System.out.print("Ban chon: ");
        int chon=(new Scanner(System.in)).nextInt();
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
                System.err.println("Bye!!");
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
        System.out.println("Nhap khoa chinh: ");
        int ma=(new Scanner(System.in)).nextInt();
        System.out.println("Nhap ten sach: ");
        String s=(new Scanner(System.in)).nextLine();
        if(ds.containsKey(ma)==false){
            ds.put(ma, s);
        }
    }

    public static void xuat() {
        System.out.println("ma/tensach:  ");
        for(Map.Entry<Integer, String> item : ds.entrySet()){
            System.out.println(item.getKey()+"\t"+item.getValue());
        }
    }

    public static void sua() {
       System.out.println("Nhap khoa chinh ban muon sua :");
       int ma=(new Scanner(System.in)).nextInt();
        String s=(new Scanner(System.in)).nextLine();
       if(ds.containsKey(ma)==false){
           System.out.println("Ma khong ton tai");
       }
       else {
           ds.put(ma, s);
       }
    }

    public static void xoa() {
        System.out.println("Nhap khoa chinh ban muon xoa: ");
        int ma=(new Scanner(System.in)).nextInt();
        if(ds.containsKey(ma)==false){
            System.out.println("Khong hop le");
        }
        else{
            ds.remove(ma);
        }
            }

    public static void timkiem() {
        System.out.println("Nhap ten sach b muon tim: ");
        String s=(new Scanner(System.in)).nextLine();
        for(Map.Entry<Integer, String> item : ds.entrySet()){
            if(item.getValue().contains(s)){
                System.out.println(item.getKey()+"\t"+item.getValue());
            }
        }
    }

    
}
