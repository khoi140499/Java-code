package bai21;

import java.util.Arrays;
import java.util.Random;

public class Bai21 {
    public static void nhap(int m[]){
        Random rd=new Random();
        for(int i=0;i<m.length;i++){
            m[i]=100+rd.nextInt(900);
        }
    }
    public static void xuat(int m[]){
        for(int i=0;i<m.length;i++){
            System.out.print(m[i]+"\t");
        }
    }
    public static boolean kt(int m[], int i){
        int t=m[i];
        for(int j=0;j<i;j++){
            if(t==m[j]) return false;
        }
        return true;
    }
    public static void main(String[] args) {
    int[] m=new int[500];
    nhap(m);
    xuat(m);
        System.out.println();
        System.out.println("Mảng sau khi sắp xếp là: ");
    for(int i=0;i<m.length;i++){
        if(kt(m,i)==true){
            Arrays.sort(m);
            System.out.print(m[i]+"\t");
            }
         }
    }
    
}
