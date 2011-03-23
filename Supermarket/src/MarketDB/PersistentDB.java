
package MarketDB;

import java.sql.*;
import java.util.Vector;

public class PersistentDB implements DBManager {
  private String connection;

  public PersistentDB(){
  	try { Class.forName("org.apache.derby.jdbc.EmbeddedDriver"); } catch (ClassNotFoundException e1) {	}
    connection = "jdbc:derby:SuperMarket";
  }

  public PersistentDB(String connection){
  	try { Class.forName("org.apache.derby.jdbc.EmbeddedDriver"); } catch (ClassNotFoundException e1) {	}
    connection = "jdbc:derby:SuperMarket";
  }

  ResultSet select(String query) throws SQLException {
    Connection conn = DriverManager.getConnection(connection);
    Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
    return stmt.executeQuery(query);
  }

  public Item getItem(long code) {
  	Item i = null;
    try{
    	ResultSet rs = select("SELECT * FROM ITEM WHERE ID=" + code);
    	if(rs.next()){
    		i = new Item(rs);
    	}
    	rs.close();
    }catch(Exception e){}
    return i;
  }
  public Employee getEmployee(long code) {
  	Employee e = null;
    try{
    	ResultSet rs = select("SELECT * FROM EMPLOYEE WHERE ID=" + code);
    	if(rs.next()){
    		e = new Employee(rs);
    	}
    	rs.close();
    }catch(Exception ex){
      ex.printStackTrace();
    }
    return e;
  }
  public Customer getCustomer(long code) {
	Customer c=null;
    try{
		ResultSet rs = select("SELECT * FROM CUSTOMER WHERE ID=" + code);
    	if(rs.next()){
    		c = new Customer(rs);
    	}
    	rs.close();
    }catch(Exception e){}
	return c;
  }


  Vector connections = new Vector();
  public long startTransaction(long customer, long employee) throws Exception {
    Connection conn = DriverManager.getConnection(connection);
    conn.setAutoCommit(false);
    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = stmt.executeQuery("SELECT MAX(ID) AS M FROM TRANS");
    long code;
    if(rs.next()){
      code = rs.getLong("M")+1;
    }else{
      code = 1;
    }
    stmt.executeUpdate("INSERT INTO TRANS (ID,employee,customer,is_open) " +
                       "VALUES (" + code + ", " + employee + ", " +
                       customer + ", 1)");
    conn.commit();
    return code;
  }

  public void abortTransaction(long code) throws Exception {
    Connection conn = DriverManager.getConnection(connection);
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM TRANS WHERE ID=" + code);
    Transaction trans=null;
    if(rs.next()){
     trans = new Transaction(rs);
    }
    if(trans==null) throw new Exception("Transaction non existent");
    if(!trans.open) throw new Exception("Transaction is closed");
    stmt.executeUpdate("DELETE FROM TRANS WHERE ID=" + code);
  }
  public void closeTransaction(long code) throws Exception {
    Connection conn = DriverManager.getConnection(connection);
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM TRANS WHERE ID=" + code);
    Transaction trans=null;
    if(rs.next()){
     trans = new Transaction(rs);
    }
    if(trans==null) throw new Exception("Transaction non existent");
    if(!trans.open) throw new Exception("Transaction is closed");
    stmt.executeUpdate("UPDATE TRANS SET is_open=0 WHERE ID=" + code);
  }

  public void buy(long code, long quantity, long transaction) throws Exception {
//  	System.setProperty("derby.locks.deadlockTimeout","5");
//  	System.setProperty("derby.locks.waitTimeout","10");
    Connection conn = DriverManager.getConnection(connection);
    conn.setAutoCommit(false);
    Statement stmt = conn.createStatement();
    ResultSet rs;
//    conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
    Transaction t;
    try{
      rs=stmt.executeQuery("SELECT * FROM TRANS WHERE ID=" + transaction);
      if(rs.next()){
        t = new Transaction(rs);
      }else throw new Exception("Transaction non existent");
      rs.close();
      stmt.executeUpdate("UPDATE ITEM SET QUANTITY=QUANTITY - " + quantity +
            " WHERE ID=" + code);
      rs = stmt.executeQuery("SELECT MAX(ID) AS M FROM ACQUISITION");
      long acq_code;
      if(rs.next()){
        acq_code = rs.getLong("M") + 1;
      }else{
        acq_code = 1;
      }
      rs.close();
      stmt.executeUpdate("INSERT INTO ACQUISITION (ID,TRANS,ITEM,QUANTITY) " +
                         "VALUES ( " + acq_code + ", " + transaction + ", " +
                       code + ", " + quantity +")");
      conn.commit();
    }catch(Exception e){
      e.printStackTrace();
      conn.rollback();
      throw e;
    }
  }
}