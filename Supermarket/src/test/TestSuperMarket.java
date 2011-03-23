
package test;
import CounterUI.BarCodeReaderUI;
import CounterUI.CounterFrame;
import Market.BasicServer;
import Market.MarketServer;
import Counter.SocketProxy;
import MarketDB.PersistentDB;

public class TestSuperMarket {
  @SuppressWarnings({ "deprecation", "unused" })
public static void main(String [] args) {
    CounterFrame counter = new CounterFrame(new SocketProxy());
    MarketServer market=new MarketServer();
    (new Thread(market)).start();
    BasicServer server = new BasicServer(new PersistentDB());
    counter.show();
    BarCodeReaderUI reader = new BarCodeReaderUI();
    reader.setLocation(100,300);
    reader.show();
    reader.setListener(counter);
  }
}

