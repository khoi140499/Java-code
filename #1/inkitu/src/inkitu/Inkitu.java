/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inkitu;

import java.util.Scanner;

/**
 *
 * @author khoi
 */
public class Inkitu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        char kytu;
        for(int i=0;i<s.length();i++){
            kytu=s.charAt(i);
            System.out.println(" "+kytu);
        }
    }
    
}
