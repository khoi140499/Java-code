package bai14;

import java.util.Scanner;

public class SoPhuc {
   private float a;
   private float b;
    public SoPhuc() {
    }
    public SoPhuc(float a, float b) {
        this.a = a;
        this.b = b;
    }
    public float getA() {
        return a;
    }
    public void setA(float a) {
        this.a = a;
    }
    public float getB() {
        return b;
    }
    public void setB(float b) {
        this.b = b;
    }
   public void cong(SoPhuc a){
       float a1;
       float b1;
       a1=this.getA()+a.getA();
       b1=this.getB()+a.getB();
       SoPhuc b=new SoPhuc(a1, b1);
       System.out.println("Cong 2 so phuc: "+b.a+" + "+b.b+"i");
   }
   public void tru(SoPhuc a){
       float a1;
       float b1;
       a1=this.getA()-a.getA();
       b1=this.getB()-a.getB();
       SoPhuc b=new SoPhuc(a1, b1);
       System.out.println("Tru 2 so phuc: "+b.a+" + "+b.b+"i");
   }
   public void nhan(SoPhuc a){
       float a1;
       float b1;
       a1=(this.getA()*a.getA())-(this.getB()*a.getB());
       b1=(this.getA()*a.getB())-(a.getA()*this.getB());
       SoPhuc b=new SoPhuc(a1, b1);
       System.out.println("Nhan 2 so phuc: "+b.a+" + "+b.b+"i");
   }
   public void chia(SoPhuc a){
       float a1;
       float b1;
       a1=((a.getA()*this.getA()+this.getB()*a.getB())/(this.getA()*this.getA()+this.getB()*this.getB()));
       b1=((this.getA()+a.getB())-(a.getA()-this.getB()))/(this.getA()*this.getA()+this.getB()*this.getB());
       SoPhuc b=new SoPhuc(a1, b1);
       System.out.println("Chia 2 so phuc: "+b.a+" + "+b.b+"i");
   }
   public SoPhuc nghichdao(){
       float a1;
       float b1;
       a1=this.getA()/(this.getA()*this.getA()+this.getB()*this.getB());
       b1 = (this.getB()*(-1))/(this.getA()*this.getA()+this.getB()*this.getB());
       SoPhuc b=new SoPhuc(a1, b1);
       return b;
   }
   public boolean bangNhau(SoPhuc a){
       if(this.getA()!=a.getA() && this.getB()!=a.getB()) return false;
       return true;
   }
   public boolean lonHon(SoPhuc a){
       float a1;
       float b1;
       a1=(float)Math.sqrt(this.getA()*this.getA()+this.getB()+this.getB());
       b1=(float)Math.sqrt(a.getA()*a.getA()+a.getB()+a.getB());
       if(a1<b1) return false;
       return true;
   }
   public boolean nhoHon(SoPhuc a){
       float a1;
       float b1;
       a1=(float)Math.sqrt(this.getA()*this.getA()+this.getB()+this.getB());
       b1=(float)Math.sqrt(a.getA()*a.getA()+a.getB()+a.getB());
       if(a1>b1) return false;
       return true;
   }
   public void xuat(){
       System.out.println("So phuc "+this.getA()+" + "+this.getB()+"i");
   }
   public void nhap(){
       Scanner sc=new Scanner(System.in);
       System.out.println("Nhap a: ");
       a=sc.nextFloat();
       System.out.println("Nhap b: ");
       b=sc.nextFloat();
   }
   public String toString(){
       return this.getA()+" + "+this.getB()+"i";
   }
}
