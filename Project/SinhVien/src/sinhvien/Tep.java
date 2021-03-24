package sinhvien;
import java.io.*;
import java.util.*;
public class Tep {
    public static boolean luuFile(ArrayList<Sv>list, String path){
        try{
            FileOutputStream op=new FileOutputStream(path);
            ObjectOutputStream oop=new ObjectOutputStream(op);
            oop.writeObject(list);
            oop.close();
            op.close();
            return true;        
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static ArrayList<Sv>Tep(String path) throws IOException{
        ArrayList<Sv> list=new ArrayList<>();
        try{
            FileInputStream fs=new FileInputStream(path);
            ObjectInputStream os=new ObjectInputStream(fs);
            Object data=os.readObject();
            list=(ArrayList<Sv>) data;
            os.close();
            fs.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
