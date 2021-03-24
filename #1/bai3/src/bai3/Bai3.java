package bai3;

import java.util.Random;
import java.util.Scanner;

public class Bai3 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Random random=new Random();
        int dem=0;
        while(true){
            dem++;
            int rd=10 + random.nextInt(90);
            System.out.println("Random Number: " +rd +" - n: " + n);
            if(rd==n){
                System.out.println("Thực hiện :" +dem);
                break;
            }
        }
    }
    
}
