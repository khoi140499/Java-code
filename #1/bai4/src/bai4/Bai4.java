/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai4;

import java.util.Scanner;

/**
 *
 * @author khoi
 */
public class Bai4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        double tong=0;
        if(n%2==0){
            for(int i=0;i<=n;i++){
                if(i%2==0){
                    tong+=i;
                }
            }
        }
        else {
            for(int i=0;i<=n;i++){
                if(i%2==1){
                    tong+=i;
                }
            }
        }
        System.out.println(+tong);
    }
    
}
