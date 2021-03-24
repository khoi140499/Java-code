
package c;

import java.util.ArrayList;
import java.util.Scanner;

public class C {

    private static int i;
    public static void nhap2(String s){
        String []arr=s.split(" ");
        int i=arr.length;
        for(int j=1;j<arr.length;j++){
                System.out.print(arr[j]+" ");
        }
                System.out.print(" , "+arr[0]);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String s=null;
        ArrayList ar=new ArrayList(n);
        for(int i=0;i<n;i++){
            ar.add(s);
            nhap2(s);
        }  
    }
}
