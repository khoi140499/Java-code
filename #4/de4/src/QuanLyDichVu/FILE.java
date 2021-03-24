/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyDichVu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Dang Khoi
 */
public class FILE {
    public static void writeFile(ArrayList a, String s){
        ObjectOutput w;
        try {
            w=new ObjectOutputStream(new FileOutputStream(s));
            for(Object aa:a)
                w.writeObject(aa);
            w.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void readFile(ArrayList a, String s){
        ObjectInputStream w;
        try {
            w=new ObjectInputStream(new FileInputStream(s));
                    Object b=null;
                    try {
                while((b=w.readObject())!=null){
                    Object c=(Object)b;
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
