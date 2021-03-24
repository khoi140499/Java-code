package bai15;
public class Bai15 {
    public static void main(String[] args) {
        System.out.println("a. so thuan nghich");
        for(int i=100000;i<=999999999;i++){
            if(stn(i))
                     System.out.println(" "+i);
        }
        System.out.println("c. so co tong cac chu so chia het cho 10: ");
        for(int j=1000000;j<=999999999;j++){
            if(scn(j))
                System.out.println(" "+j);
        }
        System.out.println("b. so chi chua 0,6,8: ");
        for(int k=1000000;k<=999999999;k++){
            if(sbn(k))
                System.out.println(" "+k);
        }
    }       
    public static boolean stn(int i){
        int tg=i;
        int tmp=0;
        while(i>0){
            tmp=tmp*10+i%10;
            i/=10;
        }
        return tmp == tg;
    }
    public static boolean scn(int i){
        int tg=i;
        int tong=0;
        while(i>0){
            tong=tong+(i%10);
            i/=10;
        }
        return tong%10 == 0;
    }
    public static boolean sbn(int i){
        int tg = 0;
        while(i>0){
            tg=i%10;
            i/=10;
        }
        if(tg!=0 && tg!=6 && tg!=8) return false;
        return true;
       
    }
}
