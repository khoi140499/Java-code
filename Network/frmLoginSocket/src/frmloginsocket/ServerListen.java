/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frmloginsocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
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
public class ServerListen extends Thread{
    Socket socket=null;
    ObjectOutputStream oos=null;
    ObjectInputStream ois=null;

    boolean kt=true;
    Connection conn=null;

    public ServerListen(Socket socket) throws IOException {
        this.socket=socket;
        ois=new ObjectInputStream(socket.getInputStream());
        oos=new ObjectOutputStream(socket.getOutputStream());
    }
    
    void RecieverMessage(Message msg) throws ClassNotFoundException, SQLException, IOException {
        switch(msg.getType()){
            case 0:{
                System.out.println("case0");
                User us=(User) msg.getObject();
                Class.forName("com.mysql.cj.jdbc.Driver");
                String sql="jdbc:mysql://localhost/game";
                String user="root";
                String pass="";
                conn=DriverManager.getConnection(sql, user, pass);
                
                String sql1="select * from users where account=? and password=?";
                PreparedStatement ps=conn.prepareStatement(sql1);
                ps.setString(1, us.getUsername());
                ps.setString(2, us.getPass());
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                    Object a="thanh cong";
                    SendMessage(1, a);
                }
                break;
            }
        }
    }
    
    public void run(){
        while(true){
            try {
                Object o=ois.readObject();
                if(o!= null){
                    RecieverMessage((Message) o);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public void SendMessage(int type, Object obj) throws IOException{
        Message tp=new Message(type, obj);
        SendMessage(tp);
    }
    
    public void SendMessage(Message msg) throws IOException{
        oos.reset();
        oos.writeObject(msg);
    }
}
