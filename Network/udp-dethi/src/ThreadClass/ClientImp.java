/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadClass;

import Model.Message;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Khoi
 */
public class ClientImp extends Thread{
    private int serverport=5555;
    private int clientport=6666;
    private String host="localhost";
    private DatagramSocket dgs;
    private ByteArrayInputStream bais;
    private ObjectInputStream ois;
    private ByteArrayOutputStream baos;
    private ObjectOutputStream oos;
    private DatagramPacket receiver=null;
    private DatagramPacket send=null;
    public inRe rc;

    public ClientImp() {
    }
    
    public void Connect(){
        try {
            dgs=new DatagramSocket(clientport);
        } catch (Exception e) {
        }
    }
    
    @Override
    public void run(){
        while(true){
            try {
                byte[] receiveData = new byte[1024];
                receiver = new DatagramPacket(receiveData, receiveData.length);
                dgs.receive(receiver);
                bais = new ByteArrayInputStream(receiveData);
                ois = new ObjectInputStream(bais);
                Object o = ois.readObject();
               if(o!= null && rc!= null){
                   rc.Re((Message)o);
               }
                
            } catch (IOException ex) {
                Logger.getLogger(ClientImp.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClientImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void SendMessage(int type, Object obj){
        try {
            baos=new ByteArrayOutputStream();
            oos=new ObjectOutputStream(baos);
            Message msg=new Message(type, obj);
            oos.reset();
            oos.writeObject(msg);
            oos.flush();
            
            InetAddress ip=InetAddress.getByName(host);
            byte[] senddata=baos.toByteArray();
            send=new DatagramPacket(senddata, senddata.length, ip, serverport);
            dgs.send(send);
            
        } catch (IOException ex) {
            Logger.getLogger(ClientImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
