package de4_baithuchanh2;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
public class De4_BaiThucHanh2 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<MonHoc>danhsach=new ArrayList<>();
        Scanner sc=new Scanner(new File("VAO.INP"));
        int maMon=0;
        int kt=0;
        int dem=0;
        int soTinchi=0;
        String tenMon="";
        String nhomMon="";
        while(sc.hasNext()){
            try {
                dem++;
                maMon=Integer.parseInt(sc.nextLine());
                String s=String.valueOf(maMon);
                if(s.length()!=4){
                    sc.nextLine();
                    sc.nextLine();
                    sc.nextLine();
                    try{
                        throw new ngoaile("Mon hoc thu "+dem+"  sai thong tin: NHAP SAI DINH DANG MA MON");
                    }catch(ngoaile e){
                        System.out.println(e.getMessage());
                    }
                }
                else{
                    tenMon=sc.nextLine();
                    if(tenMon.length()==0){
                        sc.nextLine();
                        sc.nextLine();
                        try{
                            throw new ngoaile("Mon hoc thu "+dem+" sai thong tin: TEN MON HOC KHONG DUOC DE TRONG");
                        }catch(ngoaile e){
                            System.out.println(e.getMessage());
                        }
                    }
                    else{
                        nhomMon=sc.nextLine();
                        if(nhomMon.equalsIgnoreCase("co ban")==false &&
                           nhomMon.equalsIgnoreCase("co so nghanh")==false &&
                           nhomMon.equalsIgnoreCase("chuyen nghanh")==false &&
                           nhomMon.equalsIgnoreCase("ky nang mem")==false){
                            sc.nextLine();
                            try{
                                throw new ngoaile("Mon hoc thu "+dem+" sai thong tin: NHAP SAI MA MON HOC");
                            }catch(ngoaile e){
                                System.out.println(e.getMessage());
                            }
                        }
                        else{
                            soTinchi=Integer.parseInt(sc.nextLine());
                            if(soTinchi <=0 || soTinchi >7){
                                try{
                                    throw new ngoaile("Mon hoc thu "+dem+" sai thong tin: SO TIN CHI PHAI LON HON 0, NHO HON 7");
                                }catch(ngoaile e){
                                    System.out.println(e.getMessage());
                                }
                            }
                            else kt=1;
                        }
                    }
                }
            } catch (NumberFormatException|InputMismatchException e) {
                System.out.println("Mon hoc thu "+dem+" sai thong tin: NHAP SAI DINH DANG");
            }
            if(kt==1){
                MonHoc mh=new MonHoc(maMon, tenMon, nhomMon, soTinchi );
                danhsach.add(mh);
                kt=0;
            }
        }
        for(MonHoc a:danhsach)
            System.out.println(a.toString());
        PrintWriter pr=new PrintWriter("SX.OUT");
        Collections.sort(danhsach, new Comparator() {
            @Override
            public int compare(Object a, Object b) {
               return (new Integer(((MonHoc)b).getSoTinchi()).compareTo(new Integer(((MonHoc)a).getSoTinchi())));
            }
        });
        for(MonHoc a:danhsach)
        pr.println(a.toString());
        pr.close();
        PrintWriter pr1=new PrintWriter("XUAT.OUT");
        Collections.sort(danhsach, new Comparator() {
            @Override
            public int compare(Object a, Object b) {
               return (new String(((MonHoc)a).getTenMon()).compareToIgnoreCase(new String(((MonHoc)b).getTenMon())));
            }
        });
        Comparator<MonHoc> com=new Comparator<MonHoc>() {
            @Override
            public int compare(MonHoc a, MonHoc b) {
                return a.getNhomMon().compareToIgnoreCase(b.getNhomMon());
            }
        };
        Collections.sort(danhsach, com);
        for(MonHoc asd:danhsach)
            pr1.println(asd.toString());
        pr1.close();
        
    }   
}
