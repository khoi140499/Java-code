package App.online;

import App.main.MainApp;
import java.awt.BorderLayout;
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
        
        JPanel btn=new JPanel();
        btn.setLayout(new FlowLayout());
        pn.add(btn);
        JButton btnThoat=new JButton("Thoát");
        btn.add(btnThoat);
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MainApp mn=new MainApp();
                mn.setVisible(true);
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
