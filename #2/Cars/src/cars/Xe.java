package cars;
public class Xe {
    private double trongluong;
    private double giathanh;
    private String nhanhieu;
    private String mauxe;

    public Xe() {
        
    }
    public Xe(double trongluong, double giathanh, String nhanhieu, String mauxe) {
        this.trongluong = trongluong;
        this.giathanh = giathanh;
        this.nhanhieu = nhanhieu;
        this.mauxe = mauxe;
    }

    public double getTrongluong() {
        return trongluong;
    }

    public void setTrongluong(double trongluong) {
        this.trongluong = trongluong;
    }

    public double getGiathanh() {
        return giathanh;
    }

    public void setGiathanh(double giathanh) {
        this.giathanh = giathanh;
    }

    public String getNhanhieu() {
        return nhanhieu;
    }

    public void setNhanhieu(String nhanhieu) {
        this.nhanhieu = nhanhieu;
    }

    public String getMauxe() {
        return mauxe;
    }

    public void setMauxe(String mauxe) {
        this.mauxe = mauxe;
    }
    public void khoidongxe(String mauxe){
        System.out.println("Khoi dong xe");
    }
    public void chayxe(String nhanhieu){
        System.out.println("Chay xe");
    }
    public void dungXe(String thoigian){
        System.out.println("Dung xe");
    }
    public void tatMay(int t){
        System.out.println("Tat may");
    }
    public String toString(){
        return this.nhanhieu+" "+this.mauxe+" "+this.giathanh+" "+this.trongluong;
    }
}    
    
