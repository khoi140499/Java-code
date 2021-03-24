/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chusochan;

import java.util.Scanner;

/**
 *
 * @author khoi
 */
public class Chusochan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(scc(n)==true) System.out.println("Yes ");
          else   System.out.println("No");
        }
        public static boolean scc(int n){
        int tg=0;
        while(n>0){
            tg=n%10;
            n/=10;
            if(tg%2==1) return false;
        }
        return true;
    }
}
