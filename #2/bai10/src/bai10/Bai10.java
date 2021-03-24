package bai10;

import java.util.ArrayList;
import java.util.Scanner;

public class Bai10 {
    public static void main(String[] args) {
       // ArrayList<MyPoint> sv=new ArrayList<>();
        MyPoint mp=new MyPoint();
        MyPoint mp1=new MyPoint(1, 3);
        MyPoint mp2=new MyPoint(2, 4);
        MyPoint mp3=new MyPoint(4, 2);  
            System.out.println("Khoang cach giua 2 diem : "+mp.distance(mp2, mp1));
            System.out.println("Khoang cach giua 2 diem : "+mp.distance(mp3, mp1));
            System.out.println("Khoang cach giua 2 diem : "+mp.distance(mp2, mp3));
          //  System.out.println("Khoang cach giua 2 diem : "+mp.distance(mp2, mp3));
    }
    
}
