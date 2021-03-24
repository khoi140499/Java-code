package tets2;
public class as {
    private int age;
    private String ten;
    private String id;
    public as() {
    }
    public as(int age, String ten, String id) {
        this.age = age;
        this.ten = ten;
        this.id = id;
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
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String toString(){
        return this.age+" "+this.ten+" "+this.id;
    }    
}
