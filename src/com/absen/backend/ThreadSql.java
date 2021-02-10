package com.absen.backend;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.postgresql.PGConnection;

public class ThreadSql
  extends Thread
{
  private Connection conn = null;
  private Connection pgconn = null;
  public volatile boolean exitListen = false;
  public String urlMdb = "";
  public String userPg = "";
  public String pswdPg = "";
  public String databasePg = "";
  public Integer Tsleep = Integer.valueOf(5);
  public String strSchema = "forcahris";
  public Integer iter = 0;
  
  public ThreadSql() {}
  
  public ThreadSql(Connection conn, PGConnection pgconn)
    throws SQLException
  {
    this.conn = conn;
    this.pgconn = ((Connection)pgconn);
  }
  
  public void run()
  {
    System.out.println("--- Thread For Mdb Started " + new Date() + " ---");
    
    while (!this.exitListen) {
      try
      {
        Statement st = this.conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT CEK.*,msn.IP,msn.MACHINEALIAS,usr.Badgenumber,usr.name FROM CHECKINOUT CEK LEFT JOIN MACHINES msn ON msn.Machinenumber = CEK.SENSORID LEFT JOIN USERINFO usr ON usr.USERID = CEK.USERID WHERE cek.userid Is Not NULL " + whereWaktu() + ";");
        iter++;
        List<Object> resultdata = new ArrayList();
        while (rs.next())
        {
          Map<String, Object> map = new LinkedHashMap();
          map.put("nik", rs.getString("Badgenumber"));
          map.put("checktime", rs.getString("CHECKTIME"));
          map.put("ip", rs.getString("IP"));
          map.put("attstate", "0");
          map.put("verifymethod", rs.getString("VERIFYCODE"));
          map.put("workcode", rs.getString("WorkCode"));
          resultdata.add(map);
        }
        System.out.println("masuk Thread" + iter);
//        insertToPostgre(resultdata);
        
        st.close();
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
    System.out.println("--- Thread For Mdb Stopped " + new Date() + " ---");
  }
  
  public void exitThread(boolean TExit)
  {
    this.exitListen = TExit;
  }
  
  public void insertToPostgre(List<Object> list)
    throws SQLException
  {
    for (int i = 0; i < list.size(); i++)
    {
      Map<String, Object> map = new LinkedHashMap();
      map = (Map)list.get(i);
      String nik = map.get("nik").toString();
      String checktime = map.get("checktime").toString();
      String ip = map.get("ip").toString();
      String attstate = map.get("attstate").toString();
      String verify = map.get("verifymethod").toString();
      String workcode = map.get("workcode").toString();
      
      String sql = "INSERT INTO attendance (nik,datetime,ip,attstate,verifymethod,workcode) SELECT '" + nik + "', '" + checktime + "','" + ip + "','" + attstate + "','" + verify + "','" + workcode + "' " + "WHERE NOT EXISTS (" + " SELECT id FROM attendance WHERE nik = '" + nik + "' and datetime = '" + checktime + "' );";
      try
      {
        this.pgconn.setSchema(this.strSchema);
        Statement pgstmt = this.pgconn.createStatement();
        
        boolean pgrslt = pgstmt.execute(sql);
        if (pgrslt) {
          System.out.println("sukses insert pgsql " + nik);
        }
        pgstmt.close();
      }
      catch (Exception e)
      {
        e = 
        
          e;System.out.println("Error Pgsql : " + e.getMessage());
      }
      finally {}
    }
    System.out.println("insert if exist to table attendance Total : " + list.size() + " on " + new Date() + "\n");
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
