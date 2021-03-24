/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frmlogup;

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
public class ServerListen extends Thread{
    Socket socket=null;
    ObjectOutputStream oos=null;
    ObjectInputStream ois=null;
    
    public inReciever rc;

    public ServerListen(Socket socket) throws IOException {
        this.socket = socket;
        ois=new ObjectInputStream(socket.getInputStream());
        oos=new ObjectOutputStream(socket.getOutputStream());
    }
    
    void Receiver(Message msg) throws SQLException, IOException, ClassNotFoundException{
        switch(msg.getType()){
            case 0:{
                System.out.println("0");
                User as=(User) msg.getObj();
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn;
                String sql="jdbc:mysql://localhost/game";
                String user="root";
                String pass="";
                conn=DriverManager.getConnection(sql, user, pass);
                
                String sql1="select * from users where account=? and password=?";
                PreparedStatement ps=conn.prepareStatement(sql1);
                ps.setString(1, as.getUser());
                ps.setString(2, as.getPass());
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                    Object v="thanh cong";
                    SendMessage(0,v);
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
                    Receiver((Message) o);
                }
            } catch (IOException ex) {
                Logger.getLogger(ServerListen.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServerListen.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ServerListen.class.getName()).log(Level.SEVERE, null, ex);
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
