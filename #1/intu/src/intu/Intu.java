package intu;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Intu {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        StringTokenizer st=new StringTokenizer(s," ");
        while(st.hasMoreTokens()){
            String value=st.nextToken();
            System.out.println(value);
        }
    }
    
}
