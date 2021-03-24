package chunhat;
public class ChuNhata {
    private double chieudai;
    private double chieurong;

    public ChuNhata() {
    }

    public ChuNhata(double chieudai, double chieurong) {
        this.chieudai = chieudai;
        this.chieurong = chieurong;
    }

    public double getChieudai() {
        return chieudai;
    }

    public void setChieudai(double chieudai) {
        this.chieudai = chieudai;
    }

    public double getChieurong() {
        return chieurong;
    }

    public void setChieurong(double chieurong) {
        this.chieurong = chieurong;
    }
    public double chuvi(){
        return (this.chieudai+this.chieurong)/2;
    }
    public double dientich(){
        return (this.chieudai*this.chieurong);
    }
}
