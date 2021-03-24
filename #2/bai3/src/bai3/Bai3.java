package bai3;
public class Bai3 {
    public static void main(String[] args) {
       Retangle rd=new Retangle(15, 10, "Red");
        System.out.println("Chiều rộng: "+rd.getWidth());
        System.out.println("Chiều dài: "+rd.getHeight());
        System.out.println("Màu: "+rd.getColor());
        System.out.println("Diện tích: "+rd.fineArea());
        System.out.println("Chu vi: "+rd.findPerimeter());
    }
    
}
