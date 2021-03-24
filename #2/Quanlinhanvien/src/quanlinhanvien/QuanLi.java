package quanlinhanvien;

import java.util.Scanner;

public class QuanLi {
    private String ten;
    private String sdt;

    public QuanLi() {
    }

    public QuanLi(String ten, String sdt) {
        this.ten = ten;
        this.sdt = sdt;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    public String toString(){
        return this.ten+" "+this.sdt;
    }
    public void nhap(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap ten nhan vien: ");
        ten=sc.nextLine();
        System.out.println("Nhap so dien thoai: ");
        sdt=sc.nextLine();    }
}
