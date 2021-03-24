package oop_renluyen;
public class NhanVien {
    private int sp;
    private String ten;

    public NhanVien() {
    }

    public int getMa() {
        return sp;
    }

    public void setSP(int sp) {
        this.sp = sp;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
    public NhanVien(int sp, String ten) {
        this.sp = sp;
        this.ten = ten;
    }
    public double getLuong(int sp){
        double heso;
        if(this.sp<=199) 
            heso=0.5;
        else if(this.sp<=399)
            heso=0.55;
        else if(this.sp<=600)
            heso=0.6;
        else heso=0.65;
        return this.sp*sp;  
    }
    public boolean lonHon(NhanVien nv2){
        return this.sp > nv2.sp;
    }
    public String tString(){
        return this.ten+" "+this.sp;
    }
}