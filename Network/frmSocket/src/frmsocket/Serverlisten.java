/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frmsocket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Khoi
 */
public class Serverlisten extends Thread{
    Socket socket;
    ObjectInputStream ois;
    ObjectOutputStream oos;

    public Serverlisten(Socket socket) throws IOException {
        this.socket = socket;
        oos=new ObjectOutputStream(socket.getOutputStream());
        ois=new ObjectInputStream(socket.getInputStream());
    }
    
    void Re(Message msg) throws ClassNotFoundException, SQLException, IOException{
        switch(msg.getType()){
            case 0:{
                User a=(User) msg.getObj();
                Class.forName("com.mysql.cj.jdbc.Driver");
                String sql="jdbc:mysql://localhost/game";
                String user="root";
                String pass="";
                Connection conn=DriverManager.getConnection(sql, user, pass);
                
                String sql1="select * from users where account=? and password=?";
                PreparedStatement ps=conn.prepareStatement(sql1);
                ps.setString(1, a.getUser());
                ps.setString(2, a.getPass());
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                    Object sa="thanh cong";
                    SendMessage(0, sa);
                }
                break;
            }
        }
    }
    @Override
    public void run(){
        while(true){
            try {
                Object o=ois.readObject();
                if(o!=null){
                    Re((Message) o);
                }
            } catch (IOException ex) {
                Logger.getLogger(Serverlisten.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Serverlisten.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Serverlisten.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void SendMessage(int type, Object obj) throws IOException{
        Message a=new Message(type, obj);
        SendMessage(a);
    }
    
    public void SendMessage(Message msg) throws IOException{
        oos.reset();
        oos.writeObject(msg);
    }
}
