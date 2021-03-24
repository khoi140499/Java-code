package hocmang;

import java.util.Scanner;

public class Hocmang {
    public static void main(String[] args) {
        int[] m;
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap so phan tu cua mang: ");
        int n=sc.nextInt();
        m=new int[n];
        for(int i=0;i<m.length;i++){
            System.out.println("Nhap phan tu M["+i+"] : ");
            m[i]=sc.nextInt();
        }
        System.out.println("Mang sau khi nhap la: ");
        for(int i=0;i<m.length;i++){
                 System.out.print(m[i]+"\t");
        }
        System.out.println("Mang sau khi nhap la: ");
        for(int i : m){
            System.out.print(i+"\t");
        }
        m[2]=110;
        System.out.println("Mang sau khi nhap la: ");
        for(int i=0;i<m.length;i++){
                 System.out.print(m[i]+"\t");
        }
    }
}
