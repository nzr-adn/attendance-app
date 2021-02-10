package com.absen.backend;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.JSONObject;
import org.postgresql.PGConnection;

public class ThreadWebservice
  extends Thread
{
  private Connection conn;
  public volatile boolean exitWebserv = false;
  public volatile String urlws = "";
  public String userWs = "";
  public String pswdWs = "";
  public String strSchema = "forcahris";
  public Integer Tsleep = Integer.valueOf(5);
  
  public ThreadWebservice(PGConnection pgconn)
    throws SQLException
  {
    this.conn = ((Connection)pgconn);
    this.conn.setSchema(this.strSchema);
  }
  
  public void run()
  {
    System.out.println("--- Thread Webservice Started " + new Date() + " ---");
    while (!this.exitWebserv) {
      try
      {
        Statement stmt = this.conn.createStatement();
        stmt.execute("select * from attendance where send_flag=0");
        ResultSet rs = stmt.getResultSet();
        while (rs.next())
        {
          Map<String, Object> map = new LinkedHashMap();
          map.put("id", rs.getString("ID"));
          map.put("nik", rs.getString("NIK"));
          map.put("checktime", rs.getString("DATETIME"));
          map.put("ip", rs.getString("IP"));
          map.put("attstate", rs.getString("ATTSTATE"));
          map.put("verifymethod", rs.getString("VERIFYMETHOD"));
          map.put("workcode", rs.getString("WORKCODE"));
          sendToWebService(map);
        }
        stmt.close();
        rs.close();
        
        Thread.sleep(60000 * this.Tsleep.intValue());
      }
      catch (SQLException sqle)
      {
        sqle.printStackTrace();
      }
      catch (InterruptedException ie)
      {
        Thread.currentThread().interrupt();
      }
    }
    System.out.println("--- Thread Webservice Stopped " + new Date() + " ---");
  }
  
  public void exitThread(boolean TExit)
  {
    this.exitWebserv = TExit;
  }
  
  public void sendToWebService(Map<String, Object> param)
  {
    System.out.println("\n<< Call Webservice " + new Date() + " >>");
    if (param.size() > 0) {
      try
      {
        String idne = (String)param.get("id");
        JSONObject jsparam = new JSONObject();
        jsparam.put("username", this.userWs);
        jsparam.put("password", this.pswdWs);
        jsparam.put("enrollnumber", param.get("nik"));
        jsparam.put("datelog", param.get("checktime"));
        jsparam.put("ip_address", param.get("ip"));
        jsparam.put("attstate", param.get("attstate"));
        jsparam.put("verifymode", param.get("verifymethod"));
        jsparam.put("workcode", param.get("workcode"));
        jsparam.put("inoutmode", "");
        
        System.out.println("Request : " + jsparam.toString());
        System.out.println("urlws : " + this.urlws);
        
        TrustManager[] trustAllCerts = { new X509TrustManager()
        {
          public X509Certificate[] getAcceptedIssuers()
          {
            return null;
          }
          
          public void checkClientTrusted(X509Certificate[] xcs, String string)
            throws CertificateException
          {}
          
          public void checkServerTrusted(X509Certificate[] xcs, String string)
            throws CertificateException
          {}
        } };
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        
        HostnameVerifier allHostsValid = new HostnameVerifier()
        {
          public boolean verify(String hostname, SSLSession session)
          {
            return true;
          }
        };
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        
        URL url = new URL(this.urlws);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);
        con.getOutputStream().write(jsparam.toString().getBytes("UTF-8"));
        con.getInputStream();
        
        int responseCode = con.getResponseCode();
        System.out.println("HTTP Response Code :: " + responseCode);
        if (responseCode == 200)
        {
          BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
          
          StringBuffer response = new StringBuffer();
          String inputLine;
          while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
          }
          in.close();
          
          System.out.println(response.toString());
          JSONObject datars = new JSONObject(response.toString());
          
          String err = datars.getString("error");
          if (err.equals("S"))
          {
            System.out.println("Sukses webservice " + idne);
            Statement st = this.conn.createStatement();
            st.execute("update attendance set send_flag=1 where id=" + idne);
            st.close();
          }
          else
          {
            System.out.println("cannot update flag " + idne);
          }
        }
        else
        {
          System.out.println("Http request not worked");
        }
      }
      catch (Exception e)
      {
        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, e);
      }
    }
    System.out.println("<< End All Data Webservice " + new Date() + " >>\n");
  }
  
  public String getDateNow()
  {
    return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
  }
  
  public String getHourNow()
  {
    DateFormat dateFormat = new SimpleDateFormat("HH");
    Calendar cal = Calendar.getInstance();
    
    return dateFormat.format(cal.getTime()).toString();
  }
  
  public String getLastDate()
  {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Calendar cal = Calendar.getInstance();
    cal.add(5, -1);
    return dateFormat.format(cal.getTime()).toString();
  }
  
  public String getNextDate()
  {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Calendar cal = Calendar.getInstance();
    cal.add(5, 1);
    return dateFormat.format(cal.getTime()).toString();
  }
  
  public String whereWaktu()
  {
    String were = "";
    Integer jam = Integer.valueOf(Integer.parseInt(getHourNow()));
    if (jam.intValue() == 0) {
      were = "AND cek.CHECKTIME BETWEEN '" + getLastDate() + " 23:00:00' AND '" + getDateNow() + " " + String.format("%02d", new Object[] { Integer.valueOf(jam.intValue() + 1) }) + ":00:00'";
    } else if (jam.intValue() == 23) {
      were = "AND cek.CHECKTIME BETWEEN '" + getDateNow() + " " + String.format("%02d", new Object[] { Integer.valueOf(jam.intValue() - 1) }) + ":00:00' AND '" + getDateNow() + " " + String.format("%02d", new Object[] { jam }) + ":59:59'";
    } else {
      were = "AND cek.CHECKTIME BETWEEN '" + getDateNow() + " " + String.format("%02d", new Object[] { Integer.valueOf(jam.intValue() - 1) }) + ":00:00' AND '" + getDateNow() + " " + String.format("%02d", new Object[] { Integer.valueOf(jam.intValue() + 1) }) + ":00:00'";
    }
    return were;
  }
}
