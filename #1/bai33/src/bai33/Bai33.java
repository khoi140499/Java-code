package bai33;

import java.util.Scanner;

public class Bai33 {
    public static void main(String[] args) {
        int[] a=new int[1000];
        int i;
        Scanner sc=new Scanner(System.in);
        System.out.println("Mời bạn nhập số la mã:(chỉ nhập I,X,V,L,C,D,M)");
        String s=sc.next();
        for(i=0;i<s.length();i++){
            if(s.charAt(i)=='I') a[i]=1;
            if(s.charAt(i)=='X') a[i]=5;
            if(s.charAt(i)=='V') a[i]=10;
            if(s.charAt(i)=='L') a[i]=50;
            if(s.charAt(i)=='C') a[i]=100;
            if(s.charAt(i)=='D') a[i]=500;
            if(s.charAt(i)=='M') a[i]=1000;
            else if(s.charAt(i)!='I' && s.charAt(i)!='V' &&
                    s.charAt(i)!='X' && s.charAt(i)!='L' &&
                    s.charAt(i)!='C' && s.charAt(i)!='D' &&
                    s.charAt(i)!='M'){
                System.out.println("Không hợp lệ!!");
                break;
            }
        }
        int k=a[s.length()-1];
        for(i=s.length()-1;i>0;i--){
            if(a[i]>a[i-1]){
                k=k-a[i-1];
            }
            else if(a[i]==a[i-1]||a[i]<a[i-1]){
                k=k+a[i-1];
               }
        }
        System.out.println("Giá trị tương ứng: "+k);
    }
    
}
