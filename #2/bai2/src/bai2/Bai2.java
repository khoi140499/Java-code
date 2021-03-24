package bai2;

import java.util.*;
import java.io.*;

public class Bai2 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<SinhVien> ar=new ArrayList<>();
        Scanner sc=new Scanner(new File("VAO.INP"));
        String ten="";
        String masv="";
        String lop="";
        String khoa="";
        int kt=0, dem=0;
        while(sc.hasNext()){
            try{
                dem++;
                masv=sc.nextLine();
                if(masv.length()!=10){
                    sc.nextLine();
                    sc.nextLine();
                    sc.nextLine();
                    try{
                        throw new Exception("Sinh vien thu "+dem+" nhap sai thong tin: SAI DINH DANG MA SINH VIEN");
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                else{
                    ten=sc.nextLine();
                    if(ten.length()==0){
                        sc.nextLine();
                        sc.nextLine();
                        try{
                            throw new Exception("Sinh vien thu "+dem+" nhap sai thong tin: TEN KHONG DUOC DE TRONG");
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    else{
                        lop=sc.nextLine();
                        if(lop.length()!=9){
                            sc.nextLine();
                            try{
                                throw new Exception("Sinh vien thu "+dem+" nhap sai thong tin: SAI DINH DANG LOP");
                            }catch(Exception e){
                                System.out.println(e.getMessage());
                            }
                        }
                        else{
                            khoa=sc.nextLine();
                            if(khoa.length()!=3){
                                try{
                                    throw new Exception("Sinh vien thu "+dem+" nhap sai thong tin: SAI DINH DANG KHOA");
                                }catch(Exception e){
                                    System.out.println(e.getMessage());
                                }
                            }else kt=1;
                        }
                    }
                }
            }catch(NumberFormatException|InputMismatchException e){
                System.out.println("Sinh vien thu "+dem+ "nhap sai thong tin ");
            }
            if(kt==1){
                SinhVien sv=new SinhVien(masv, ten, lop, khoa);
                ar.add(sv);
                kt=0;
            }
        }
        PrintWriter pr=new PrintWriter("XUAT.OUT");
        Comparator<SinhVien> com=new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                int a=o1.getTen().compareToIgnoreCase(o2.getTen());
                int b=o1.getTen().length()-1;
                int c=o2.getTen().length()-1;
                if(o1.getTen().charAt(0)!=o2.getTen().charAt(0)){
                    if(o1.getTen().charAt(1)!=o2.getTen().charAt(1)){
                      if(o1.getTen().charAt(b)!=o2.getTen().charAt(c)){
                            return a;
                       }
                    }
                }
                return o1.getTen().compareToIgnoreCase(o2.getTen());
            }
        };
        Comparator<SinhVien> scc=new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                int a=o1.getLop().compareToIgnoreCase(o2.getLop());
                int b=o1.getLop().length()-1;
                int c=o2.getLop().length()-1;
                if(o1.getLop().charAt(0)!=o2.getLop().charAt(0)){
                    if(o1.getLop().charAt(1)!=o2.getLop().charAt(1)){
                      if(o1.getLop().charAt(b)!=o2.getLop().charAt(c)){
                            return a;
                       }
                    }
                }
                return o1.getLop().compareToIgnoreCase(o2.getLop());
        }
    };
    Collections.sort(ar, scc);
    for(SinhVien asd:ar)
            pr.println(asd.toString());
    pr.close();
    for(SinhVien aa:ar)
            System.out.println(aa.toString());
    }
}
