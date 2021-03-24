
package bai10;

import java.util.Scanner;

/**
 *
 * @author khoi
 */
public class Bai10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int dem=0;
        int i = 2;
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        while(dem < n){
            if(snt(i)==true){
                System.out.println(" "+i);
                dem++;
            }
            i++;
        }
    }
    public static boolean snt(int n){
        if(n<2) return false;
        else if(n>2){
            if(n%2==0) return false;
            for(int i=3;i<=Math.sqrt((float)n);i+=2){
                if(n%i==0) return false;
             }
        }
        return true;
    }
    
}
