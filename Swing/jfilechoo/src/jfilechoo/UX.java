package jfilechoo;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class UX extends JFrame{
    JMenuBar menubar;
    JMenu mnfile;
    JMenuItem mnfileopen;
    JMenuItem mnfilesave;
    JMenuItem mnexit;
    JTextArea data;
    public UX(){
        this.setTitle("Giao dien");
        addControl();
        addEvent();
    }
    private void addControl() {
        menubar();
        Container con=getContentPane();
        con.setLayout(new BorderLayout());
        data=new JTextArea(10, 10);
        JScrollPane cp=new JScrollPane(data, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        data.setWrapStyleWord(true);
        data.setLineWrap(true);
        con.add(cp, BorderLayout.CENTER);
    }
    private void addEvent() {
        mnexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thoat();
            }
        });
        mnfileopen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mofile();
            }

            private void mofile() {
                JFileChooser js=new JFileChooser();
                if(js.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
                    File op=js.getSelectedFile();
                    try{
                    FileInputStream fin=new FileInputStream(op);
                    InputStreamReader in=new InputStreamReader(fin,"UTF-8");
                    BufferedReader rd=new BufferedReader(in);
                    String li=rd.readLine();
                    StringBuilder bd=new StringBuilder();
                    while(li!=null){
                        bd.append(li);
                        li=rd.readLine();
                    }
                    rd.close();
                    data.setText(bd.toString());
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
        mnfilesave.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                luufile();
            }

            private void luufile() {
                JFileChooser jf=new JFileChooser();
                if(jf.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
                    String da=data.getText();
                    try{
                        FileOutputStream fo=new FileOutputStream(jf.getSelectedFile());
                        OutputStreamWriter op=new OutputStreamWriter(fo,"UTF-8");
                        op.write(da);
                        op.close();
                        fo.close();
                        JOptionPane.showMessageDialog(null, "Luu file thanh cong");
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
        }
        });
    }
    public void showWindow(){
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void menubar() {
        menubar=new JMenuBar();
        setJMenuBar(menubar);
        mnfile=new JMenu("He thong");
        menubar.add(mnfile);
        mnfileopen=new JMenuItem("Open");
        mnfilesave=new JMenuItem("Save");
        mnexit=new JMenuItem("Exit");
        mnfile.add(mnfileopen);
        mnfile.add(mnfilesave);
        mnfile.add(mnexit);
        
    }

    private void thoat() {
        int a=JOptionPane.showConfirmDialog(null, "Ban co chac chan muon that phan mem nay khong","Xac nhan thoat", JOptionPane.YES_NO_CANCEL_OPTION);
        if(a==JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
}
