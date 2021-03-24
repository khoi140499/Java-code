package bai3_tulluyen;
public class Bai3_tulluyen {
    public static void main(String[] args) {
        Xe x1=new Xe("Nguyen Thu Loan", "Future Neo", 100, 35000000);
        Xe x2=new Xe("Le Minh Tich", "Ford Ranger", 3000, 250000000);
        Xe x3=new Xe("Nguyen Minh Triet", "Landscape", 1500, 1000000000);
        System.out.println("Ten chu xe"+"\t"+"Loai xe"+"\t"+"Dung tich"+"\t"+"Tri gia"+"\t"+"Thue");
        System.out.println("------------------------------------------------------------------------------");
            System.out.println(x1.toString());
            System.out.println(x2.toString());
            System.out.println(x3.toString());
    }
    
}
