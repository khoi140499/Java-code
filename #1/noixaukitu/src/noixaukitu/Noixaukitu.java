/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noixaukitu;

import java.util.Scanner;

/**
 *
 * @author khoi
 */
public class Noixaukitu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Mời bạn nhập 2 chuỗi: ");
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        StringBuilder sb =new StringBuilder();
        sb.append(s1);
        sb.append(" ");
        sb.append(s2);
        System.out.println(sb);
    }
    
}
