package bai2;

import java.util.Scanner;

public class SinhVien {
   private String ten;
   private String masv;
   private String lop;
   private String khoa;
   public SinhVien(){
       super();
   }
   public SinhVien(String masv,String ten,String lop,String khoa){
       super();
       this.ten=ten;
       this.masv=masv;
       this.lop=lop;
       this.khoa=khoa;
   }
   public void setTen(String ten){
       this.ten=ten;
   }
   public String getTen(){
       return this.ten;
   }
   public void setMasv(String masv){
       this.masv=masv;
   }
   public String getMasv(){
       return this.masv;
   }
   public void setLop(String lop){
       this.lop=lop;
   }
   public String getLop(){
       return this.lop;
   }
   public void setKhoa(String khoa){
       this.khoa=khoa;
   }
   public String getKhoa(){
       return this.khoa;
   }
   public String toString(){
       return this.masv+" "+this.ten+" "+this.lop+" "+this.khoa;
   }
}
