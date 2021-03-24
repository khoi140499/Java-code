package bai13;
public class Bai13 {
    public static void main(String[] args) {
        khoitao ps1=new khoitao(2, 3);
        khoitao ps2=new khoitao(1, 3);
        //ps1.toigianps();
        ps1.xuat();
        ps2.toigianps();
        ps2.xuat();
        ps1.cong(ps2);
       // ps1.tru(ps2);
        ps1.nhan(ps2);
        ps1.chia(ps2);
        System.out.println("phan so "+ps1.getTs()+"/"+ps1.getMs()+" bang "
        +ps2.getTs()+"/"+ps2.getMs()+" "+ps1.bang(ps2));
        System.out.println("phan so "+ps1.getTs()+"/"+ps1.getMs()+" lon hon "
        +ps2.getTs()+"/"+ps2.getMs()+" "+ps1.lonhon(ps2));
        System.out.println("phan so "+ps1.getTs()+"/"+ps1.getMs()+" nho hon "
        +ps2.getTs()+"/"+ps2.getMs()+" "+ps1.nhohon(ps2));
        System.out.println("Phan so 1 nghich dao: "+ps1.nghichdao());
        System.out.println("Phan so 2 nghich dao: "+ps2.nghichdao());
        System.out.println("Phan so 1 da duoc doi dau: "+ps1.doidau());
        System.out.println("Phan so 2 da duoc doi dau: "+ps2.doidau());
    }
    
}
