
package MarketDB;

public interface DBManager {
  Item getItem(long code);
  Employee getEmployee(long code);
  Customer getCustomer(long code);
  long startTransaction(long customer, long employee) throws Exception;
  void abortTransaction(long code) throws Exception;
  void closeTransaction(long code) throws Exception;
  void buy(long item, long quantity, long transaction) throws Exception;
}