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
public abstract class Person {
    private String ten;
    private int tuoi;
    private String quequan;

    public Person() {
        super();
    }

    public Person(String ten, int tuoi, String quequan) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.quequan = quequan;
    }
    abstract void noiLamViec();
    @Override
    public String toString() {
        return this.ten+" - "+this.tuoi+" - "+this.quequan;
    }
    
}
