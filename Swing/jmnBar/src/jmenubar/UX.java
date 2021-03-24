package jmenubar;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;

public class UX extends JFrame{
    JMenuBar menuBar;
    JMenu mnFile;
    JMenu mnEdit;
    JMenu mnHelp;
    
    JMenuItem mnFileNew;
    JMenuItem mnFileOpen;
    JMenuItem mnFileExit;
    
    JMenuItem mnEditCopy;
    JMenuItem mnEditPaste;
    JMenuItem mnEditDelete;
    
    JMenuItem mnHelpGui;
    JButton mo;
    JPanel main;
    public UX(){
        this.setTitle("test Giao dien");
        addControl();
        addEvent();
    }
    public void addControl() {
        menuBar=new JMenuBar();
        setJMenuBar(menuBar);
        
        mnFile=new JMenu("File");
        menuBar.add(mnFile);
        
        mnEdit=new JMenu("Edit");
        menuBar.add(mnEdit);
        
        mnHelp=new JMenu("Help");
        menuBar.add(mnHelp);
        
        mnFileOpen=new JMenuItem("Open");
        mnFileNew=new JMenuItem("New");
        mnFileExit=new JMenuItem("Exit");
        mnFile.add(mnFileNew);
        mnFileNew.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));

        mnFile.addSeparator();
        mnFile.add(mnFileOpen);
        mnFile.addSeparator();
        mnFile.add(mnFileExit);
        
        Container con=getContentPane();
        main=new JPanel();
        main.setLayout(new FlowLayout());
        JButton btn=new JButton("Bam vao toi di");
        main.add(btn);
        con.add(main);
        
        btn.addMouseListener(new PopUpClick());
    }
    class PopUpDemo extends JPopupMenu{
        JMenuItem anden;
        JMenuItem ando;
        JMenuItem anxanh;
        JMenuItem antim;
        JMenuItem anhong;
        public PopUpDemo(){
            anden=new JMenuItem("Den");
            add(anden);
            
            ando=new JMenuItem("Do");
            add(ando);
            
            anxanh=new JMenuItem("Xanh!");
            add(anxanh);
            
            antim=new JMenuItem("Tim");
            add(antim);
            
            anhong=new JMenuItem("Hong");
            add(anhong);
            
            anden.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(mo!=null){
                        main.setBackground(Color.BLACK);
                    }
                }
            });
            ando.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(mo!=null){
                        main.setBackground(Color.RED);
                    }
                }
            });
            anxanh.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(mo!=null){
                        main.setBackground(Color.BLUE);
                    }
                }
            });
            antim.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(mo!=null){
                        main.setBackground(Color.MAGENTA);
                    }
                }
            });
            anhong.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(mo!=null){
                        main.setBackground(Color.PINK);
                    }
                }
            });
        }
    }
    class PopUpClick extends MouseAdapter{  
        public void mousePressed(MouseEvent e){
            if(e.isPopupTrigger()){
                doPop(e);
            }
        }
        public void mouseReleased(MouseEvent e){
            if(e.isPopupTrigger()){
                doPop(e);
            }
        }
        private void doPop(MouseEvent e){
            PopUpDemo menu=new PopUpDemo();
            mo=(JButton) e.getComponent();
            menu.show(e.getComponent(), e.getX(), e.getY());
        }
    }
    public void addEvent() {
        mnFileExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    public void showWindow(){
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
