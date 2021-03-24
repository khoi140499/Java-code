package bai35;

import java.util.Scanner;

public class Bai35 {
    public static void ktra(String s1, String s2){
        String tu1=s1;
        String tu2=s2;
        int dem=0;
        String[] arr2=tu2.split(" ");
        String[] arr=tu1.split(" ");
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr2.length;j++){
                if(arr[i]==arr2[j]){
                    dem++;
                    System.out.println(" "+dem);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        ktra(s1,s2);
    }
    
}
