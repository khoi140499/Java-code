package bai17;

import java.util.Scanner;

public class Bai17 {
    public static long f(int k, int n){
        if(k==0||k==n) return 1;
        else return f(k, n-1)+f(k-1, n-1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<=n;i++){
            for(int j=n;j>i;j--){
                System.out.print("\t");
            }
            for(int j=0;j<=i;j++){
                System.out.print("\t"+f(j,i));
            }
            System.out.println();
        }   
    }
}
