package bai3_tulluyen;
public class Xe {
   private String ten;
   private String loaixe;
   private int dungtich;
   private float trigia;
    public Xe() {
    }
    public Xe(String ten, String loaixe, int dungtich, float trigia) {
        this.ten = ten;
        this.loaixe = loaixe;
        this.dungtich = dungtich;
        this.trigia = trigia;
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public String getLoaixe() {
        return loaixe;
    }
    public void setLoaixe(String loaixe) {
        this.loaixe = loaixe;
    }
    public int getDungtich() {
        return dungtich;
    }
    public void setDungtich(int dungtich) {
        this.dungtich = dungtich;
    }
    public double getTrigia() {
        return trigia;
    }
    public void setTrigia(float trigia) {
        this.trigia = trigia;
    }
    public float thue(){
        if(this.getDungtich()<100){
            return (float) (this.getTrigia()*0.01);
        }
        else if(this.getDungtich()<=200){
            return (float) (this.trigia*0.03);
        }
        return (float) (this.trigia*0.05);
    }
    public String toString(){
        return this.ten+"       "+this.loaixe+"      "+this.dungtich+"      "+this.trigia+"      "+thue();
    }
}
