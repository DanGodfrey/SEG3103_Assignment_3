
package MarketDB;
import java.sql.ResultSet;

public class Transaction {
  public long code;
  public long employee;
  public long customer;
  public boolean open;
  Transaction(long t, long e, long c){
    code = t;
    employee = e;
    customer = c;
    open = true;
  }
  Transaction(ResultSet rs) throws java.sql.SQLException {
    code = rs.getLong("ID");
    employee = rs.getInt("employee");
    customer = rs.getInt("customer");
    open = rs.getInt("is_open")!=0;
  }
}