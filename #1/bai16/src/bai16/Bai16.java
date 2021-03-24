
package bai16;

import java.util.Scanner;

public class Bai16 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       for(int l=1000000;l<=9999999;l++){
            if(sntb(l) && snt(l) && sntc(l)) System.out.println(" "+l);
        }
    }
    public static boolean snt(int i){
        if(i<2) return false;
        else if(i>2){
            if(i%2==0) return false;
            for(int j=3;j<=Math.sqrt((float)i);j+=2){
                if(i%j==0) return false;
            }
        }
        return true;
    }
    public static boolean sntb(int i){
        int tg=0;
        while(i>0){
            tg=i%10;
            i/=10;
            if(snt(tg)==false) return false;
        }
        return true;
    }
    public static boolean sntc(int i){
        int tg=0;
        while(i>0){
            tg=tg*10+i%10;
            i/=10;
            if(snt(tg)==true) return true;
        }
        return false;
    }
}
