package bai20;

import java.util.Random;
import java.util.Scanner;

public class Bai20 {
    public static void nhap(int m[]){
        Random rd=new Random();
        for(int i=0;i<m.length;i++){
            m[i]=1000+rd.nextInt(9000);
        }
    }
    public static void xuat(int m[]){
        for(int i=0;i<m.length;i++){
            System.out.print(m[i]+"\t");
        }
    }
    public static boolean snt(int i){
        if(i%2==0) return false;
        for(int j=0;j<Math.sqrt((float)i);j++){
            if(j%i==0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
       int m[]=new int[500];
       nhap(m);
        System.out.println("mảng ngẫu nhiên: ");
        xuat(m);
        int n=(new Scanner(System.in)).nextInt();
        for(int i=n;i>=2;i--){
            if(snt(i)==true) {
                System.out.println("Số nguyên tố gần nhất với "+n+" là : ");
            }
        }
    }
    
}
