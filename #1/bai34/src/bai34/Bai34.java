package bai34;
import java.util.Arrays;
import java.util.Scanner;
public class Bai34 {
    public static String tachchuoi(String s){
        String tachchuoi=s;
        int dem=0;
        String []arr=tachchuoi.split(" ");
        tachchuoi= "";
            if(arr.length>0){
                Arrays.sort(arr);
            for (String arr1 : arr) {
                dem++;
                if(arr1.length()<=10 && dem<=20) {
                    System.out.println(arr1);
                    }
                else break;
            }
        }
        return tachchuoi;
    }            
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        tachchuoi(s);
        }
}

