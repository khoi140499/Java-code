package toiuuchuoi;

import java.util.Scanner;

public class Toiuuchuoi {
    public static String toiuuchuoi(String s){
        String stoiuu=s;
        stoiuu=stoiuu.trim();
        String []arrWord=stoiuu.split(" ");
        stoiuu="";
        for(String word : arrWord){
            String newWord=word.toLowerCase();
            if(newWord.length()>0){
                newWord=newWord.replaceFirst(newWord.charAt(0)+"", (newWord.charAt(0)+"").toUpperCase());
                stoiuu+=newWord+" ";
            }
        }
        return stoiuu.trim();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String stoiuu=toiuuchuoi(s);
        System.out.println(stoiuu);
    }
    
}
