/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package songuyento;

import java.util.Scanner;

/**
 *
 * @author khoi
 */
public class Songuyento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        lke(n);
    }
    public static boolean snt(int n){
        if(n<2) return false;
        else if(n>2){
            if(n%2==0) return false ;
            for(int i=3;i<=Math.sqrt((float)n);i+=2){
                if(n%i==0) return false;
            }
        }
        return true;
    }
    public static void lke(int n){
        for(int i=2;i<=n;i++){
            if(snt(i)==true){
                System.out.println(" "+i);
            }
        }
    }
}
