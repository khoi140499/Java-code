/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uocle;

import java.util.Scanner;

/**
 *
 * @author khoi
 */
public class Uocle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int max=0;
        for(int i=1;i<=n;i++){
            if(n%i==0 && i%2==1){
                if(max<i) max=i;
            }
        }
        System.out.println(" "+max);
    }
    
}
