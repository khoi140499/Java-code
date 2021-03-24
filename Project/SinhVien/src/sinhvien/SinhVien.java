package sinhvien;

import java.util.*;
import java.io.*;

public class SinhVien {
    static ArrayList<Sv> list=new ArrayList<>();
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) throws IOException{
        while(true){
            menu();
        }
    }
    public static void menu1(){
        System.out.println("Ban muon tim kiem theo tieu chi nao ?");
        System.out.println("1. Ma Sinh Vien");
        System.out.println("2. Ten");
        System.out.println("3. Lop");
        System.out.println("4. Diem trung binh");
        System.out.println("5. Thoat");
        System.out.println("=> ");
        int n=sc.nextInt();
        if(n<0| n>5){
            System.err.println("Tieu chi ban chon khong co trong menu nay");
        }
        else{
            switch(n){
                case 1:
                    ma1();
                    break;
                case 2:
                    ten1();
                    break;
                case 3:
                    lop1();
                    break;
                case 4:
                    dtb1();
                    break;
                case 5:
                    System.err.println("Cam on ban da tim kiem");
                    break;
            }
        }
        System.out.println("===================================");
    }
    public static void menu() throws IOException{
        System.out.println("1. Them Sinh Vien");
        System.out.println("2. Xuat Sinh Vien");
        System.out.println("3. Sap Xep Theo Ten");
        System.out.println("4. Sap Xep Theo Diem Trung Binh");
        System.out.println("5. Luu Vao File");
        System.out.println("6. Doc File");
        System.out.println("7. Tim Kiem");
        System.out.println("8. Thoat");
        System.out.println("Ban chon: ");
        int n=sc.nextInt();
        if(n<0|n>8){
            System.err.println("Ban nhap khong hop le");
        }
        else{
            switch(n){
                case 1: 
                    them();
                    break;
                case 2: 
                    xuat();
                    break;
                case 3: 
                    sxt();
                    break;
                case 4: 
                    sxd();
                    break;
                case 5: 
                    luu();
                    break;
                case 6: 
                    doc();
                    break;
                case 7: 
                    timkiem();
                    break;
                case 8: 
                    System.err.println("Cam on ban!!!");
                    System.exit(0);
                    break;
            }
        }
    }
    public static void them() {
        Sv sv=new Sv();
        System.out.println("Nhap ma sv: ");
        int ma = (new Scanner(System.in)).nextInt();
        System.out.println("Nhap ten: ");
        String ten = (new Scanner(System.in)).nextLine();
        System.out.println("Nhap lop: ");
        String lop = (new Scanner(System.in)).nextLine();
        System.out.println("Nhap diem trung binh: ");
        double dtb = (new Scanner(System.in)).nextDouble();
        sv.setMa(ma);
        sv.setTen(ten);
        sv.setLop(lop);
        sv.setDtb(dtb);
        list.add(sv);
    }
    public static void xuat() {
        Sv sv=new Sv();
        System.out.println("===================================");
        for(Sv a:list){
            System.out.println(a.toString());
        }
        System.out.println("===================================");
    }
    public static void sxt() {
        System.out.println("===================================");
        Sv sv=new Sv();
        Comparator<Sv> com=new Comparator<Sv>() {
            @Override
            public int compare(Sv o1, Sv o2) {
                int a=o1.getTen().compareToIgnoreCase(o2.getTen());
                if(o1.getLop().charAt(1)!=o2.getLop().charAt(1)){
                    if(o1.getLop().charAt(2)!=o2.getLop().charAt(2)){
                        if(o1.getLop().charAt(3)!=o2.getLop().charAt(3)){
                            if(o1.getLop().charAt(4)!=o2.getLop().charAt(4)){
                                if(o1.getLop().charAt(5)!=o2.getLop().charAt(5)){
                                    if(o1.getLop().charAt(6)!=o2.getLop().charAt(6)){
                                        if(o1.getLop().charAt(7)!=o2.getLop().charAt(7)){
                                            if(o1.getLop().charAt(8)!=o2.getLop().charAt(8)){
                                                if(o1.getLop().charAt(9)!=o2.getLop().charAt(9)){
                                                    return a;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return o1.getLop().compareToIgnoreCase(o2.getLop());
            }
        };
        Collections.sort(list, com);
        for(Sv a:list)
            System.out.println(a.toString());
        System.out.println("===================================");
    }
    public static void sxd() {
        System.out.println("===================================");
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (new Double(((Sv)o1).getDtb()).compareTo(new Double(((Sv)o2).getDtb())));
            }
        });
        for(Sv a:list)
            System.out.println(a.toString());
        System.out.println("===================================");
    }
    public static void doc() throws IOException {
        System.out.println("===================================");
        list=Tep.Tep("FILE.OUT");
        System.err.println("Doc File thanh cong");
        System.out.println("===================================");
    }
    public static void luu() {
        System.out.println("===================================");
        boolean kt=Tep.luuFile(list,"FILE.OUT");
        if(kt==true){
            System.out.println("Luu tep thanh cong");
        }
        else{
            System.out.println("Luu tep that bai");
        }
        System.out.println("===================================");
    }
    public static void timkiem() {
        System.out.println("===================================");
            menu1();
        System.out.println("===================================");
    }

    public static void ma1() {
        System.out.println("Nhap ma sinh vien ban muon tim");
        int s=sc.nextInt();
        for(Sv as:list){
            if(as.getMa()==s){
                System.out.println(as.toString());
            }
            else{
                System.out.println("Khong tim thay");
            }
        }
    }
    public static void ten1() {
        System.out.println("Nhap ten sinh vien ban muon tim");
        String s=sc.nextLine();
        for(Sv as:list){
            if(as.getTen().equalsIgnoreCase(s)){
                System.out.println(as.toString());
            }
            else{
                System.out.println("Khong tim thay");
            }
        }
    }
    public static void lop1() {
        System.out.println("Nhap lop sinh vien ban muon tim");
        String s=sc.nextLine();
        for(Sv as:list){
            if(as.getLop().startsWith(s)){
                System.out.println(as.toString());
            }
            else{
                System.out.println("Khong tim thay");
            }
        }
    }
    public static void dtb1() {
        System.out.println("Nhap ma sinh vien ban muon tim");
        double s=sc.nextDouble();
        for(Sv as:list){
            if(as.getDtb()==s){
                System.out.println(as.toString());
            }
            else{
                System.out.println("Khong tim thay");
            }
        }
    }
}
