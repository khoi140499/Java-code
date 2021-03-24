package vd;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Vd {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
           int a=sc.nextInt();
           int b=sc.nextInt();
           int c;
            try{
                c=a/b;
            }catch(Exception e){
                System.out.println("Loi "+e);
             }
            System.out.println("Sau phep chia");
       }
    }
