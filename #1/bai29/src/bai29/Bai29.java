
package bai29;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Bai29 {

    public static void main(String[] args) {
        SecureRandom sc=new SecureRandom();
        BigInteger mul=new BigInteger(10000, sc);
        BigInteger a=new BigInteger(10000, sc);
        BigInteger b=new BigInteger(10000, sc);
        mul = a.multiply(b);
        System.out.println(a);
        System.out.println(b);
        System.out.println(mul);
    }
    
}
