/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadClass;

import Model.Message;
import Model.SinhVien;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Khoi
 */
public class ServerImp extends Thread{
    Socket socket;
    ObjectInputStream ois=null;
    ObjectOutputStream oos=null;
    Connection conn=null;

    public ServerImp(Socket socket) throws IOException {
        this.socket = socket;
        oos=new ObjectOutputStream(socket.getOutputStream());
        ois=new ObjectInputStream(socket.getInputStream());
        Connect();
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
    
    void inRe(Message msg) throws IOException{
        switch(msg.getType()){
            case 0:{
                SinhVien a=new SinhVien();
                a=(SinhVien) msg.getObj();
                ArrayList<SinhVien> sv=timKiem(a);
                SendMessage(0, sv);
                break;
            }
            case 1:{
                SinhVien a=new SinhVien();
                a=(SinhVien) msg.getObj();
                Object c=update(a);
                SendMessage(1, c);
                break;
            }
        }
    }
    
    @Override
    public void run(){
        try {
            while(true){
                Object o=ois.readObject();
                if(o!=null){
                    inRe((Message) o);
                }
            }
        } catch (Exception e) {
        }
    }
    
    public void SendMessage(int type, Object obj) throws IOException{
        Message a=new Message(type, obj);
        SendMessage(a);
    }
    
    public void SendMessage(int type, ArrayList<SinhVien> obj) throws IOException{
        Message a=new Message(type, obj);
        SendMessage(a);
    }
    
    public void SendMessage(Message msg) throws IOException{
        oos.reset();
        oos.writeObject(msg);
    }
    
    public ArrayList<SinhVien> timKiem(SinhVien a){
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
    
    public String update(SinhVien a){
        try {
            String sql="update sinhvien set ten=?, ngaysinh=?, khoa=?, quequan=? where masv=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, a.getTen());
            ps.setString(2, a.getNgaySinh());
            ps.setInt(3, a.getKhoa());
            ps.setString(4, a.getQuequan());
            ps.setInt(5, a.getMa());
            int rs=ps.executeUpdate();
            if(rs==0){
                return "that bai";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "thanh cong";
    }
}
