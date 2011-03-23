
package MarketDB;
import java.sql.*;

public class Customer {
  public long code;
  public String name;
  Customer(long c, String n){
    code = c;
    name = n;
  }
  Customer(ResultSet rs) throws java.sql.SQLException {
    code = rs.getLong("ID");
    name = rs.getString("name");
  }
}