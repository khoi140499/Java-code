/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication10;

import java.util.Scanner;

/**
 *
 * @author Dang Khoi
 */
public class JavaApplication10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s=(new Scanner(System.in)).nextLine();
        String[] arr=s.split("");
        String sa=arr[0];
        String ss=arr[1]+arr[2];
        String ss1=arr[3]+arr[4];
        String a1=arr[5]+arr[6];
        String a2=arr[7]+arr[8];
        String a3=arr[9]+arr[10];
        if(sa.equalsIgnoreCase("d")==false |
                Integer.parseInt(ss)<0 && ss.length()!=2 |
                ss1.equalsIgnoreCase("cq")==false
               | a1.equalsIgnoreCase("at")==false &&
                a1.equalsIgnoreCase("vt")==false && 
                a1.equalsIgnoreCase("cn")==false
                && a1.equalsIgnoreCase("dt")==false && 
                a1.equalsIgnoreCase("pt")==false && 
                a1.equalsIgnoreCase("mr")==false
                && a1.equalsIgnoreCase("tt")==false 
                && a1.equalsIgnoreCase("qt")==false| 
                Integer.parseInt(a2)<0 && ss.length()!=2 
                | a3.equalsIgnoreCase("-b")==false &&
                a3.equalsIgnoreCase("-n")==false 
                | s.length()!=11){
            System.out.println("k thoa man");
        }
        System.out.println(s);;
    }
    }
