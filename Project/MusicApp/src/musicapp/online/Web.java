/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicapp.online;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import musicapp.mainapp.MainApp;

/**
 *
 * @author Dang Khoi
 */
public class Web extends JFrame{
    public Web(){
        super();
        addControl();
    }
    private void addControl() {
        Container con=getContentPane();
        JPanel pn=new JPanel();
        pn.setLayout(new BoxLayout(pn, BoxLayout.Y_AXIS));
        con.add(pn);
        
        JPanel thoat=new JPanel();
        thoat.setLayout(new FlowLayout());
        JButton btn=new JButton("Thoát");
        thoat.add(btn);
        pn.add(thoat);
        
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MainApp ma=new MainApp();
                ma.setVisible(true);
            }
        });
        
        JFXPanel fx=new JFXPanel();
        pn.add(fx);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                WebEngine we;
                WebView wv=new WebView();
                we=wv.getEngine();
                fx.setScene(new Scene(wv));
                we.load("http://mp3.zing.vn");
            }
        });
    }
    public void showWindow(){
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
