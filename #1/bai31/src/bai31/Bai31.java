package bai31;

import java.util.Scanner;

public class Bai31 {
    public static String btt(String s){
        String toiuu=s;
        int max=0;
        int i;
        String []arr=s.split(" ");
        toiuu="";
        if(arr.length>0){
            for (i=0;i<arr.length;i++) {
                if (max < arr[i].length()) {
                    max = arr[i].length();
                }
            }
           int count=0;
           for(i=0;i<arr.length;i++){
               if(arr[i].length()==max){
                   System.out.println("Từ dài nhất: "+arr[i]);
                   System.out.println("Vị trí: "+count);
               }
               count+=arr[i].length()+1;
           }
        }
        return toiuu;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        btt(s);
    }
    
}
