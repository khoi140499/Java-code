package oop_alias;
public class NewClass implements Cloneable{
    private int ma;
    private String ten;
    public void setMa(int ma){
        this.ma=ma;
    }
    public int getMa(){
        return ma;
    }
    public void setTen(String ten){
        this.ten=ten;
    }
    public String getTen(){
        return ten;
    }
    public NewClass(int ma, String ten){
        this.ma=ma;
        this.ten=ten;
    }
    public NewClass copy(){
        try{
            return (NewClass) this.clone();
        } catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return null;
    }
}
