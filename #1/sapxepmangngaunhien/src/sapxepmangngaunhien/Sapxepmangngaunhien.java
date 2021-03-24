package sapxepmangngaunhien;

import java.util.*;

public class Sapxepmangngaunhien {
    public static void nhap(int M[]){
        Random rd=new Random();
        for(int i=0;i<M.length;i++){
            M[i]=10+rd.nextInt(90);
        }
    }
    public static void xuat(int M[]){
        for(int i=0;i<M.length;i++){
            System.out.print(M[i]+"\t");
        }
    }
    public static void BubbleSort(int M[]){
        int i,j;
        for(i=0;i<M.length-1;i++){
            for(j=M.length-1;j>i;j--){
                if(M[j]<M[j-1]){
                    int temp=M[j];
                    M[j]=M[j-1];
                    M[j-1]=temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập số phần tử của mảng: ");
        int n=sc.nextInt();
        int M[]=new int[n];
        nhap(M);
        System.out.println("Mảng sau khi đã nhập: ");
        xuat(M);
        System.out.println();
        System.out.println("Mảng sau khi đã được sắp xếp: ");
        //BubbleSort(M);//
        Arrays.sort(M);
        xuat(M);
    }
    
}
