package bai1_tuluyen;
public class HinhChuNhat {
    private double dai;
    private double rong;

    public HinhChuNhat() {
    }

    public HinhChuNhat(double dai, double rong) {
        this.dai = dai;
        this.rong = rong;
    }

    public double getDai() {
        return dai;
    }

    public void setDai(double dai) {
        this.dai = dai;
    }

    public double getRong() {
        return rong;
    }

    public void setRong(double rong) {
        this.rong = rong;
    }
    public double chuvi(){
        return this.getDai()+this.getRong();
    }
    public double dientich(){
        return this.getDai()*this.getRong();
    }
    public String toString(){
        return this.dai+" "+this.rong+" "+chuvi()+" "+dientich();
    }
}
