package bai5_tuluuyen;
public class PhanSo {
    private int tuSo;
    private int mauSo;
    public PhanSo() {
    }
    public PhanSo(int tuSo, int mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }
    public int getTuSo() {
        return tuSo;
    }
    public void setTuSo(int tuSo) {
        this.tuSo = tuSo;
    }
    public int getMauSo() {
        return mauSo;
    }
    public void setMauSo(int mauSo) {
        this.mauSo = mauSo;
    }
    private int UCLN(int a, int b){
        int tmp;
        while(b != 0) {
        tmp = a % b;
        a = b;
        b = tmp;
    }
    return a;
    }
    public void toiGian(){
        int i=UCLN(tuSo, mauSo);
        this.setTuSo(this.getTuSo()/i);
        this.setMauSo(this.getMauSo()/i);
    }
    public void Add(PhanSo a){
        int c;
        int b;
        b=this.getTuSo()*a.getMauSo()+this.getMauSo()*a.getTuSo();
        c=this.getMauSo()*a.getMauSo();
        PhanSo d=new PhanSo(b, c);
        d.toiGian();
        System.out.println("tong = "+d.getTuSo()+"/"+d.getMauSo());
    }
    public void sub(PhanSo a){
        int c;
        int b;
        b=this.getTuSo()*a.getMauSo()-this.getMauSo()*a.getTuSo();
        c=this.getMauSo()*a.getMauSo();
        PhanSo d=new PhanSo(b, c);
        d.toiGian();
        System.out.println("hieu = "+d.tuSo+"/"+d.mauSo);
    }
    public void multi(PhanSo a){
        int c;
        int b;
        b=this.getTuSo()*a.getTuSo();
        c=this.getMauSo()*a.getMauSo();
        PhanSo d=new PhanSo(b, c);
        d.toiGian();
        System.out.println("tich = "+d.tuSo+"/"+d.mauSo);
    }
    public void div(PhanSo a){
        int c;
        int b;
        b=this.getTuSo()*a.getMauSo();
        c=this.getMauSo()*a.getTuSo();
        PhanSo d=new PhanSo(b, c);
        d.toiGian();
        System.out.println("thuong = "+d.tuSo+"/"+d.mauSo);
    }
    public PhanSo nghichDao(){
        PhanSo b=new PhanSo();
        b.setTuSo(this.getTuSo());
        b.setMauSo(this.getMauSo());
        return b;
    }
    public void soSanh(PhanSo c){
        double a=c.getTuSo()*this.getMauSo()/c.getMauSo();
        if(this.getTuSo()==a){
            System.out.println("Bang nhau");
        }
        else if(this.getTuSo()<a){
            System.out.println("Nho hon");
        }
        else{
            System.out.println("Lon hon");
        }
    }
    public String toString(){
        return this.tuSo+"/"+this.mauSo;
    }
}
