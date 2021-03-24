package web;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Web {
    public static void main(String[] args) {
        final JFrame fram=new JFrame();
        fram.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fram.setSize(400, 500);
        final JFXPanel panel=new JFXPanel();
        fram.add(panel);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                WebEngine engine;
                WebView vv=new WebView();
                engine=vv.getEngine();
                panel.setScene(new Scene(vv));
                engine.load("https://mp3.zing.vn");
            }
        });
        fram.setVisible(true);
    }
    
}
