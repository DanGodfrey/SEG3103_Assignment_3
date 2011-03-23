
package Market;

public interface Market {
  public String getName(long item);
  public double getPrice(long item);
  public String getCustomer(long customer);
  public String authenticate(long employee, String password);
  public long startTransaction(long customer, long employee) throws Exception;
  public void buy(long item, long quantity, long transaction) throws Exception;
  public void endTransaction(long transaction) throws Exception;
  public void abortTransaction(long transaction) throws Exception;
}

