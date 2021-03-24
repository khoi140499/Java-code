
package sohoanthien;

import java.util.Scanner;

public class Sohoanthien {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        double tong=0;
        for(int i=1;i<n;i++){
            if(n%i==0){
                tong+=i;
                System.out.print(" "+i);
            }
        }
        System.out.println();
        if(tong==n) System.out.println("Yes");
        else 
            System.out.println("No");
    }
    
}
