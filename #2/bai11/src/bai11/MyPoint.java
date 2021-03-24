package bai11;

import java.util.Scanner;

public class MyPoint {
    private double x;
    private double y;
    public MyPoint() {
    }
    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public MyPoint(MyPoint p){
    
    }
    public double distance(MyPoint p2){
        double kc=0;
        kc=Math.sqrt((double)(p2.getX()-this.getX())*(p2.getX()-this.getX())+
                (p2.getY()-this.getY())*(p2.getY()-this.getY()));
        return kc;
    }
     public double distance(MyPoint p2, MyPoint p1){
        double kc=0;
        kc=Math.sqrt((double)(p2.getX()-p1.getX())*(p2.getX()-p1.getX())+
                (p2.getY()-p1.getY())*(p2.getY()-p1.getY()));
        return kc;
    }
     public void nhap(){
         Scanner sc=new Scanner(System.in);
         System.out.println("Nhap toa do x: ");
         x=sc.nextDouble();
         System.out.println("Nhap toa do y: ");
         y=sc.nextDouble();
     }
}
