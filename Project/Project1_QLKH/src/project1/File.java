package project1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class File {
    public static boolean luuFile(ArrayList<KhachHang> ds, String path){
        try{
            FileOutputStream op=new FileOutputStream(path);
            ObjectOutputStream oop=new ObjectOutputStream(op);
            oop.writeObject(ds);
            oop.close();
            op.close();
            return true;        
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static ArrayList<KhachHang>docFile(String path){
        ArrayList<KhachHang>ds=new ArrayList<>();
        try{
            FileInputStream fis=new FileInputStream(path);
            ObjectInputStream ois=new ObjectInputStream(fis);
            Object data=ois.readObject();
            ds=(ArrayList<KhachHang>) data;
            ois.close();
            fis.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return ds;
    }
}
