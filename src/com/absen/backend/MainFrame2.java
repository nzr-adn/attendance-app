///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package com.absen.backend;
//
//import java.awt.Color;
//import java.awt.Container;
//import java.awt.Dimension;
//import java.awt.EventQueue;
//import java.awt.Font;
//import java.awt.Image;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintStream;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.imageio.ImageIO;
//import javax.swing.GroupLayout;
//import javax.swing.GroupLayout.Alignment;
//import javax.swing.GroupLayout.ParallelGroup;
//import javax.swing.GroupLayout.SequentialGroup;
//import javax.swing.JButton;
//import javax.swing.JFormattedTextField;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPasswordField;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//import javax.swing.LayoutStyle;
//import javax.swing.LayoutStyle.ComponentPlacement;
//import javax.swing.UIManager;
//import javax.swing.UIManager.LookAndFeelInfo;
//import javax.swing.UnsupportedLookAndFeelException;
//import javax.swing.text.BadLocationException;
//import javax.swing.text.Document;
//import org.postgresql.PGConnection;
///**
// *
// * @author Lenovo
// */
public class MainFrame2
//  extends JFrame
{
//  private PrintStream standardOut;
//  Connection mdbConn;
//  PGConnection pgConn;
//  ThreadSql listener;
//  ThreadWebservice wsThread;
//  String username;
//  String password;
//  String host;
//  String xport;
//  String dbase;
//  private JButton btnClear;
//  private JButton btnEnd;
//  private JButton btnPing;
//  private JButton btnStart;
//  private JLabel jLabel1;
//  private JLabel jLabel10;
//  private JLabel jLabel11;
//  private JLabel jLabel12;
//  private JLabel jLabel13;
//  private JLabel jLabel2;
//  private JLabel jLabel3;
//  private JLabel jLabel4;
//  private JLabel jLabel5;
//  private JLabel jLabel6;
//  private JLabel jLabel7;
//  private JLabel jLabel8;
//  private JLabel jLabel9;
//  private JScrollPane jScrollPane1;
//  private JTextField txtDbase;
//  private JFormattedTextField txtIP;
//  private JTextArea txtOutput;
//  private JTextField txtPort;
//  private JPasswordField txtPswd;
//  private JPasswordField txtPswdWs;
//  private JTextField txtSchema;
//  private JTextField txtSleep;
//  private JLabel txtStatus;
//  private JTextField txtUrl;
//  private JTextField txtUrlMdb;
//  private JTextField txtUser;
//  private JTextField txtUserWs;
//  
//  public MainFrame2()
//  {
//    try
//    {
//      initComponents();
//      PrintStream printStream = new PrintStream(new CustomOutputStream(this.txtOutput));
//      
//      this.standardOut = System.out;
//      
//      System.setOut(printStream);
//      System.setErr(printStream);
//      
//      setDefaultCloseOperation(3);
//      Image i = ImageIO.read(getClass().getResource("/loadfull.png"));
//      setIconImage(i);
//      
//      setLocationRelativeTo(null);
//    }
//    catch (IOException ex)
//    {
//      Logger.getLogger(MainFrame2.class.getName()).log(Level.SEVERE, null, ex);
//    }
//  }
//  
//  private void initComponents()
//  {
//    this.btnStart = new JButton();
//    this.btnEnd = new JButton();
//    this.jScrollPane1 = new JScrollPane();
//    this.txtOutput = new JTextArea();
//    this.txtPort = new JTextField();
//    this.txtUser = new JTextField();
//    this.txtIP = new JFormattedTextField();
//    this.jLabel1 = new JLabel();
//    this.jLabel2 = new JLabel();
//    this.btnPing = new JButton();
//    this.jLabel3 = new JLabel();
//    this.jLabel4 = new JLabel();
//    this.txtPswd = new JPasswordField();
//    this.jLabel5 = new JLabel();
//    this.txtDbase = new JTextField();
//    this.jLabel6 = new JLabel();
//    this.txtStatus = new JLabel();
//    this.jLabel7 = new JLabel();
//    this.txtUrl = new JTextField();
//    this.btnClear = new JButton();
//    this.jLabel8 = new JLabel();
//    this.txtUrlMdb = new JTextField();
//    this.jLabel9 = new JLabel();
//    this.jLabel10 = new JLabel();
//    this.txtUserWs = new JTextField();
//    this.txtPswdWs = new JPasswordField();
//    this.jLabel11 = new JLabel();
//    this.txtSchema = new JTextField();
//    this.jLabel12 = new JLabel();
//    this.txtSleep = new JTextField();
//    this.jLabel13 = new JLabel();
//    
//    setDefaultCloseOperation(3);
//    setTitle("Absensi Backend");
//    setAlwaysOnTop(true);
//    setBackground(new Color(255, 255, 102));
//    setResizable(false);
//    setSize(new Dimension(40, 40));
//    
//    this.btnStart.setText("Start");
//    this.btnStart.addActionListener(new ActionListener()
//    {
//      public void actionPerformed(ActionEvent evt)
//      {
//        MainFrame2.this.btnStartActionPerformed(evt);
//      }
//    });
//    this.btnEnd.setText("Stop");
//    this.btnEnd.addActionListener(new ActionListener()
//    {
//      public void actionPerformed(ActionEvent evt)
//      {
//        MainFrame2.this.btnEndActionPerformed(evt);
//      }
//    });
//    this.txtOutput.setColumns(20);
//    this.txtOutput.setRows(5);
//    this.jScrollPane1.setViewportView(this.txtOutput);
//    
//    this.txtPort.setText("5432");
//    this.txtPort.addActionListener(new ActionListener()
//    {
//      public void actionPerformed(ActionEvent evt)
//      {
//        MainFrame2.this.txtPortActionPerformed(evt);
//      }
//    });
//    this.txtUser.setText("postgres");
//    
//    this.txtIP.setText("localhost");
//    
//    this.jLabel1.setText("Host Dbase");
//    
//    this.jLabel2.setText("Port");
//    
//    this.btnPing.setText("Ping Host");
//    this.btnPing.addActionListener(new ActionListener()
//    {
//      public void actionPerformed(ActionEvent evt)
//      {
//        MainFrame2.this.btnPingActionPerformed(evt);
//      }
//    });
//    this.jLabel3.setText("Username");
//    
//    this.jLabel4.setText("Password");
//    
//    this.txtPswd.setText("admin");
//    
//    this.jLabel5.setForeground(new Color(255, 51, 51));
//    this.jLabel5.setText("( Hanya Untuk Dbase Postgre )");
//    
//    this.txtDbase.setText("db_absensi");
//    
//    this.jLabel6.setText("Database");
//    
//    this.txtStatus.setBackground(new Color(153, 153, 0));
//    this.txtStatus.setFont(new Font("Tahoma", 1, 16));
//    this.txtStatus.setForeground(new Color(255, 255, 255));
//    this.txtStatus.setText("   Standby");
//    this.txtStatus.setAlignmentY(2.0F);
//    this.txtStatus.setOpaque(true);
//    
//    this.jLabel7.setText("Webservice");
//    
//    this.txtUrl.setText("https://erp.sinergi-informatika.com/ws/forca/hr/insertattendancelog");
//    this.txtUrl.addActionListener(new ActionListener()
//    {
//      public void actionPerformed(ActionEvent evt)
//      {
//        MainFrame2.this.txtUrlActionPerformed(evt);
//      }
//    });
//    this.btnClear.setText("Clear");
//    this.btnClear.addActionListener(new ActionListener()
//    {
//      public void actionPerformed(ActionEvent evt)
//      {
//        MainFrame2.this.btnClearActionPerformed(evt);
//      }
//    });
//    this.jLabel8.setText("Location Mdb");
//    
//    this.txtUrlMdb.setText("C:/Program Files (x86)/Att/att2000.mdb");
//    this.txtUrlMdb.addActionListener(new ActionListener()
//    {
//      public void actionPerformed(ActionEvent evt)
//      {
//        MainFrame2.this.txtUrlMdbActionPerformed(evt);
//      }
//    });
//    this.jLabel9.setText("User Ws");
//    
//    this.jLabel10.setText("Pswd Ws");
//    
//    this.txtUserWs.setText("sisiwebservice");
//    
//    this.txtPswdWs.setText("kecoakbunting");
//    
//    this.jLabel11.setText("Schema");
//    
//    this.txtSchema.setText("forcahris");
//    
//    this.jLabel12.setText("Loop Schedule");
//    
//    this.txtSleep.setText("5");
//    
//    this.jLabel13.setText("Minutes");
//    
//    GroupLayout layout = new GroupLayout(getContentPane());
//    getContentPane().setLayout(layout);
//    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(30, 30, 30).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel10).addComponent(this.jLabel9).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 346, 32767).addComponent(this.txtStatus, -2, 93, -2)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.btnStart).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnEnd).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.btnClear).addGap(36, 36, 36).addComponent(this.btnPing)).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING, -2, 513, -2)).addGap(3, 3, 3)).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel4).addComponent(this.jLabel3).addComponent(this.jLabel6).addComponent(this.jLabel2)).addGap(48, 48, 48).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtIP, -2, 206, -2).addComponent(this.txtDbase, -2, 202, -2).addGroup(layout.createSequentialGroup().addComponent(this.txtPort, -2, 65, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel5)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.txtPswd, GroupLayout.Alignment.LEADING, -1, 148, 32767).addComponent(this.txtUser, GroupLayout.Alignment.LEADING)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.jLabel11).addGap(18, 18, 18).addComponent(this.txtSchema, -2, -1, -2)).addGroup(layout.createSequentialGroup().addComponent(this.jLabel12).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtSleep))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel13)))).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel8).addComponent(this.jLabel7)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txtUrl, -2, 1, 32767).addComponent(this.txtUrlMdb, -1, 394, 32767).addComponent(this.txtPswdWs, -1, 394, 32767).addComponent(this.txtUserWs)))).addGap(10, 10, 10)))).addContainerGap(29, 32767)));
//    
//    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(16, 16, 16).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.txtIP, -2, -1, -2).addComponent(this.txtStatus)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtPort, -2, -1, -2).addComponent(this.jLabel5).addComponent(this.jLabel2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtDbase, -2, -1, -2).addComponent(this.jLabel6)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtUser, -2, -1, -2).addComponent(this.jLabel3).addComponent(this.jLabel11).addComponent(this.txtSchema, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtPswd, -2, -1, -2).addComponent(this.jLabel4).addComponent(this.jLabel12).addComponent(this.txtSleep, -2, -1, -2).addComponent(this.jLabel13)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtUrlMdb, -2, -1, -2).addComponent(this.jLabel8)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtUrl, -2, -1, -2).addComponent(this.jLabel7)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel9).addComponent(this.txtUserWs, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel10).addComponent(this.txtPswdWs, -2, -1, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnStart).addComponent(this.btnEnd).addComponent(this.btnPing).addComponent(this.btnClear)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 346, -2).addGap(31, 31, 31)));
//    
//    pack();
//  }
//  
//  private void btnEndActionPerformed(ActionEvent evt)
//  {
//    this.standardOut.println("Stop Thread");
//    this.listener.exitThread(true);
//    this.wsThread.exitThread(true);
//    this.listener.interrupt();
//    this.wsThread.interrupt();
//    
//    statusStopped();
//  }
//  
//  private void btnStartActionPerformed(ActionEvent evt)
//  {
//    this.username = this.txtUser.getText();
//    this.password = this.txtPswd.getText();
//    this.host = this.txtIP.getText();
//    this.xport = this.txtPort.getText();
//    this.dbase = this.txtDbase.getText();
//    
//    String fileName = this.txtUrlMdb.getText();
//    if ((this.username.isEmpty()) || (this.password.isEmpty()) || (this.host.isEmpty()) || (this.xport.isEmpty()) || (this.dbase.isEmpty()))
//    {
//      System.out.println("Parameter Harus Diisi semua");
//    }
//    else
//    {
//      statusRunning();
//      try
//      {
//        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//        String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + fileName.trim() + ";DriverID=22;READONLY=true}";
//        try
//        {
//          this.mdbConn = DriverManager.getConnection("jdbc:ucanaccess://" + fileName.trim());
//        }
//        catch (SQLException ex)
//        {
//          Logger.getLogger(MainFrame2.class.getName()).log(Level.SEVERE, null, ex);
//          statusStopped();
//        }
//      }
//      catch (ClassNotFoundException ex)
//      {
//        Logger.getLogger(MainFrame2.class.getName()).log(Level.SEVERE, null, ex);
//        statusStopped();
//      }
//      try
//      {
//        Class.forName("org.postgresql.Driver");
//      }
//      catch (ClassNotFoundException ex)
//      {
//        Logger.getLogger(MainFrame2.class.getName()).log(Level.SEVERE, null, ex);
//        statusStopped();
//      }
//      String url = "jdbc:postgresql://" + this.host + ":" + this.xport + "/" + this.dbase;
//      try
//      {
//        this.pgConn = ((PGConnection)DriverManager.getConnection(url, this.username, this.password));
//      }
//      catch (SQLException ex)
//      {
//        Logger.getLogger(MainFrame2.class.getName()).log(Level.SEVERE, null, ex);
//        statusStopped();
//      }
//      try
//      {
//        this.listener = new ThreadSql(this.mdbConn, this.pgConn);
//        this.wsThread = new ThreadWebservice(this.pgConn);
//      }
//      catch (SQLException ex)
//      {
//        Logger.getLogger(MainFrame2.class.getName()).log(Level.SEVERE, null, ex);
//        statusStopped();
//      }
//      this.listener.start();
//      
//      this.listener.Tsleep = Integer.valueOf(Integer.parseInt(this.txtSleep.getText()));
//      this.wsThread.start();
//      this.wsThread.urlws = this.txtUrl.getText();
//      this.wsThread.userWs = this.txtUserWs.getText();
//      this.wsThread.pswdWs = this.txtPswdWs.getText();
//      this.wsThread.strSchema = this.txtSchema.getText();
//    }
//  }
//  
//  private void btnPingActionPerformed(ActionEvent evt)
//  {
//    if (this.txtIP.getText().equals("")) {
//      System.out.println("Please insert valid IP Address bro..");
//    } else {
//      runSystemCommand("ping " + this.txtIP.getText());
//    }
//  }
//  
//  private void txtPortActionPerformed(ActionEvent evt) {}
//  
//  private void txtUrlActionPerformed(ActionEvent evt) {}
//  
//  private void btnClearActionPerformed(ActionEvent evt)
//  {
//    try
//    {
//      this.txtOutput.getDocument().remove(0, this.txtOutput.getDocument().getLength());
//    }
//    catch (BadLocationException ex)
//    {
//      Logger.getLogger(MainFrame2.class.getName()).log(Level.SEVERE, null, ex);
//    }
//  }
//  
//  private void txtUrlMdbActionPerformed(ActionEvent evt) {}
//  
//  public static void main(String[] args)
//  {
//    try
//    {
//      for (UIManager.LookAndFeelInfo info : ) {
//        if ("Nimbus".equals(info.getName()))
//        {
//          UIManager.setLookAndFeel(info.getClassName());
//          break;
//        }
//      }
//    }
//    catch (ClassNotFoundException ex)
//    {
//      Logger.getLogger(MainFrame2.class.getName()).log(Level.SEVERE, null, ex);
//    }
//    catch (InstantiationException ex)
//    {
//      Logger.getLogger(MainFrame2.class.getName()).log(Level.SEVERE, null, ex);
//    }
//    catch (IllegalAccessException ex)
//    {
//      Logger.getLogger(MainFrame2.class.getName()).log(Level.SEVERE, null, ex);
//    }
//    catch (UnsupportedLookAndFeelException ex)
//    {
//      Logger.getLogger(MainFrame2.class.getName()).log(Level.SEVERE, null, ex);
//    }
//    EventQueue.invokeLater(new Runnable()
//    {
//      public void run()
//      {
//        new MainFrame2().setVisible(true);
//      }
//    });
//  }
//  
//  private void runSystemCommand(String command)
//  {
//    try
//    {
//      Process p = Runtime.getRuntime().exec(command);
//      BufferedReader inputStream = new BufferedReader(new InputStreamReader(p.getInputStream()));
//      
//      String s = "";
//      while ((s = inputStream.readLine()) != null) {
//        System.out.println(s);
//      }
//    }
//    catch (Exception e)
//    {
//      System.out.println(e);
//    }
//  }
//  
//  private void statusStopped()
//  {
//    this.txtStatus.setText("   Stopped");
//    this.txtStatus.setForeground(Color.WHITE);
//    this.txtStatus.setBackground(Color.RED);
//  }
//  
//  private void statusRunning()
//  {
//    this.txtStatus.setText("   Running");
//    this.txtStatus.setForeground(Color.RED);
//    this.txtStatus.setBackground(Color.YELLOW);
//  }
//  
//  private void statusPing()
//  {
//    this.txtStatus.setText("   Pinging");
//    this.txtStatus.setForeground(Color.WHITE);
//    this.txtStatus.setBackground(Color.ORANGE);
//  }
//  
//  public String getDateNow()
//  {
//    return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
//  }
}
