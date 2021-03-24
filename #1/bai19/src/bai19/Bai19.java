package bai19;

import java.util.*;
import java.util.Random;
import java.util.Scanner;

public class Bai19 {
    public static boolean ktra(int m[], int i){
         int t=m[i]; 
        for (int j=0;j<i;j++) 
         if (t==m[j])return false; 
        return true; 
    }
    public static int solanxuathien(int m[], int i){
        int t=m[i],dem=0; 
        int max=0;
        for (;i<500;i++) 
            { 
        if (t==m[i]) dem++; 
         }
        return (dem); 
    }
    public static void main(String[] args) {
        int dem;
        Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        Random rd=new Random();
        int m[]=new int[500];
        int res[]=new int[500];
        for(int i=0;i<m.length;i++){
            m[i]=100+rd.nextInt(900);
            res[i]=-1;
            }
        for(int i=0;i<m.length;i++){
            System.out.print(m[i]+"  ");
        }
        for(int i=0;i<500;i++){
            dem=1;
            for(int j=i+1;j<500;j++){
               if(res[j]!=0 && m[i]==m[j]){
                   dem++;
                   res[j]=0;
               } 
            }
            if(res[i] != 0) {
                res[i] = dem;
            }
        }
        int max = res[0];
        for(int i=0;i<500;i++){
            if(res[i] > max){
                max = res[i];
            }
        }
         System.out.println();
        for(int i=0;i<m.length;i++){
            if(ktra(m,i)){
                System.out.println(m[i]+" xuất hiện "+solanxuathien(m,i));
            }
        }
        System.out.println();
        System.out.println("Số lần xuất hiện nhiều nhất : "+max+" - số phần tử:");
        for(int i=0;i<500;i++){
            if(res[i]==max){
                System.out.println("Phần tử "+m[i]);
            }
        }
    } 
}