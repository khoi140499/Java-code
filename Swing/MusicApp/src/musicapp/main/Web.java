package musiapp.online;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import musicapp.main.App;

/**
 *
 * @author Dang Khoi
 */
public class Web extends JFrame{
    public Web(){
        super();
        add();
    }
    public void showWindow(){
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void add() {
        Container con=getContentPane();
        JPanel pn=new JPanel();
        pn.setLayout(new BoxLayout(pn, BoxLayout.Y_AXIS));
        con.add(pn);
        
        JPanel thoat=new JPanel();
        thoat.setLayout(new FlowLayout());
        JButton btn=new JButton("Thoát");
        pn.add(btn);
        
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                App b=new App();
                b.setVisible(true);
            }
        });
        
        JFXPanel jfx=new JFXPanel();
        pn.add(jfx);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                WebEngine we;
                WebView wv=new WebView();
                we=wv.getEngine();
                jfx.setScene(new Scene(wv));
                we.load("https://mp3.zing.vn");
            }
        });
    }
}
