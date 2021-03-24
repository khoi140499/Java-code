package vd;
public class Vd1 {
    private String ten;
    private String id;
    private String location;
    public Vd1() {
    }
    public Vd1(String ten, String id, String location) {
        this.ten = ten;
        this.id = id;
        this.location = location;
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
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String toString(){
        return this.ten+" "+this.id+" "+this.location;
    }
}
