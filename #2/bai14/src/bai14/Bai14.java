package bai14;
public class Bai14 {
    public static void main(String[] args) {
        SoPhuc sp1=new SoPhuc();
        SoPhuc sp2=new SoPhuc();
        sp1.nhap();
        sp1.xuat();
        sp2.nhap();
        sp2.xuat();
        sp1.cong(sp2);
        sp1.tru(sp2);
        sp1.nhan(sp2);
        sp1.chia(sp2);
        System.out.println("Nghic dao cua so phuc: "+sp1.nghichdao());
        System.out.println("So phuc "+sp1.getA()+" + "+sp1.getB()+"i"+" bang "+" so phuc "+
                sp2.getA()+" + "+sp2.getB()+"i" + " "+sp1.bangNhau(sp2));
        System.out.println("So phuc "+sp1.getA()+" + "+sp1.getB()+"i"+" lon hon "+" so phuc "+
                sp2.getA()+" + "+sp2.getB()+"i" +" "+ sp1.lonHon(sp2));
        System.out.println("So phuc "+sp1.getA()+" + "+sp1.getB()+"i"+" nho hon "+" so phuc "+
                sp2.getA()+" + "+sp2.getB()+"i" +" "+ sp1.nhoHon(sp2));
        
    }
    
}
