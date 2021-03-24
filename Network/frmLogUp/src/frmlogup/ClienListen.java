/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frmlogup;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Khoi
 */
public class ClienListen extends Thread {

    Socket socket;
    InputStream is;
    ObjectInputStream ois;
    OutputStream os;
    ObjectOutputStream oos;

    public inReciever rc;

    public ClienListen(Socket socket) throws IOException {
        this.socket = socket;
        os = socket.getOutputStream();
        oos = new ObjectOutputStream(os);
        is = socket.getInputStream();
        ois = new ObjectInputStream(is);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Object o = ois.readObject();
                if (o != null && rc != null) {
                    rc.Reciever((Message) o);
                }
            } catch (IOException ex) {
                Logger.getLogger(ClienListen.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClienListen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void SendMessage(int type, Object obj) throws IOException {
        Message a = new Message(type, obj);
        SendMessage(a);
    }

    public void SendMessage(Message msg) throws IOException {
        oos.reset();
        oos.writeObject(msg);
    }
}
