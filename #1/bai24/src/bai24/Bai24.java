package bai24;

import java.util.Scanner;

public class Bai24 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a[][]=null;
        System.out.println("Nhập m,n của ma trận a: ");
        int m=sc.nextInt();
        int n=sc.nextInt();
        a=new int[m][n];
        System.out.println("Nhập các phần tử của ma trận a : ");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j]=sc.nextInt();
            }
        }
        System.out.println("Ma trận vừa nhập : ");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(a[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println("Ma trận chuyển vị của ma trận a: ");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(a[j][i]+"  ");
            }
            System.out.println();
        }
    }
    
}
