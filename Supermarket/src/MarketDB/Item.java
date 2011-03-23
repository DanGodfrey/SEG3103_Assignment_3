
package MarketDB;
import java.sql.ResultSet;

public class Item {
  public long code;
  public String name;
  public double price;
  public long quantity;
  Item(long c, String n, double p, long q){
    code = c;
    name = n;
    price = p;
    quantity = q;
  }
  Item(ResultSet rs) throws java.sql.SQLException {
    code = rs.getLong("ID");
    name = rs.getString("name");
    price = rs.getDouble("price");
    quantity = rs.getInt("quantity");
  }
}