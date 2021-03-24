package thuvienmath;

import java.util.Scanner;

public class Thuvienmath {

    public static void main(String[] args) {
        System.out.println("Pi= "+Math.PI);
        int snn=Math.min(100,10);
        System.out.println("min= "+snn);
        int sln=Math.max(12, 199);
        System.out.println("max= "+sln);
        System.out.println("can bac 2: "+Math.sqrt(25));
        System.out.println("Luy thua: "+Math.pow(2, 10));
        System.out.println("Nhap vao 1 goc: ");
        int goc=new Scanner(System.in).nextInt();
        double radian=Math.PI*goc/180;
        double sin=Math.sin(radian);
        double cos=Math.cos(radian);
        double tan=Math.tan(radian);
        System.out.println("Sin: "+sin);
        System.out.println("Cos: "+cos);
        System.out.println("Tan: "+tan);
    }
    
}
