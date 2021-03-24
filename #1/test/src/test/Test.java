package test;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        Random rd= new Random();
        int somay;
        somay = rd.nextInt(1000000000);
        System.out.println(somay);
    }
    
}
