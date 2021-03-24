package bai4_tuluyen;

import java.util.Scanner;
public class Account {
    private long stk;
    private String ten;
    private double cost;
    private static double laisuat=0.35;
    public Account() {
    }
    public Account(long stk, String ten, double cost) {
        this.stk = stk;
        this.ten = ten;
        this.cost = cost;
    }
    public long getStk() {
        return stk;
    }
    public void setStk(long stk) {
        this.stk = stk;
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public Account(long stk, String ten){
        this.stk=stk;
        this.ten=ten;
        this.cost=50;
    }
    public void napTien(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap so tien muon nap: ");
        double n=sc.nextDouble();
        if(n<0) System.out.println("So tien nhap phai lon hon 0");
        else{
        this.setCost(this.getCost()+n);
            }
    }
    public void rutTien(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap so tien muon rut: ");
        double n=sc.nextDouble();
        if(n>this.getCost()) System.out.println("Loi. Nhap lai");
        else{
        this.setCost(this.getCost()-n);
        }
    }
    public void daoHan(){
        
        this.setCost(this.getCost()+this.getCost()*laisuat);
    }
    public void chuyenKhoan(Account a){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap so tien can chuyen khoan: ");
        double n=sc.nextDouble();
        if(n>this.getCost()) System.out.println("Loi. Nhap lai");
        else{
            a.setCost(a.getCost()+n);
            this.setCost(this.getCost()-n);
        }
    }
    public String toString(){
        return this.stk+" "+this.ten+" "+this.cost;
    }
}
