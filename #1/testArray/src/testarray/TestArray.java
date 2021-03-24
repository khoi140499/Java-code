package testarray;
import java.util.ArrayList;
import java.util.Date;
public class TestArray {
    public static void main(String[] args) {
        ArrayList ds=new ArrayList();
        ds.add("1");
        ds.add(new Date("10/04/2014"));
        ds.add("5.5");
        ArrayList<Integer>ds2=new ArrayList();
        ArrayList<Double>ds3=new ArrayList();
        ArrayList<Boolean>ds4=new ArrayList();
        ArrayList<String>ds5=new ArrayList();
        ds5.add("Hoang");
        ds5.add("Dang");
        ds5.add("Khoi");
        for(int i=0;i<ds5.size();i++){
            System.out.println(ds5.get(i));
        }
        ds5.add(2,"Hi");
        for(int i=0;i<ds5.size();i++){
            System.out.println(ds5.get(i));
        }
        ds5.remove(3);
        for(int i=0;i<ds5.size();i++){
            System.out.println(ds5.get(i));
        }
        ds5.set(2, "Hoi");
        for(int i=0;i<ds5.size();i++){
            System.out.println(ds5.get(i));
        }
    }
    
}
