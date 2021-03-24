/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Listen.ServerListen;
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
    static ServerSocket sv = null;

    public static void main(String[] args) {
        // TODO code application logic here
        new Open().start();
    }

    private static void Openport(int port) {
        try {
            if (sv == null) {
                sv = new ServerSocket(port);
                System.out.println("mo thanh cong");
            } else {
                System.out.println("that bai");
            }
        } catch (Exception e) {
        }
    }

    static class Open extends Thread {

        public Open() {
            Openport(1234);
        }

        @Override
        public void run() {
            try {
                while (true) {
                    Socket sc = sv.accept();
                    ServerListen sl = new ServerListen(sc);
                    sl.start();
                }
            } catch (Exception e) {
            }
        }
    }
}
