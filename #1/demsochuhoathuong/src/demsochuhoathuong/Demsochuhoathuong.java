/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demsochuhoathuong;

import java.util.Scanner;

/**
 *
 * @author khoi
 */
public class Demsochuhoathuong {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int demhoa=0;
        int demthuong=0;
        int demso=0;
        for(int i=0;i<s.length();i++){
            if(Character.isUpperCase(s.charAt(i))){
                demhoa++;
            }
            if(Character.isLowerCase(s.charAt(i))){
                demthuong++;
            }
            if(Character.isDigit(s.charAt(i))){
                demso++;
            }
        }
        System.out.println(" "+demhoa+" "+demthuong+" "+demso);
    }
    
}
