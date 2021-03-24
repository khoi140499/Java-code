/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.SinhVien;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Khoi
 */
public class ServerImp extends UnicastRemoteObject implements RMI{
    private int port=1234;
    private Registry re;
    private String services="rmi";
    private Connection conn=null;
    public ServerImp() throws RemoteException{
        try {
            Connect();
            re=LocateRegistry.createRegistry(port);
            re.rebind(services, this);
        } catch (Exception e) {
        }
    }
    private void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql="jdbc:mysql://localhost/diemsv";
            String user="root";
            String pass="";
            conn=DriverManager.getConnection(sql, user, pass);
        } catch (Exception e) {
        }
    }
    @Override
    public ArrayList<SinhVien> timKiem(SinhVien a) throws RemoteException {
        ArrayList<SinhVien> sv=new ArrayList<SinhVien>();
        try {
            String sql="select * from sinhvien where ten=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, a.getTen());
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                sv.add(new SinhVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
            }
        } catch (Exception e) {
        }
        return sv;
    }

    @Override
    public String updat(SinhVien a) throws RemoteException {
       try {
            String sql="update sinhvien set ten=?, ngaysinh=?, khoa=?, quequan=? where masv=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, a.getTen());
            ps.setString(2, a.getNgaySinh());
            ps.setInt(3, a.getKhoa());
            ps.setString(4, a.getQueQuan());
            ps.setInt(5, a.getMa());
            int rs=ps.executeUpdate();
            if(rs==0){
                return "that bai";
            }
        } catch (Exception e) {
        }
       return "thanh cong";
    }
    
}
