package d;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int N=0;
        int K=0;
        int a[]=new int[n];
        for(int i=0;i<a.length;i++){
                N=sc.nextInt();
                K=sc.nextInt();
                System.out.println(Math.pow(N, K));
        }
        
    }
    
}
