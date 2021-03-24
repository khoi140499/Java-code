package de3_baithuchanh2;

import java.util.*;
import java.io.*;

public class De3_BaiThucHanh2 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Sach> list=new ArrayList<>();
        Sach sach=new Sach();
        Scanner sc=new Scanner(new File("VAO.INP"));
        int maSach=0;
        String tenSach="";
        String chuyenNghanh="";
        double giaBan=0;
        int kt=0, dem=0;
        while(sc.hasNext()){
            try{
                dem++;
                maSach=Integer.parseInt(sc.nextLine());
                String s=String.valueOf(maSach);
                if(s.length()!=4){
                    sc.nextLine();
                    sc.nextLine();
                    sc.nextLine();
                    try{
                        throw new ngoaile("Sach thu "+dem+" bi sai thong tin: MA SACH PHAI CO 4 CHU SO");
                    }catch(ngoaile e){
                        System.out.println(e.getMessage());
                    }
                }
                else{
                    tenSach=sc.nextLine();
                    if(tenSach.length()==0){
                        sc.nextLine();
                        sc.nextLine();
                        try{
                            throw new ngoaile("Sach thu "+dem+" bi sai thong tin: TEN SACH KHONG DUOC DE TRONG");
                        }catch(ngoaile e){
                            System.out.println(e.getMessage());
                        }
                    }
                    else{
                        chuyenNghanh=sc.nextLine();
                        if(chuyenNghanh.equalsIgnoreCase("giao khoa")==false && chuyenNghanh.equalsIgnoreCase("ky thuat")==false &&
                                chuyenNghanh.equalsIgnoreCase("ngoai ngu")==false && chuyenNghanh.equalsIgnoreCase("van hoc")==false &&
                                chuyenNghanh.equalsIgnoreCase("kinh te")==false && chuyenNghanh.equalsIgnoreCase("thieu nhi")==false &&
                                chuyenNghanh.equalsIgnoreCase("y hoc")==false && chuyenNghanh.equalsIgnoreCase("lich su")==false &&
                                chuyenNghanh.equalsIgnoreCase("ky nang song")==false && chuyenNghanh.equalsIgnoreCase("cong nghe thong tin")==false &&
                                chuyenNghanh.equalsIgnoreCase("truyen tranh")==false && chuyenNghanh.equalsIgnoreCase("chinh tri")==false){
                            sc.nextLine();
                            try{
                                throw new ngoaile("Sach thu "+dem+" bi sai thong tin: CHUYEN NGHANH SACH KHONG TON TAI");
                            }catch(ngoaile e){
                                System.out.println(e.getMessage());
                            }
                        }
                        else{
                            giaBan=Double.parseDouble(sc.nextLine());
                            String s1=String.valueOf(giaBan);
                            if(s1.length()==0){
                                try{
                                    throw new ngoaile("Sach thu "+dem+" bi sai thong tin: GIA BAN PHAI KHAC KHONG");
                                 }catch(ngoaile e){
                                     System.out.println(e.getMessage());
                                 }
                            }else kt=1;
                        }
                    }
                }
            }catch(NumberFormatException|InputMismatchException e){
                System.out.println("Sach thu "+dem+" bi nhap sai thong tin");
            }
            if(kt==1){
                Sach sach1=new Sach(maSach, tenSach, chuyenNghanh, giaBan);
                list.add(sach1);
                kt=0;
            }
        }
        for(Sach a:list)
        System.out.println(a.toString());
        PrintWriter pr=new PrintWriter("SX.OUT");
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object a, Object b) {
                return (new Double(((Sach)b).getGiaBan()).compareTo(new Double(((Sach)a).getGiaBan())));
            }
        });
        for(Sach b:list)
        pr.println(b.toString());
        pr.close();
        PrintWriter pr1=new PrintWriter("CN.OUT");
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object a, Object b) {
                return (new String(((Sach)a).getTenSach()).compareToIgnoreCase(new String(((Sach)b).getTenSach())));
            }
        });
        Comparator<Sach> com=new Comparator<Sach>() {
            @Override
            public int compare(Sach o1, Sach o2) {
                return o1.getChuyenNghanh().compareToIgnoreCase(o2.getChuyenNghanh());
            }
        };
        Collections.sort(list, com);
        for(Sach as:list)
            pr1.println(as.toString());
        pr1.close();
    }
    
}
