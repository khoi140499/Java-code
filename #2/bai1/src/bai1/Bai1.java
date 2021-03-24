package bai1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) throws IOException {
        ArrayList<SinhVien> sinhvien=new ArrayList<>();
        Scanner sc=new Scanner(new File("D:\\codejava\\2\\bai1\\VAO.IN"));
        int masv=0,dem=0,kt=0;
        double dtb=0;
        String ten="";
        String lop="";
        while(sc.hasNext()){
            try{
            dem++;
            masv=Integer.parseInt(sc.nextLine());
            String s=String.valueOf(masv);
            if(s.length()!=4){
                sc.nextLine();
                sc.nextLine();
                sc.nextLine();
                try{
                    throw new ngoaile("Sinh vien thu "+dem+" thong tin sai: DO MA SINH VIEN KHONG BANG 4");
                }catch(ngoaile e){
                    System.out.println(e.getMessage());
                }
            }
            else{
                ten=sc.nextLine();
                if(ten.length()==0){
                    sc.nextLine();
                    sc.nextLine();
                    try{
                        throw new ngoaile("Sinh vien thu "+dem+" thong tin sai: DO TEN DE TRONG");
                    }catch(ngoaile e){
                        System.out.println(e.getMessage());
                    }
                }else{
                    lop=sc.nextLine();
                    if(lop.length()!=10){
                        sc.nextLine();
                        try{
                            throw new ngoaile("Sinh vien thu "+dem+" thong tin sai: TEN LOP SAI QUY DINH");
                        }catch(ngoaile e){
                            System.out.println(e.getMessage());
                        }
                    }
                    else{
                        dtb=Integer.parseInt(sc.nextLine());
                        if(dtb<0 && dtb>10){
                            try{
                                throw new ngoaile("Sinh vien thu "+dem+" thong tin sai: DIEM TRUNG BINH KHONG HOP LE");
                            }catch(ngoaile e){
                                System.out.println(e.getMessage());
                            }
                        }else kt=1;
                    }
                }
            }
        }catch(NumberFormatException|InputMismatchException e){
                System.out.println("Sinh vien thu "+dem+" nhap sai dinh dang");
        }
            if(kt==1){
                SinhVien sv=new SinhVien();
                sinhvien.add(sv);
                kt=0;
            }
       }
        for(SinhVien sv:sinhvien){
            System.out.println(sv.toString());
        }
        Collections.sort(sinhvien, );
    }
}
