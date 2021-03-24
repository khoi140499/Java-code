package bai13;

import java.util.Scanner;

public class khoitao {
    private int ts;
    private int ms;
    public khoitao() {
        this.ts=0;
        this.ms=1;
    }
    public khoitao(int ts, int ms) {
        this.ts = ts;
        this.ms = ms;
    }
    public int getTs() {
        return ts;
    }
    public void setTs(int ts) {
        this.ts = ts;
    }
    public int getMs() {
        return ms;
    }
    public void setMs(int ms) {
        this.ms = ms;
    }
    public int ucln(int a, int b){
        if (a == 0 || b == 0){
        return a + b;
    }
    while (a != b){
        if (a > b){
            a -= b;
        }else{
            b -= a;
        }
    }
    return a;
    }
    public void toigianps(){
        int i=ucln(this.getTs(), this.getMs());
        this.setTs(this.getTs()/i);
        this.setMs(this.getMs()/i);
    }
    public void cong(khoitao ps){
        int tuso;
        int mauso;
        tuso=(this.getTs() * ps.getMs()) + (ps.getTs() * this.getMs());
        mauso=this.getMs() * ps.getMs();
        khoitao phansocong=new khoitao(tuso, mauso);
        phansocong.toigianps();
        System.out.println("Tong 2 phan so: "+phansocong.ts+"/"+phansocong.ms);
    }
    public void tru(khoitao ps){
        int tuso;
        int mauso;
        tuso=(this.getTs() * ps.getMs()) - (ps.getTs() * this.getMs());
        mauso=this.getMs() * ps.getMs();
        khoitao phansotru=new khoitao(tuso, mauso);
        phansotru.toigianps();
        System.out.println("Tru 2 phan so: "+phansotru.ts+"/"+phansotru.ms);
    }
    public void nhan(khoitao ps){
        int tuso;
        int mauso;
        tuso=this.getTs()*ps.ts;
        mauso=this.getMs()*ps.ms;
        khoitao phansonhan=new khoitao(tuso, mauso);
        phansonhan.toigianps();
        System.out.println("Nhan 2 phan so: "+phansonhan.ts+"/"+phansonhan.ms);
    }
    public void chia(khoitao ps){
        int tuso;
        int mauso;
        tuso=this.getTs() * ps.ms;
        mauso=this.getMs() * ps.ts;
        khoitao phansochia=new khoitao(tuso, mauso);
        phansochia.toigianps();
        System.out.println("Chia 2 phan so: "+phansochia.ts+"/"+phansochia.ms);
    }
    public boolean bang(khoitao ps){
        double a1=ps.getMs()/this.getMs();
        double a2=this.getTs()*a1;
        if(a2!=ps.getTs()) return false;
        return true;
    }
    public boolean lonhon(khoitao ps){
        double a1=ps.getMs()/this.getMs();
        double a2=this.getTs()*a1;
        if(a2<ps.getTs()) return false;
        return true;
    }
    public boolean nhohon(khoitao ps){
        double a1=ps.getMs()/this.getMs();
        double a2=this.getTs()*a1;
        if(a2>ps.getTs()) return false;
        return true;
    }
    public khoitao doidau(){
        int tuso;
        int mauso;
        tuso=this.getTs()*(-1);
        mauso=this.getMs();
        khoitao ps=new khoitao(tuso, mauso);
        return ps;
    }
    public khoitao nghichdao(){
        int tuso;
        int mauso;
        int tg=this.ts;
        tuso=this.ms;
        mauso=tg;
        khoitao ps=new khoitao(tuso, mauso);
        return ps;
    }                            
    public void nhap(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap tu so: ");
        ts=sc.nextInt();
        System.out.println("Nhap mau so: ");
        ms=sc.nextInt();
    }
    public void xuat(){
        System.out.println("Phan so: "+this.getTs()+"/"+this.getMs());
    }
    public String toString(){
        return this.ts+"/"+this.ms;
    }
}
