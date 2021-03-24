package bai8_tuluyen;

import java.util.Scanner;

public class Cd {
    private int maCd;
    private String tuaCd;
    private String caSi;
    private int soBaiHat;
    private long giaBan;
    public Cd() {
    }
    public Cd(int maCd, String tuaCd, String caSi, int soBaiHat, long giaBan) {
        this.maCd = maCd;
        this.tuaCd = tuaCd;
        this.caSi = caSi;
        this.soBaiHat = soBaiHat;
        this.giaBan = giaBan;
    }
    public int getMaCd() {
        return maCd;
    }
    public void setMaCd(int maCd) {
        this.maCd = maCd;
    }
    public String getTuaCd() {
        return tuaCd;
    }
    public void setTuaCd(String tuaCd) {
        this.tuaCd = tuaCd;
    }
    public String getCaSi() {
        return caSi;
    }
    public void setCaSi(String caSi) {
        this.caSi = caSi;
    }
    public int getSoBaiHat() {
        return soBaiHat;
    }
    public void setSoBaiHat(int soBaiHat) {
        this.soBaiHat = soBaiHat;
    }
    public long getGiaBan() {
        return giaBan;
    }
    public void setGiaBan(long giaBan) {
        this.giaBan = giaBan;
    }
    public void nhap(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap tua CD: ");
        tuaCd=sc.nextLine();
        System.out.println("Nhap ten ca si: ");
        caSi=sc.nextLine();
        System.out.println("Nhap so bai hat: ");
        soBaiHat=sc.nextInt();
        System.out.println("Nhap gia ban: ");
        giaBan=sc.nextLong();
    }
    public String toString(){
        return this.maCd+" "+this.tuaCd+" "+this.caSi+" "+this.soBaiHat+" "+this.giaBan;
    }
}
