package bai22;

import java.util.Scanner;

public class Bai22 {
    public static void main(String[] args) {
       int[] a,b,c;
       int m,n,k,p;
        Scanner sc=new Scanner(System.in);
                
        System.out.println("Nhập số phần tử của mảng a: ");
        m=sc.nextInt();
        a=new int[m];
        for(int i=0;i<a.length;i++){
            System.out.print("a["+i+"] : ");
            a[i]=sc.nextInt();
        }
        System.out.println();
        System.out.println("Nhập số phần tử của mảng b: ");
        n=sc.nextInt();
        b=new int[n];
        for(int i=0;i<b.length;i++){
            System.out.print("b["+i+"] : ");
            b[i]=sc.nextInt();
        }
        System.out.println();
        System.out.println("Mảng a đã nhập");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+"\t");
        }
        System.out.println();
        System.out.println("Mảng b đã nhập");
        for(int i=0;i<b.length;i++){
            System.out.print(b[i]+"\t");
        }
        k=m+n;
        c=new int[k];
        System.out.println();
        System.out.println("Nhập vị trí cần chèn mảng: ");
        do{
            p=sc.nextInt();
        }
        while(p>m||p<0);
        for(int i=0;i<p;i++){
            c[i]=a[i];
        }        
        for(int i=0;i<n;i++){
            c[i+p]=b[i];
        }
        for(int i=p;i<m;i++){
            c[i+n]=a[i];
        }
        System.out.println();
        System.out.println("Mảng sau khi đã gộp là :");
        for(int i=0;i<c.length;i++){
            System.out.print(c[i]+"\t");
        }
    }
    
}
