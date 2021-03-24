package bai7_tuluyen;

import java.util.Scanner;

public class SinhVien {
   private int maSv;
   private String ten;
   private String diaChi;
   private long std;
    public SinhVien() {
    }
    public SinhVien(int maSv, String ten, String diaChi, long std) {
        this.maSv = maSv;
        this.ten = ten;
        this.diaChi = diaChi;
        this.std = std;
    }
    public int getMaSv() {
        return maSv;
    }
    public void setMaSv(int maSv) {
        this.maSv = maSv;
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public long getStd() {
        return std;
    }
    public void setStd(long std) {
        this.std = std;
    }
    public void nhap(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap ten: ");
        ten=sc.nextLine();
        System.out.println("Nhap dia chi: ");
        diaChi=sc.nextLine();
        System.out.println("Nhap sdt: ");
        std=sc.nextLong();
        System.out.println("Nhao ma sinh vien: ");
        maSv=sc.nextInt();
    }
    public String toString(){
        return this.maSv+" "+this.ten+" "+this.diaChi+" "+this.std;
    }
}
