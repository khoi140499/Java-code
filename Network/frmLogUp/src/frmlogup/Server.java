/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frmlogup;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Khoi
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    private static ServerSocket sv=null;
    public static void main(String[] args) {
        new OpenServer().start();
    }
    
    private static void OpenPort(int port){
        try {
            sv=new ServerSocket(port);
            System.out.println("Mo cong thanh cong");
            if(sv==null){
                System.out.println("Mo cong that bai");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    static class OpenServer extends Thread{

        public OpenServer() {
            OpenPort(1234);
        }
        
        @Override
        public void run(){
            while(true){
                try {
                    Socket socket=sv.accept();
                    System.out.println("client "+socket.getInetAddress()+" is connecting");
                    ServerListen sl=new ServerListen(socket);
                    sl.start();
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
