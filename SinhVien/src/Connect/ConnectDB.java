/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connect;

import Model.SinhVien;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Khoi
 */
public class ConnectDB {
    Connection conn=null;

    public ConnectDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String sql="jdbc:mysql://localhost/diemsv";
        String user="root";
        String pass="";
        conn=DriverManager.getConnection(sql, user, pass);
    }
    
    public ArrayList<SinhVien> TimKiem(String s){
        ArrayList<SinhVien> sv=new ArrayList<>();
        try {
            String sql1="select * from sinhvien where ten=?";
            PreparedStatement ps=conn.prepareStatement(sql1);
            ps.setString(1, s);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                sv.add(new SinhVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return sv;
    }
    
    public String UpdateSV(SinhVien a){
        try {
            String sql="update sinhvien set ten=?, ngaysinh=?, khoa=?, quequan=? where masv=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, a.getTen());
            ps.setString(2, a.getNgaysinh());
            ps.setInt(3, a.getKhoa());
            ps.setString(4, a.getQuequan());
            ps.setInt(5, a.getMa());
            int r=ps.executeUpdate();
            if(r==0){
                return "nopass";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "pass";
    }
}
