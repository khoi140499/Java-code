package bai1;

import java.util.Scanner;
public class Bai1 {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        double n=sc.nextDouble();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==1||i==n||j==1||j==n){
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
             System.out.println();
        }
    }
    
}
