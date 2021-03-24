/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

import java.util.Scanner;

/**
 *
 * @author khoi
 */
public class Bai2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                System.out.print(" "); /*in khoang trang*/
            }
            for(int k=1;k<=i;k++){
                System.out.print(""+k); /*in so tang dan den trung tam*/
            }
            for(int l=i-1;l>=1;l--){
                System.out.print(""+l); /*in so giam dan tu trung tam*/
            }
            System.out.println();
        }
    }
    
}
