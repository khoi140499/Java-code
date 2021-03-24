/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.SinhVien;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Khoi
 */
public interface RMI extends Remote{
    public ArrayList<SinhVien> timKiem(SinhVien a) throws RemoteException;
    public String updat(SinhVien a) throws RemoteException;
}
