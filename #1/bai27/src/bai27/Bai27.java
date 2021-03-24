
package bai27;

public class Bai27 {

    public static void main(String[] args) {
        ktra();
    }
    public static boolean stn(String s){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)) return false;
        }
        return true;
    }
    public static void ktra(){
        int coun=0;
        for(int i=100000;i<=999999;i++){
            String s="";
            s+=i;
            if(stn(s)){
                System.out.println(i);
            }    
        }
    }
    
}
