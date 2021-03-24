package file;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Test {
    public static boolean luuFile(ArrayList<String>dsData, String path){
            boolean ok=false;
            try {
                FileOutputStream fos=new FileOutputStream(path);
                OutputStreamWriter osw=new OutputStreamWriter(fos, "UTF-8");
                BufferedWriter bf=new BufferedWriter(osw);
                for(String data:dsData){
                    bf.write(data);
                    bf.newLine();
                }
                fos.close();
                osw.close();
                bf.close();
                ok=true;
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false; 
        }
}
