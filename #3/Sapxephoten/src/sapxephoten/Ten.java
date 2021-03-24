package sapxephoten;

import java.util.Scanner;

public class Ten {
    private int age;
    private String ten;

    public Ten() {
    }
    public Ten(int age, String ten) {
        this.age = age;
        this.ten = ten;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public void nhap(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap ten: ");
        ten=sc.nextLine();
        System.out.println("Nhap tuoi: ");
        age=sc.nextInt(); 
    }
    public String toString(){
        return this.age+" "+this.ten;
    }
}
