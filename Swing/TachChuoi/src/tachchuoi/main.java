package tachchuoi;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class main extends JFrame{
    JTextField txtnhap;
    JTextArea tanhap;
    JButton btnok, btnxoa, btnthoat;
    ArrayList<String> ins=new ArrayList<>();
    public main(){
        this.setTitle("Giao dien");
        addControl();
        addEvent();
    }
    public void addControl() {
        Container con=getContentPane();
        JPanel  main=new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        con.add(main);
        
        JPanel pnnhap=new JPanel();
        pnnhap.setLayout(new FlowLayout());
        JLabel nhap=new JLabel("Nhap chuoi");
        txtnhap=new JTextField(20);
        pnnhap.add(nhap);
        pnnhap.add(txtnhap);
        main.add(pnnhap);
        
        JPanel bt=new JPanel();
        btnok=new JButton("Ok");
        btnxoa=new JButton("Delete");
        btnthoat=new JButton("Exit");
        bt.add(btnok);
        bt.add(btnxoa);
        bt.add(btnthoat);
        main.add(bt);
        
        JPanel pnxuat=new JPanel();
        pnxuat.setLayout(new FlowLayout());
        JLabel jl=new JLabel("Ket qua");
        tanhap=new JTextArea(5, 15);
        JScrollPane js=new JScrollPane(tanhap, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        tanhap.setWrapStyleWord(true);
        tanhap.setLineWrap(true);
        pnxuat.add(jl);
        pnxuat.add(js);
        main.add(pnxuat);
        
        Border br=BorderFactory.createLineBorder(Color.RED);
        TitledBorder tbr=new TitledBorder(br, "Tach chuoi");
        tbr.setTitleColor(Color.BLACK);
        main.setBorder(tbr);
    }
    public void addEvent() {
       btnthoat.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               System.exit(0);
           }
       });
       btnxoa.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               txtnhap.setText("");
               tanhap.setText("");
          }
       });
       btnok.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               ok();
           }

           private void ok() {
               String s=txtnhap.getText();
               String a=s;
               String[] arr=a.split(" ");
              // ins.add(arr);
               for(int i=0;i<a.length();i++){
                   tanhap.setText(" "+arr[i]);
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
}
