
package demkhoangtrang;

import java.util.Scanner;

public class Demkhoangtrang {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int dem=0;
        boolean flag=true;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                flag=false;
            }
            else{
                flag=true;
                dem++;
            }
        }
        System.out.println(dem);
    }
    
}
