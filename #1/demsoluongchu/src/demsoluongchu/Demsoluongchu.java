/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demsoluongchu;

import java.util.Scanner;

/**
 *
 * @author khoi
 */
public class Demsoluongchu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Mời bạn nhập vào chuỗi: ");
        String s=sc.nextLine();
        System.out.println("Nhập chữ cần tìm: ");
        char s1=sc.next().charAt(0);
        
        int dem=0;
        boolean flag=true;
        if(s.length()>80) System.out.println("Khong hop le!");
        else{
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=s1){
                flag=false;
            }
            else {
                flag=true;
                dem++;
            }
            }
         System.out.println("Số lượng chữ: "+s1+" : "+dem);
     }
    }
}
