/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Khoi
 */
public class DiemMH {
    private int ma;
    private float diemcc;
    private float diemkt;
    private float diembtl;
    private float diemthi;
    private int masv;
    private int mamh;

    public DiemMH() {
    }

    public DiemMH(int ma, float diemcc, float diemkt, float diembtl, float diemthi, int masv, int mamh) {
        this.ma = ma;
        this.diemcc = diemcc;
        this.diemkt = diemkt;
        this.diembtl = diembtl;
        this.diemthi = diemthi;
        this.masv = masv;
        this.mamh = mamh;
    }

    public int getMa() {
        return ma;
    }

    public float getDiemcc() {
        return diemcc;
    }

    public float getDiemkt() {
        return diemkt;
    }

    public float getDiembtl() {
        return diembtl;
    }

    public float getDiemthi() {
        return diemthi;
    }

    public int getMasv() {
        return masv;
    }

    public int getMamh() {
        return mamh;
    }
    
}
