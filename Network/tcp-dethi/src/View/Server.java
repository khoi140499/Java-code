/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import ThreadClass.ServerImp;
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
        new Open().start();
    }
    
    private static void OpenPort(int port){
        try {
            sv=new ServerSocket(port);
            System.out.println("mo thanh cong");
        } catch (Exception e) {
        }
    }
    
    static class Open extends Thread{

        public Open() {
            OpenPort(1234);
        }
        @Override
        public void run(){
            while(true){
                try {
                    Socket socket=sv.accept();
                    ServerImp a=new ServerImp(socket);
                    a.start();
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
