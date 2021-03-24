package bai28;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Bai28 {

    public static void main(String[] args) {
        SecureRandom rd=new SecureRandom();
        BigInteger add=new BigInteger(10000, rd);
        BigInteger sub=new BigInteger(10000, rd);
        BigInteger a=new BigInteger(10000, rd);
        BigInteger b=new BigInteger(10000, rd);
        add=a.add(b);
        sub=a.subtract(b);
        System.out.println(a);
        System.out.println(b);
        System.out.println(add);
        System.out.println(sub);
    }
    
}
