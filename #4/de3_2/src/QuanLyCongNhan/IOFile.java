package QuanLyCongNhan;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class IOFile {
    public static void vietFile(ArrayList a, String s){
        ObjectOutputStream w;
        try {
            w=new ObjectOutputStream(new FileOutputStream(s));
            for(Object as:a)
                w.writeObject(as);
            w.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void docFile(ArrayList a, String s){
        ObjectInputStream w;
        try {
            w=new ObjectInputStream(new FileInputStream(s));
            Object ob=null;
            try {
                while((ob=w.readObject())!=null){
                    Object c=(Object)ob;
                    a.add(c);
                }
                w.close();
            } catch (ClassNotFoundException e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
