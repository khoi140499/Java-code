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
public class MonHoc {
    private int ma;
    private int stc;
    private String mota;

    public MonHoc() {
    }

    public MonHoc(int ma, int stc, String mota) {
        this.ma = ma;
        this.stc = stc;
        this.mota = mota;
    }

    public int getMa() {
        return ma;
    }

    public int getStc() {
        return stc;
    }

    public String getMota() {
        return mota;
    }
    
}
