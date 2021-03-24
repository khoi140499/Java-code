/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai9;

import java.util.Scanner;

/**
 *
 * @author khoi
 */
public class Bai9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int dem;
        for(int i=2;i<=n;i++){
            dem=0;
            while(n%i==0){
                dem++;
                n/=i;
            }
            if(dem!=0){
            System.out.print(i);
           if(dem>1) System.out.print("^"+dem);
           if(n>i) System.out.print("*");
            }
        }
    } 
}
