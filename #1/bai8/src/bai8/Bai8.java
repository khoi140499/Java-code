/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai8;

import java.util.Scanner;

/**
 *
 * @author khoi
 */
public class Bai8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        tongcs(n);
    }
    public static void tongcs(int n){
        double tong=0;
        int themang;
        while(n<0) break;
        themang=n;
        while(themang!=0){
            tong=tong+themang%10;
            themang = themang/10;
        }
        System.out.println(" "+tong);
    }

}
