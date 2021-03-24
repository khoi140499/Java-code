package de4_baithuchanh2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

public class MonHoc {
    private int maMon;
    private int soTinchi;
    private String tenMon;
    private String nhomMon;
    public MonHoc() {
    }
    public MonHoc(int maMon, String tenMon, String nhomMon, int soTinchi) {
        this.maMon = maMon;
        this.soTinchi = soTinchi;
        this.tenMon = tenMon;
        this.nhomMon = nhomMon;
    }
    public int getMaMon() {
        return maMon;
    }
    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }
    public int getSoTinchi() {
        return soTinchi;
    }
    public void setSoTinchi(int soTinchi) {
        this.soTinchi = soTinchi;
    }
    public String getTenMon() {
        return tenMon;
    }
    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }
    public String getNhomMon() {
        return nhomMon;
    }
    public void setNhomMon(String nhomMon) {
        this.nhomMon = nhomMon;
    }
    public String toString(){
        return this.maMon+" "+this.tenMon+" "+this.nhomMon+" "+this.soTinchi;
    }
}
