/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms;

import jaco.mp3.player.MP3Player;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import ms.clas.BaiHat;

/**
 *
 * @author Dang Khoi
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    DefaultListModel dl = new DefaultListModel();
    ArrayList<BaiHat> bh=new ArrayList<BaiHat>();
    MP3Player player=new MP3Player();
    int n=0;
    public Main() {
        initComponents();
        setLocationRelativeTo(null);
        hienDS();
        
    }
    private void hienDS(){
        try {
            File f=new File("List.txt");
            Scanner sc=new Scanner(f);
            while (sc.hasNext()) {
                BaiHat a=new BaiHat(sc.nextLine(), sc.nextLine());
                bh.add(a);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        for(BaiHat as:bh){
            String s=as.getTenBai();
            String[] arr=s.split(".mp3");
            dl.addElement(arr[0]);
            list.setModel(dl);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JLabel();
        txtHien = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnPlay = new javax.swing.JButton();
        btnNext = new javax.swing.JLabel();
        btnBack = new javax.swing.JLabel();
        btnRefesh = new javax.swing.JLabel();
        btnStop = new javax.swing.JLabel();
        btnRe1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setOpacity(0.9F);
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(142, 191, 255), new java.awt.Color(230, 171, 255), null));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ms/img/cancel_48px.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ms/img/expand_arrow_48px.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jScrollPane2.setAutoscrolls(true);

        list.setBackground(new java.awt.Color(0, 0, 0));
        list.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(142, 191, 255), new java.awt.Color(230, 171, 255), null));
        list.setFont(new java.awt.Font("Segoe Script", 0, 12)); // NOI18N
        list.setForeground(new java.awt.Color(230, 171, 255));
        list.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        list.setSelectionForeground(new java.awt.Color(0, 0, 0));
        list.setValueIsAdjusting(true);
        list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(list);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ms/img/kk.gif"))); // NOI18N

        jPanel10.setBackground(new java.awt.Color(0, 0, 0));
        jPanel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(230, 171, 255), new java.awt.Color(142, 191, 255), null));
        jPanel10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel10.setPreferredSize(new java.awt.Dimension(248, 50));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ms/img/11111aaa.gif"))); // NOI18N
        btnAdd.setText("jLabel9");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        txtHien.setEditable(false);
        txtHien.setBackground(new java.awt.Color(0, 0, 0));
        txtHien.setFont(new java.awt.Font("Segoe Script", 0, 13)); // NOI18N
        txtHien.setForeground(new java.awt.Color(159, 59, 255));
        txtHien.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHien.setText("Hello !!!!");
        txtHien.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(86, 78, 255), new java.awt.Color(159, 59, 255), null));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ms/img/ad.gif"))); // NOI18N

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));
        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(142, 191, 255), new java.awt.Color(230, 171, 255), new java.awt.Color(230, 171, 255)));

        btnPlay.setBackground(new java.awt.Color(0, 0, 0));
        btnPlay.setFont(new java.awt.Font("Segoe Script", 1, 13)); // NOI18N
        btnPlay.setForeground(new java.awt.Color(230, 171, 255));
        btnPlay.setText("Play");
        btnPlay.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(142, 191, 255), new java.awt.Color(142, 191, 255), new java.awt.Color(230, 171, 255), new java.awt.Color(230, 171, 255)));
        btnPlay.setContentAreaFilled(false);
        btnPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPlayMouseClicked(evt);
            }
        });

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ms/img/fast_forward_30px.png"))); // NOI18N
        btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNextMouseClicked(evt);
            }
        });

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ms/img/rewind_30px.png"))); // NOI18N
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
        });

        btnRefesh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ms/img/repeat_30px.png"))); // NOI18N
        btnRefesh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRefeshMouseClicked(evt);
            }
        });

        btnStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ms/img/stop_30px.png"))); // NOI18N
        btnStop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStopMouseClicked(evt);
            }
        });

        btnRe1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ms/img/repeat_30px (1).png"))); // NOI18N
        btnRe1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRe1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(btnRe1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStop)
                .addGap(15, 15, 15)
                .addComponent(btnBack)
                .addGap(18, 18, 18)
                .addComponent(btnPlay, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnNext)
                .addGap(15, 15, 15)
                .addComponent(btnRefesh)
                .addGap(26, 26, 26))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRefesh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnStop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9))
                    .addComponent(btnRe1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtHien, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(9, 9, 9)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHien))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private int x,y;
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        x=evt.getX();
        y=evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        setLocation(evt.getXOnScreen()-x, evt.getYOnScreen()-y);
    }//GEN-LAST:event_formMouseDragged

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        setState(ICONIFIED);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void btnPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayMouseClicked
        n++;
            if(btnPlay.getText().equalsIgnoreCase("Play")==true){
                player.play();
                btnPlay.setText("Pause");
            }
            else if(btnPlay.getText().equalsIgnoreCase("Pause")==true){
                player.pause();
                btnPlay.setText("Play");
        }
    }//GEN-LAST:event_btnPlayMouseClicked

    private void btnStopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStopMouseClicked
        player.stop();
        btnPlay.setEnabled(true);
        btnBack.setEnabled(true);
        btnNext.setEnabled(true);
        btnRefesh.setEnabled(true);
        
        btnPlay.setText("Play");
    }//GEN-LAST:event_btnStopMouseClicked
        
    private void btnRefeshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefeshMouseClicked
        if(btnPlay.getText().equalsIgnoreCase("Pause")){
            btnStopMouseClicked(null);
            btnPlay.setText("Pause");
        }
        btnBack.setEnabled(false);
        btnNext.setEnabled(false);
        btnRe1.setEnabled(true);
        player=new MP3Player();
        for(BaiHat as:bh){
            File f=new File(as.getDuongDan());
            player.addToPlayList(f);
            player.play();
            player.setShuffle(true);
            btnRefesh.setEnabled(false);
            btnPlay.setText("Pause");
        }
        txtHien.setText("Have a nice song !!!");
        player.setRepeat(false);
    }//GEN-LAST:event_btnRefeshMouseClicked

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        JFileChooser jf=new JFileChooser();
        if(jf.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
            try {
                File f=jf.getSelectedFile();
                String s=f.getName();
                String s1=f.getCanonicalPath();
                String[] arr=s.split(".mp3");
                dl.addElement(arr[0]);
                list.setModel(dl);
                BaiHat a=new BaiHat(s, s1);
                bh.add(a);
                
                File f1=new File("List.txt");
                PrintWriter pr=new PrintWriter(f1);
                for(BaiHat as:bh){
                    pr.println(as.toString());
                }
                pr.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            
        }
    }//GEN-LAST:event_btnAddMouseClicked

    private void listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMouseClicked
        if(btnPlay.getText().equalsIgnoreCase("Pause")==true){
            btnStopMouseClicked(null);
        }
        
        String s=list.getSelectedValue();
        txtHien.setText(s);
        for(BaiHat as:bh){
            if(as.getTenBai().equalsIgnoreCase(s+".mp3")==true){
                File f=new File(as.getDuongDan());
                player=new MP3Player();
                player.addToPlayList(f);
                player.play();
                btnPlay.setText("Pause");
            }
        }
    }//GEN-LAST:event_listMouseClicked

    private void btnNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseClicked
//        player.skipBackward();
        if(btnPlay.getText().equalsIgnoreCase("Pause")){
            btnStopMouseClicked(null);
        }
        
        ArrayList<String> st=new ArrayList<String>();
        for(BaiHat as:bh){
            st.add(as.getTenBai());
        }
        
        for(int i=0;i<st.size();i++){
            if(st.get(i).equals(txtHien.getText()+".mp3")==true){
                String s=st.get(i+1)+"";
                String[] arr=s.split(".mp3");
                txtHien.setText(arr[0]);
                list.setSelectedIndex(i+1);
                break;
            }
            else if(st.get(st.size()-1).equals(txtHien.getText()+".mp3")==true){
                String s=st.get(i)+"";
                String[] arr=s.split(".mp3");
                txtHien.setText(arr[0]);
                list.setSelectedIndex(i);
            }
        }
        
        for(BaiHat as:bh){
            if(as.getTenBai().equalsIgnoreCase(txtHien.getText()+".mp3")){
                player=new MP3Player();
                File f=new File(as.getDuongDan());
                player.addToPlayList(f);
                player.play();
                btnPlay.setText("Pause");
            }
        }
    }//GEN-LAST:event_btnNextMouseClicked

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        if(btnPlay.getText().equalsIgnoreCase("Pause")){
            btnStopMouseClicked(null);
        }
        
        ArrayList<String> st =new ArrayList<String>();
        ArrayList<String> st1 =new ArrayList<String>();
        for(BaiHat as:bh){
            st.add(as.getTenBai());
        }
        
        Collections.reverse(st);
        for(String as:st){
            st1.add(as);
        }
        
         for(int i=0;i<st1.size();i++){
            if(st1.get(i).equals(txtHien.getText()+".mp3")==true){
                String s=st.get(i+1)+"";
                String[] arr=s.split(".mp3");
                txtHien.setText(arr[0]);
                list.setSelectedValue(arr[0], true);
                break;
            }
            else if(st.get(st.size()-1).equals(txtHien.getText()+".mp3")==true){
                String s=st.get(i)+"";
                String[] arr=s.split(".mp3");
                txtHien.setText(arr[0]);
                list.setSelectedValue(arr[0], true);
            }
        }
        
        for(BaiHat as:bh){
            if(as.getTenBai().equalsIgnoreCase(txtHien.getText()+".mp3")){
                player=new MP3Player();
                File f=new File(as.getDuongDan());
                player.addToPlayList(f);
                player.play();
                btnPlay.setText("Pause");
            }
        }
    }//GEN-LAST:event_btnBackMouseClicked

    private void btnRe1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRe1MouseClicked
        player.setRepeat(true);
        player.setShuffle(false);
        btnRefesh.setEnabled(true);
        btnRe1.setEnabled(false);
    }//GEN-LAST:event_btnRe1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAdd;
    private javax.swing.JLabel btnBack;
    private javax.swing.JLabel btnNext;
    private javax.swing.JButton btnPlay;
    private javax.swing.JLabel btnRe1;
    private javax.swing.JLabel btnRefesh;
    private javax.swing.JLabel btnStop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> list;
    private javax.swing.JTextField txtHien;
    // End of variables declaration//GEN-END:variables
}
