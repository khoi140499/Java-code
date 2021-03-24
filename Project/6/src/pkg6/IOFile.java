/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Dang Khoi
 */
public class IOFile {
    public static void write(ArrayList a, String s){
        ObjectOutputStream o;
        try {
            o=new ObjectOutputStream(new FileOutputStream(s));
            for(Object as:a)
                o.writeObject(as);
            o.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void read(ArrayList a, String s){
        ObjectInputStream o;
        try {
            o=new ObjectInputStream(new FileInputStream(s));
            Object b=null;
            try {
                while((b=o.readObject())!=null){
                    Object c=(Object)b;
                    a.add(c);
                }
                o.close();
            } catch (ClassNotFoundException e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
