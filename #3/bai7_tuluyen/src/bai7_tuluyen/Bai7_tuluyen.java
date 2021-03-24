package bai7_tuluyen;

import java.util.*;
import java.io.*;

public class Bai7_tuluyen {
    public static void main(String[] args) {
        SinhVien sv;
        Scanner sc=new Scanner(System.in);
        ArrayList<SinhVien> ar=new ArrayList<>();
        System.out.println("Nhap so sinh vien: ");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            sv=new SinhVien();
            sv.nhap();
            ar.add(sv);
        }
        Collections.sort(ar, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                return o1.getMaSv()-o2.getMaSv();
            }
        });
        for(SinhVien a:ar)
            System.out.println(a.toString());
    }
    
}
