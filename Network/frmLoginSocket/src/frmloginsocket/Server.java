/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frmloginsocket;

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
    static ServerSocket sv;
    public static void main(String[] args) {
        new OP().start();
    }
    
    private static void open(int port){
        try {
            sv=new ServerSocket(port);
            if(sv==null){
                System.out.println("Mo cong that bai");
            }
            else{
                System.out.println("Mo cong thanh cong");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    static class OP extends Thread{
        public OP() {
            open(4444);
        }
        @Override
        public void run(){
            while(true){
                try {
                    Socket socket=sv.accept();
                    ServerListen sl=new ServerListen(socket);
                    System.out.println("Server: " + socket.getInetAddress() + " is connecting");
                    sl.start();
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
