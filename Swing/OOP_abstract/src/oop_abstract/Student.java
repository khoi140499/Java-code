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
public class Student extends Person{
    private int khoi;
    public Student(String ten, int tuoi, String quequan, int khoi){
        super(ten, tuoi, quequan);
        this.khoi=khoi;
    }
    @Override
    void noiLamViec() {
        System.out.println("truong hoc");
    }

    @Override
    public String toString() {
        return super.toString()+" - "+this.khoi;
    }
    
}
