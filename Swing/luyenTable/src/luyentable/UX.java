package luyentable;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UX extends JFrame{
    DefaultTableModel tb;
    JTable dm;
    JButton btnxoa, btnthoat;
    public UX(){
           this.setTitle("Giao dien");
           addControl();
           addEvent();
       }
    public void addControl() {
        Container con=getContentPane();
        tb=new DefaultTableModel();
        tb.addColumn("Ma");
        tb.addColumn("Ten");
        tb.addColumn("Tuoi");
        
        dm=new JTable(tb);
        tb.addRow(new String[]{"NV1","HOANG DANG KHOI", "20"});
        tb.addRow(new String[]{"NV2","AN QUANG NGOC", "20"});
        tb.addRow(new String[]{"NV3","DINH THE VINH", "20"});
        JScrollPane js=new JScrollPane(dm, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        con.setLayout(new BorderLayout());
        con.add(js, BorderLayout.CENTER);
        
        JPanel main=new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.X_AXIS));
        con.add(main, BorderLayout.SOUTH);
        
        JPanel bt=new JPanel();
        bt.setLayout(new FlowLayout());
        btnxoa = new JButton("Xoa");
        btnthoat=new JButton("Thoat");
        bt.add(btnxoa);
        bt.add(btnthoat);
        main.add(bt);
        
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
                int row=dm.getSelectedRow();
                tb.removeRow(row);
            }
        });
        dm.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row=dm.getSelectedRow();
                if(row==-1) return;
                String ma=dm.getValueAt(row, 0)+"";
                String ten=dm.getValueAt(row, 1)+"";
                String tuoi=dm.getValueAt(row, 2)+"";
                JOptionPane.showMessageDialog(null, "ma: "+ma+"\nten: "+ten+"\ntuoi: "+tuoi);
            }
            @Override
            public void mousePressed(MouseEvent e) {
                
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                
            }
            @Override
            public void mouseExited(MouseEvent e) {
                
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
