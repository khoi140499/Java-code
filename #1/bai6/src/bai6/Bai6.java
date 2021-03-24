/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai6;

import java.util.Scanner;

/**
 *
 * @author khoi
 */
public class Bai6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        double a=sc.nextDouble();
        double b=sc.nextDouble();
        int tmp;
        System.out.println("ucln : "+ucln(a,b));
        System.out.println("bcnn: "+(a*b)/ucln(a,b));
    }
    public static int ucln(double a, double b){
        int tmp;
        while(b!=0){
            tmp=(int) (a%b);
            a=b;
            b=tmp;
        }
        return (int) a;
    }   
}
