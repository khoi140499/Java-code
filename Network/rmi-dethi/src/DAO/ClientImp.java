/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.SinhVien;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

/**
 *
 * @author Khoi
 */
public class ClientImp {
    private int port=1234;
    private String host="localhost";
    private Registry re;
    private RMI rmi;
    private String services="rmi";

    public ClientImp() {
        try {
            re=LocateRegistry.getRegistry(host, port);
            rmi=(RMI) re.lookup(services);
        } catch (Exception e) {
        }
    }
    
    public ArrayList<SinhVien> timKiem(SinhVien a) throws RemoteException{
        ArrayList<SinhVien> sv=new ArrayList<SinhVien>();
        sv=rmi.timKiem(a);
        return sv;
    }
    
    public String update(SinhVien a) throws RemoteException{
        String s=rmi.updat(a);
        return s;
    }
}
