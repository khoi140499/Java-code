package bai18;

import java.util.Random;
import java.util.Scanner;

public class Bai18 {
    public static void nhap(int m[]){
        Random rd=new Random();
        System.out.println();
        {
        for(int i=0;i<m.length;i++){
            m[i]=100000+rd.nextInt(9000);
            }
        }
    }
    public static void xuat(int m[]){
        for(int i=0;i<m.length;i++){
            System.out.println(m[i]);
        }
    }
    public static void main(String[] args) {
        int m[]=new int[40];
        nhap(m);
        xuat(m);
    }
    
}
