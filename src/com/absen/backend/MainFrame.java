/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.absen.backend;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.text.BadLocationException;

import org.postgresql.PGConnection;

/**
 *
 * @author Lenovo
 */
public class MainFrame extends javax.swing.JFrame {

	private PrintStream standardOut;
	Connection mdbConn;
	PGConnection pgConn;
	ThreadSql listener;
	ThreadWebservice wsThread;
	String username;
	String password;
	String host;
	String xport;
	String dbase;

	/**
	 * Creates new form MainFrame
	 */
	public MainFrame() {

		initComponents();
		PrintStream printStream = new PrintStream(new CustomOutputStream(this.txtOutput));

		this.standardOut = System.out;

		System.setOut(printStream);
		System.setErr(printStream);

		setDefaultCloseOperation(3);
//      Image i = ImageIO.read(getClass().getResource("/loadfull.png"));
//      setIconImage(i);

		setLocationRelativeTo(null);

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		txtIP = new javax.swing.JTextField();
		txtPort = new javax.swing.JTextField();
		txtDbase = new javax.swing.JTextField();
		txtUser = new javax.swing.JTextField();
		txtPswd = new javax.swing.JTextField();
		txtSchema = new javax.swing.JTextField();
		txtUrlMdb = new javax.swing.JTextField();
		txtUrl = new javax.swing.JTextField();
		txtUserWs = new javax.swing.JTextField();
		txtPswdWs = new javax.swing.JTextField();
		btnStart = new javax.swing.JButton();
		btnEnd = new javax.swing.JButton();
		btnClear = new javax.swing.JButton();
		btnPing = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		txtOutput = new javax.swing.JTextArea();
		txtSleep = new javax.swing.JTextField();
		txtStatus = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();

		txtIP.setText("127.0.0.1");

		txtPort.setText("5432");

		txtDbase.setText("attendance");

		txtUser.setText("postgres");

		txtPswd.setText("password");

		txtSchema.setText("public");

		txtUrlMdb.setText("");

		txtUrl.setText("");

		txtUserWs.setText("");

		txtPswdWs.setText("");

		btnStart.setText("Start");
		btnStart.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btnStartActionPerformed(evt);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		btnEnd.setText("Stop");
		btnEnd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnEndActionPerformed(evt);
			}
		});

		btnClear.setText("Clear");
		btnClear.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnClearActionPerformed(evt);
			}
		});

		btnPing.setText("Ping Host");
		btnPing.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnPingActionPerformed(evt);
			}
		});

		txtOutput.setColumns(20);
		txtOutput.setRows(5);
		jScrollPane1.setViewportView(txtOutput);

		txtSleep.setText("30");

		txtStatus.setText("txtStatus");

		jLabel1.setText("Host Database");

		jLabel2.setText("Port");

		jLabel3.setText("Nama Db");

		jLabel4.setText("User DB");

		jLabel5.setText("Pass DB");

		jLabel6.setText("Loop Schedule");

		jLabel7.setText("Path MDB");

		jLabel8.setText("Link Api");

		jLabel9.setText("User API");

		jLabel10.setText("Password API");

		jLabel11.setText("Schema");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(31, 31, 31)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 562,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(btnStart).addComponent(jLabel1).addComponent(jLabel2)
										.addComponent(jLabel3).addComponent(jLabel4).addComponent(jLabel5)
										.addComponent(jLabel7).addComponent(jLabel8).addComponent(jLabel9)
										.addComponent(jLabel10))
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addGap(18, 18, 18).addComponent(btnEnd)
												.addGap(144, 144, 144).addComponent(btnClear).addGap(31, 31, 31)
												.addComponent(btnPing).addGap(44, 44, 44))
										.addGroup(layout.createSequentialGroup().addGap(57, 57, 57).addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup().addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE,
																245, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(txtUrlMdb).addComponent(txtUrl)
														.addComponent(txtUserWs).addComponent(txtPswdWs))
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(txtStatus))
												.addGroup(layout.createSequentialGroup().addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(txtDbase, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(layout.createSequentialGroup()
																.addGroup(layout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(txtPswd,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(txtUser,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(110, 110, 110)
																.addGroup(layout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																		.addGroup(layout.createSequentialGroup()
																				.addComponent(jLabel11)
																				.addGap(61, 61, 61)
																				.addComponent(txtSchema,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGroup(layout.createSequentialGroup()
																				.addComponent(jLabel6)
																				.addGap(26, 26, 26)
																				.addComponent(txtSleep,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)))))
														.addGap(0, 0, Short.MAX_VALUE)))))))
				.addGap(47, 71, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jLabel2)
						.addGroup(layout.createSequentialGroup().addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel1).addComponent(txtStatus))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(txtDbase, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel3))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSchema, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel4).addComponent(jLabel11))
				.addGap(7, 7, 7)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(txtPswd, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSleep, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel5).addComponent(jLabel6))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(txtUrlMdb, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel7))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(txtUrl, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel8))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(txtUserWs, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel9))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(txtPswdWs, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel10))
				.addGap(27, 27, 27)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(btnStart)
						.addComponent(btnEnd).addComponent(btnClear).addComponent(btnPing))
				.addGap(18, 18, 18)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
				.addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void btnStartActionPerformed(java.awt.event.ActionEvent evt) throws Exception {// GEN-FIRST:event_btnStartActionPerformed
		this.username = this.txtUser.getText();
		this.password = this.txtPswd.getText();
		this.host = this.txtIP.getText();
		this.xport = this.txtPort.getText();
		this.dbase = this.txtDbase.getText();

		String fileName = this.txtUrlMdb.getText();
		if ((this.username.isEmpty()) || (this.password.isEmpty()) || (this.host.isEmpty()) || (this.xport.isEmpty())
				|| (this.dbase.isEmpty())) {
			System.out.println("Parameter Harus Diisi semua");
		} else {
//			statusRunning();
			System.out.println("Run ...... ");
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//				String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + fileName.trim()
//						+ ";DriverID=22;READONLY=true}";
				System.out.println("Connecting to Microsoft Access");
				this.mdbConn = DriverManager.getConnection("jdbc:ucanaccess://" + fileName + ";memory=false");
				System.out.println("Microsoft Access Connected");
			} catch (Exception ex) {
//				Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//				statusStopped();
				ex.printStackTrace();
				return;
			}
			
			try {
				Class.forName("org.postgresql.Driver");
				String url = "jdbc:postgresql://" + this.host + ":" + this.xport + "/" + this.dbase;
				System.out.println("Connecting to PostgreSql");
				this.pgConn = ((PGConnection) DriverManager.getConnection(url, this.username, this.password));
				System.out.println("PostgreSql Connected");
			} catch (Exception ex) {
//				Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//				statusStopped();
				ex.printStackTrace();
				return;
			}
			try {
				System.out.println("Execute SQL");
				this.listener = new ThreadSql(this.mdbConn, this.pgConn);
				System.out.println("Execute Web Service");
				this.wsThread = new ThreadWebservice(this.pgConn);
			} catch (Exception ex) {
//				Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//				statusStopped();
				ex.printStackTrace();
			}
			this.listener.start();

			this.listener.Tsleep = Integer.valueOf(Integer.parseInt(this.txtSleep.getText()));
//          this.wsThread.start();
//          this.wsThread.urlws = this.txtUrl.getText();
//          this.wsThread.userWs = this.txtUserWs.getText();
//          this.wsThread.pswdWs = this.txtPswdWs.getText();
//          this.wsThread.strSchema = this.txtSchema.getText();
		}
	}// GEN-LAST:event_btnStartActionPerformed

	private void btnEndActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEndActionPerformed
		this.standardOut.println("Stop Thread");
		this.listener.exitThread(true);
		this.wsThread.exitThread(true);
		this.listener.interrupt();
		this.wsThread.interrupt();

		statusStopped();
	}// GEN-LAST:event_btnEndActionPerformed

	private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnClearActionPerformed
		try {
			this.txtOutput.getDocument().remove(0, this.txtOutput.getDocument().getLength());
		} catch (BadLocationException ex) {
			Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}// GEN-LAST:event_btnClearActionPerformed

	private void btnPingActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnPingActionPerformed
		if (this.txtIP.getText().equals("")) {
			System.out.println("Please insert valid IP Address bro..");
		} else {
			runSystemCommand("ping " + this.txtIP.getText());
		}
	}// GEN-LAST:event_btnPingActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				// new MainFrame().setVisible(true);
				new Login().setVisible(true);
			}
		});
	}

	private void runSystemCommand(String command) {
		try {
			Process p = Runtime.getRuntime().exec(command);
			BufferedReader inputStream = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String s = "";
			while ((s = inputStream.readLine()) != null) {
				System.out.println(s);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void statusStopped() {
		this.txtStatus.setText("   Stopped");
		this.txtStatus.setForeground(Color.WHITE);
		this.txtStatus.setBackground(Color.RED);
	}

	private void statusRunning() {
		this.txtStatus.setText("   Running");
		this.txtStatus.setForeground(Color.RED);
		this.txtStatus.setBackground(Color.YELLOW);
	}

	private void statusPing() {
		this.txtStatus.setText("   Pinging");
		this.txtStatus.setForeground(Color.WHITE);
		this.txtStatus.setBackground(Color.ORANGE);
	}

	public String getDateNow() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnClear;
	private javax.swing.JButton btnEnd;
	private javax.swing.JButton btnPing;
	private javax.swing.JButton btnStart;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextField txtDbase;
	private javax.swing.JTextField txtIP;
	private javax.swing.JTextArea txtOutput;
	private javax.swing.JTextField txtPort;
	private javax.swing.JTextField txtPswd;
	private javax.swing.JTextField txtPswdWs;
	private javax.swing.JTextField txtSchema;
	private javax.swing.JTextField txtSleep;
	private javax.swing.JLabel txtStatus;
	private javax.swing.JTextField txtUrl;
	private javax.swing.JTextField txtUrlMdb;
	private javax.swing.JTextField txtUser;
	private javax.swing.JTextField txtUserWs;
	// End of variables declaration//GEN-END:variables
}
