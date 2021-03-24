package trochoidoanchu;

import java.util.Random;
import java.util.Scanner;

public class Trochoidoanchu {

    public static void main(String[] args) {
        while(true){
            choi();
            System.out.println("Chơi nữa không bạn! (C/K) ");
            String ln=new Scanner(System.in).nextLine();
            if(ln.equalsIgnoreCase("k"))
                break;
        }
         System.out.println("Tạm biệt!!!!");
    }
    public static void choi(){
        Random rd= new Random();
        int somay=rd.nextInt(101);
        System.out.println("Máy đã in ra 1 số trong khoảng [0...100]. Mời bạn đoán!");
        int sonnguoi;
        int solandoan=0;
        do{
            System.out.println("Bạn đoán số mấy : ");
            sonnguoi=new Scanner(System.in).nextInt();
            solandoan++;
            System.out.println("Bạn đoán lần thứ "+solandoan);
            if(sonnguoi==somay) {
                System.out.println("Chúc mừng bạn đã đoán đúng!");
                break;
            }
            if(sonnguoi<somay){
                System.out.println("Bạn đã đoán sai! số máy lớn hơn số bạn đoán.");
            }
            else {
                System.out.println("Bạn đã đoán sai! số máy nhỏ hơn số bạn đoán. ");
            }
            if(solandoan==7){
                System.out.println("Bạn đã cáo phó, vì đã đoán 7 lần không đúng!");
                break;
            }
        }
        while(solandoan<=7);
      }  
}
