
package Counter;

public interface MarketProxy {
  public String connect(long employee, String password) throws Exception;

  public String getName(long item) throws Exception ;
  public double getPrice(long item) throws Exception ;

  public String getCustomer(long code) throws Exception;

  public void startTransaction(long customer, long employee) throws Exception;
  public void buy(long item, long quantity) throws Exception;
  public void endTransaction() throws Exception;
  public void abortTransaction() throws Exception;

  public void disconnect();
}

