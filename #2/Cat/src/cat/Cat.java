package cat;

import java.util.Scanner;

public class Cat {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
     try{
        try{
            int a=sc.nextInt();
            
            System.out.println("Average = "+a);
        }
       catch(Exception ex){
            System.out.println("Ban nhap sai");
        }
        System.out.println("Continue...");
        int a[]=new int[5];
        a[10]=4;
         System.out.println("a[5]= "+a[4]);
     }catch(ArrayIndexOutOfBoundsException ex){
                   System.out.println(ex);
               }
        System.out.println("Finished!!");
    }z
}
