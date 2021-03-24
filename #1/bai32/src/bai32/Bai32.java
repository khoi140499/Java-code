package bai32;

import java.util.Scanner;

public class Bai32 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String []arr=s.split(" ");
        int i=arr.length;
        System.out.print(arr[i-1]);
        for(int j=0;j<arr.length-1;j++){
            System.out.print(" "+arr[j]);
        }
        System.out.println();
    }
}
