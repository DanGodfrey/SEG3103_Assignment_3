
package Market;
import MarketDB.*;

public class BasicServer
implements Market {
  DBManager dbm;
  public BasicServer(DBManager db) {
    dbm = db;
    MarketServer.setInstance(this);
  }
  public String getName(long code){
    Item it = dbm.getItem(code);
    if(it==null) return null;
    return it.name;
  }
  public double getPrice(long code){
    Item it = dbm.getItem(code);
    if(it==null) return -1;
    return it.price;
  }
  public String getCustomer(long code){
    Customer customer = dbm.getCustomer(code);
    if(customer==null) return null;
    return customer.name;
  }
  public String authenticate(long code, String password){
    Employee employee=dbm.getEmployee(code);
    if(employee!=null && employee.password.equals(password)){
      return employee.name;
    }
    return null;
  }
  public long startTransaction(long customer, long employee) throws Exception {
    return dbm.startTransaction(customer, employee);
  }
  public void buy(long item, long quantity, long transaction) throws Exception {
    dbm.buy(item,quantity,transaction);
  }
  public void endTransaction(long transaction) throws Exception  {
    dbm.closeTransaction(transaction);
  }
  public void abortTransaction(long code) throws Exception{
    dbm.abortTransaction(code);
  }
}