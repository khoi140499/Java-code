/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadClass;

import Model.Message;
import Model.SinhVien;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Khoi
 */
public class ServerImp extends Thread {

    private int serverport = 5555;
    private ByteArrayInputStream bais;
    private ObjectInputStream ois;
    private ByteArrayOutputStream baos;
    private ObjectOutputStream oos;
    private DatagramSocket server;
    private DatagramPacket send = null;
    private DatagramPacket receiver = null;
    private Connection conn = null;

    public ServerImp() {
        try {
            ConnectDB();
            OpenServer(serverport);
        } catch (Exception e) {
        }

    }

    private void ConnectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "jdbc:mysql://localhost/diemsv";
            String user = "root";
            String pass = "dangkhoi1404";
            conn = DriverManager.getConnection(sql, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    private void OpenServer(int port) {
        try {
            server = new DatagramSocket(port);
        } catch (SocketException e) {
            System.out.println(e);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                byte[] receiveData = new byte[1024];

                receiver = new DatagramPacket(receiveData, receiveData.length);
                server.receive(receiver);
                bais = new ByteArrayInputStream(receiveData);
                ois = new ObjectInputStream(bais);
                Object o = ois.readObject();
                if (o != null) {
                    Re((Message) o);
                }
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println(ex);
            }
        }
    }

    void Re(Message msg) {
        switch (msg.getType()) {
            case 0: {
                System.out.println("0");
                SinhVien a = new SinhVien();
                a = (SinhVien) msg.getObj();
                ArrayList<SinhVien> sv = timKiem(a);
                for (SinhVien as : sv) {
                    System.out.println(as.getTen());
                }
                SendMessage(10, sv);
                break;
            }
            case 1: {
                SinhVien a = new SinhVien();
                a = (SinhVien) msg.getObj();
                Object o = update(a);
                SendMessage(1, o);
                break;
            }
        }
    }

    public void SendMessage(int type, Object obj) {
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            Message ms = new Message(type, obj);
            oos.reset();
            oos.writeObject(obj);
//            oos.flush();

            InetAddress ip = receiver.getAddress();
            int port = receiver.getPort();
            byte[] sendata = baos.toByteArray();
            send = new DatagramPacket(sendata, sendata.length, ip, port);
            server.send(send);
        } catch (IOException e) {
            System.out.println(e);
        }
    }



    public ArrayList<SinhVien> timKiem(SinhVien a) {
        ArrayList<SinhVien> sv = new ArrayList<>();
        try {
            String sql = "select * from sinhvien where ten=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, a.getTen());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                sv.add(new SinhVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return sv;
    }

    public String update(SinhVien a) {
        try {
            String sql = "update sinhvien set ten=?, ngaysinh=?, khoa=?, quequan=? where masv=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, a.getTen());
            ps.setString(2, a.getNgaySinh());
            ps.setInt(3, a.getKhoa());
            ps.setString(4, a.getQueQuan());
            ps.setInt(5, a.getMa());
            int rs = ps.executeUpdate();
            if (rs == 0) {
                return "that bai";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "thanh cong";
    }
}
