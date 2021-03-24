package bai25;

import java.util.Scanner;

public class Bai25 {

    public static void main(String[] args) {
       int a[][], b[][], c[][] = null;
       int tong=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập m,n,k của ma trận a và b: ");
        int m=sc.nextInt();
        int n=sc.nextInt();
        int k=sc.nextInt();
        a=new int[m][n];
        b=new int[n][k];
        c=new int[m][k];
        System.out.println("Nhập ma trận a:");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j]=sc.nextInt();
            }
        }
        System.out.println("Nhập ma trận b:");
        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                b[i][j]=sc.nextInt();
            }
        }
        System.out.println("Ma trận a vừa nhập: ");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(a[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println("Ma trận b vừa nhập: ");
        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                System.out.print(b[i][j]+"  ");
            }
            System.out.println();
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int l=0;l<k;l++){
                    tong = tong + a[i][j] * b[j][l];
                    c[i][l]=tong;
                }   
            }
        }
        System.out.println("Mảng c : ");
        for(int i=0;i<m;i++){
            for(int j=0;j<k;j++){
                System.out.print(c[i][j]+"  ");
            }
            System.out.println();
        }
    }
    
}
