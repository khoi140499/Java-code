package sapxephoten;
import java.util.*;
import java.io.*;
public class Sapxephoten {
    public static void main(String[] args) {
        ArrayList<Ten> ar=new ArrayList<>();
        Ten t;
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap so sinh vien: ");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            t=new Ten();
            t.nhap();
            ar.add(t);
        }
        Comparator<Ten> com=new Comparator<Ten>(){
            @Override
            public int compare(Ten o1, Ten o2) {
                int a=o1.getTen().compareToIgnoreCase(o2.getTen());
                int b=o1.getTen().length();
                int c=o2.getTen().length();
                if(b>c){
                    for(int i=0;i<b;i++){
                        if(o1.getTen().charAt(i)!=o2.getTen().charAt(i))
                            return a;
                       }
                    }
                else{
                    for(int i=0;i<c;i++){
                        if(o1.getTen().charAt(i)!=o2.getTen().charAt(i))
                            return a;
                      }
                }
                return o1.getTen().compareToIgnoreCase(o2.getTen());
            }
        };
        Collections.sort(ar, com);
        for(Ten a:ar)
            System.out.println(a.toString());
    }
    
}
