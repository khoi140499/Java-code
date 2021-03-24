/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listen;

import Model.Message;
import Model.SinhVien;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Khoi
 */
public class ServerListen extends Thread{
    Socket socket;
    ObjectInputStream ois;
    ObjectOutputStream oos;

    public ServerListen(Socket socket) throws IOException {
        this.socket = socket;
        oos=new ObjectOutputStream(socket.getOutputStream());
        ois=new ObjectInputStream(socket.getInputStream());
    }
    
    void Re(Message msg) throws ClassNotFoundException, SQLException, IOException{
        switch(msg.getType()){
            case 0:{
                //timkiem
                SinhVien sv=(SinhVien) msg.getObj();
                ArrayList<SinhVien> arsv=new Connect.ConnectDB().TimKiem(sv.getTen());
                System.out.println("0 - "+arsv.toString());
                SendMessage(0, arsv);
                break;
            }
            case 1:{
                //update sv
                SinhVien sv=(SinhVien) msg.getObj();
                Object s=new Connect.ConnectDB().UpdateSV(sv);
                SendMessage(1, s);
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
                Logger.getLogger(ServerListen.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServerListen.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ServerListen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void SendMessage(int type, ArrayList<SinhVien> sv) throws IOException{
        Message ms=new Message(type, sv);
        SendMessage(ms);
    }
    
    public void SendMessage(int type, Object obj) throws IOException{
        Message ms=new Message(type, obj);
        SendMessage(ms);
    }
    
    public void SendMessage(Message msg) throws IOException{
        oos.reset();
        oos.writeObject(msg);
    }
}
