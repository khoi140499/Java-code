package bai30;

import java.util.Scanner;

public class Bai30 {
    public static String toiuuchuoi(String s){
        String stu=s;
        stu=stu.trim();
        String []arr=stu.split(" ");
        stu="";
        for(String word : arr){
            String nw=word.toLowerCase();
            if(nw.length()>0){
                nw=nw.replaceFirst((nw.charAt(0)+""), (nw.charAt(0)+"").toUpperCase());
                stu+=nw+" ";
            }
        }
        return stu.trim();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String st=toiuuchuoi(s);
        System.out.println(st);
    }
    
}
