package javaapplication22;

import javax.swing.*;
import java.awt.*;

public class JavaApplication22 extends JFrame{
    public static void main(String[] args) {
    JavaApplication22 vi=new JavaApplication22();
    vi.setSize(400, 300);
    vi.setLocationRelativeTo(null);
    vi.setVisible(true);
    }
    public JavaApplication22(){
        super("Demo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
