package quan.li.sach;

import java.util.Scanner;

public class QuanLi {
    private String ten;
    private double sosach;
    private double sosachmuon;

    public QuanLi() {
    }

    public QuanLi(String ten, double sosach, double sosachmuon) {
        this.ten = ten;
        this.sosach = sosach;
        this.sosachmuon = sosachmuon;
    }

    public String getTen() {
        return this.ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getSosach() {
        return this.sosach;
    }

    public void setSosach(double sosach) {
        this.sosach = sosach;
    }

    public double getSosachmuon() {
        return this.sosachmuon;
    }

    public void setSosachmuon(double sosachmuon) {
        this.sosachmuon = sosachmuon;
    }
    public void xuat(){
        System.out.println(this.ten);
    }
    public double conlai(){
        return (this.sosach-this.sosachmuon);
    }
    public void nhap(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap ten sach: ");
        this.ten=sc.nextLine();
    }
    public void nhap2(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap so sach cho muon: ");
        this.sosachmuon=sc.nextDouble();
    }
    public void nhap3(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap tong so sach trong thu vien ");
        this.sosach=sc.nextDouble();
    }
    public double  sosachcon(){
        return this.sosach-this.sosachmuon;
    }
    public String toString(){
        return this.ten;
    }
    public void xuat1(){
        System.out.println("Tong so sach co trong thu vien: "+this.sosach);
        System.out.println("So sach da cho muon : "+this.sosachmuon);
        System.out.println("So sach con lai "+conlai());
    }
}
