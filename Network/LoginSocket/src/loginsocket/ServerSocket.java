/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginsocket;

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
public class ServerSocket extends Thread{
    Socket socket=null;
    ObjectInputStream ois=null;
    ObjectOutputStream oos=null;
    Connection conn=null;
    public ServerSocket(Socket socket) throws IOException {
        this.socket=socket;
        ois=new ObjectInputStream(socket.getInputStream());
        oos=new ObjectOutputStream(socket.getOutputStream());
    }
    
    public void run(){
        try {
            String msg=ois.readUTF();
            switch(msg){
                case "login":{
                    User a=(User) ois.readObject();
                    Class.forName("com.mysql.jdbc.Driver");
                    String sql="jdbc:mysql://localhost/game";
                    String user="root";
                    String pass="";
                    conn=DriverManager.getConnection(sql, user, pass);
                    
                    String sql1="select * from users where account=? and password=?";
                    PreparedStatement ps=conn.prepareStatement(sql1);
                    ps.setString(1, a.getUsernam());
                    ps.setString(2, a.getPass());
                    ResultSet rs=ps.executeQuery();
                    if(rs.next()){
                        oos.writeUTF("thanhcong");
                    }
                    else{
                        oos.writeUTF("thatbai");
                    }
                    rs.close();
                    ps.close();
                    break;
                }
                default:
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerSocket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerSocket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServerSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
