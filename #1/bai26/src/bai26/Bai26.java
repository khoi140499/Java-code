package bai26;

import java.util.Scanner;

public class Bai26 {
    static int count=0;
    public static void main(String[] args) {
        init();
    }
    public static void topright(int[][] m, int x1, int y1, int x2, int y2){
        for(int i=x1;i<=x2;i++){
            m[y1][i]=count++;
        }
        for(int i=y1+1;i<=y2;i++){
            m[i][x2]=count++;
        }
        if(x2-x1>0 && y2-y1>0){
            y1++;
            x2--;
            topleft(m,x1,y1,x2,y2);
        }
    }
    public static void topleft(int[][] m, int x1, int y1, int x2, int y2){
        for(int i=x2;i>=x1;i--){
            m[y2][i]=count++;
        }
        for(int i=y2-1;i>=y1;i--){
            m[i][x1]=count++;
        }
        if(x2-x1>0 && y2-y1>0){
            y2--;
            x1++;
            topright(m,x1,y1,x2,y2);
        }
    }
    public static void init(){
        int[][] m;
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập số phần tử của ma trận: ");
        int n=sc.nextInt();
        m=new int[n][n];
        topright(m,0,0,n-1,n-1);
        dis(m);
    }
    public static void dis(int[][] m){
        for(int[] d : m){
            for(int i:d) System.out.print(i+"\t");
            System.out.println();
        }
    }
}
