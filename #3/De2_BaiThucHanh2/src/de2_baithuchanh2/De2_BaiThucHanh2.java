package de2_baithuchanh2;

import java.util.*;
import java.io.*;

public class De2_BaiThucHanh2 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<MatHang> list=new ArrayList<>();
        MatHang mh=new MatHang();
        File f=new File("VAO.INP");
        Scanner sc=new Scanner(f);
        int maHang=0;
        double giaBan=0;
        String ten="";
        String nhom="";
        int kt=0, dem=0;
        while(sc.hasNext()){
            try{
                dem++;
                maHang=Integer.parseInt(sc.nextLine());
                String s=String.valueOf(maHang);
                if(s.length()!=4){
                    sc.nextLine();
                    sc.nextLine();
                    sc.nextLine();
                    try{
                        throw new Exception("Mat hang thu "+dem+" da sai thong tin: MA HANG PHAI CO 4 CHU SO");
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
                            throw new Exception("Mat hang thu "+dem+" da sai thong tin: TEN HANG KHONG DUOC DE TRONG");
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    else{
                        nhom=sc.nextLine();
                        if(nhom.equalsIgnoreCase("hang tieu dung")==false && nhom.equalsIgnoreCase("hang thoi trang")==false 
                          && nhom.equalsIgnoreCase("dien tu - dien lanh")==false){
                            sc.nextLine();
                            try{
                                throw new Exception("Mat hang thu "+dem+" da sai thong tin: TEN NHOM HANG KHONG DUNG");
                            }catch(Exception e){
                                System.out.println(e.getMessage());
                            }
                        }
                        else{
                            giaBan=Double.parseDouble(sc.nextLine());
                            String s1=String.valueOf(giaBan);
                            if(s1.length()<0){
                                try{
                                    throw new Exception("Mat hang thu "+dem+" da sai thong tin: GIA BAN KHONG DUOC NHO 0");
                                }catch(Exception e){
                                    System.out.println(e.getMessage());
                                }
                            }
                            else kt=1;
                        }
                    }
                }
            }catch(NumberFormatException|InputMismatchException e){
                System.out.println("Mat hang thu "+dem+" nhap sai thong tin");
            }
            if(kt==1){
                MatHang mh1=new MatHang(maHang, ten, nhom, giaBan);
                list.add(mh1);
                kt=0;
            }
        }
        for(MatHang a:list){
            System.out.println(a.toString());
        }
        PrintWriter pr=new PrintWriter("SX.OUT");
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object a, Object b){
                return (new Double(((MatHang)b).getGiaBan()).compareTo(new Double(((MatHang)a).getGiaBan())));
            }
        });
        for(MatHang d:list)
        pr.println(d.toString());
        pr.close();
        PrintWriter pr1=new PrintWriter("NHOM.OUT");
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object a, Object b){
                return (new String(((MatHang)a).getTen()).compareToIgnoreCase(new String(((MatHang)b).getTen())));
            }
        });
        Comparator<MatHang> com=new Comparator<MatHang>() {
            @Override
            public int compare(MatHang o1, MatHang o2) {
               return o1.getNhom().compareToIgnoreCase(o2.getNhom());
            }
        };
        Collections.sort(list, com);
        for(MatHang as:list)
           pr1.println(as.toString());
        pr1.close();
    }
    
}
