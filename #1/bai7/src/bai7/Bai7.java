/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai7;

import java.util.Scanner;

/**
 *
 * @author khoi
 */
public class Bai7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        lke(a,b);
    }
    public static boolean snt(int b){
        if(b<2) return false;
        else if(b>2){
            if(b%2==0) return false;
            for(int i=3;i<=Math.sqrt((float)b);i+=2){
                if(b%i==0) return false;
            }
        }
        return true;
    }
    public static void lke(int a, int b){
        for(int i=a;i<=b;i++){
            if(snt(i)==true){
                System.out.println(" "+i);
            }
        }
    }
}
