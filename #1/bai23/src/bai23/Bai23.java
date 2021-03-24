package bai23;

import java.util.Scanner;

public class Bai23 {
    public static void main(String[] args) {
        nhap();
    }
    public static void nhap(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập số phần tử của mảng: ");
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<a.length;i++){
            System.out.print("a["+i+"] : ");
            a[i]=sc.nextInt();
        }
        duongchay(a);
    }
    public static void display(int[] a, int[] b){
        int max=0;
        for(int x : b) if(x>max) max=x;
        System.out.print("mang m[]: ");
        for(int x : a) System.out.print(x+" ");
        System.out.println();
        int vt=0;
        for(int x : b){
            if(x==max) System.out.println("vi tri :"+vt+" , do dai "+max);
            vt+=x;
        }
    }
    public static void duongchay(int[] a){
        int index=0;
        int[] b=new int[a.length];
        for(int i=0;i<a.length-1;i++)
            if(a[i+1]<a[i]){
                b[index]++;
                index++;
            }
            else b[index]++;
            display(a,b);
    }
}
 