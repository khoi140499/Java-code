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
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Khoi
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    static ObjectInputStream ois = null;
    static ObjectOutputStream oos = null;

    public static void main(String[] args) throws IOException {
            Socket a = new Socket("127.0.0.1", 3344);
            Scanner sc = new Scanner(System.in);
            System.out.println("User : ");
            String user = sc.nextLine();
            System.out.println("Pass : ");
            String pass = sc.nextLine();
            ois = new ObjectInputStream(a.getInputStream());
            oos = new ObjectOutputStream(a.getOutputStream());
            User b = new User(user, pass);
            oos.writeUTF("login");
            oos.writeObject(b);

            String sq = ois.readUTF();
            JOptionPane.showMessageDialog(null, sq);
        
    }

}
