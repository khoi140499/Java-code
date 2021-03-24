/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadClass;

import Model.Message;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Khoi
 */
public class ClientImp extends Thread{
    Socket socket=null;
    ObjectInputStream ois=null;
    ObjectOutputStream oos=null;
    
    public inRe rc;
    
    public ClientImp(Socket socket) throws IOException{
        this.socket=socket;
        oos=new ObjectOutputStream(socket.getOutputStream());
        ois=new ObjectInputStream(socket.getInputStream());
    }
    
    @Override
    public void run(){
        try {
            while(true){
                Object o=ois.readObject();
                if(o!=null && rc!=null){
                    rc.inRe((Message) o);
                }
            }
        } catch (Exception e) {
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
