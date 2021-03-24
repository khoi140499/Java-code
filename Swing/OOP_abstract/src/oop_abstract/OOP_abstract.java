/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_abstract;

/**
 *
 * @author Dang Khoi
 */
public class OOP_abstract {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Person a=new Student("Hoang Dang Khoi", 21, "Bac Giang", 16);
        a.noiLamViec();
        System.out.println(a.toString());
    }
    
}
