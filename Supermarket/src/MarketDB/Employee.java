
package MarketDB;
import java.sql.ResultSet;

public class Employee {
  public long code;
  public String name;
  public String password;
  Employee(long c, String n, String p){
    code = c;
    name = n;
    password = p;
  }
  Employee(ResultSet rs) throws java.sql.SQLException {
    code = rs.getLong("ID");
    name = rs.getString("name");
    password = rs.getString("password");
  }
}