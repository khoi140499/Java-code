/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frmsocket;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Khoi
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    static ServerSocket sv=null;
    public static void main(String[] args) {
        // TODO code application logic here
        new Open().start();
    }
    
    private static void Openport(int port){
        try {
            sv=new ServerSocket(port);
            System.out.println("mo thanh cong");
            if(sv==null){
                System.out.println("mo that bai");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    static class Open extends Thread{

        public Open() {
            Openport(1234);
        }
        @Override
        public void run(){
            try {
                Socket so=sv.accept();
                Serverlisten sl=new Serverlisten(so);
                System.out.println("CLient "+so.getInetAddress()+" is connecting");
                sl.start();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
