
package bai12;

public class Bai12 {

    public static void main(String[] args) {
      
        for(int i=100000;i<=999999;i++){
                if(dnn(i))
                System.out.println(" " +i);
            }
        }
    public static boolean dnn(int i){
        int tg=i;
        int tmp=0;
        while(i>0){
            tmp = tmp*10 + i%10;
            i/=10;
        }
        return tmp == tg;
    }
    
}
