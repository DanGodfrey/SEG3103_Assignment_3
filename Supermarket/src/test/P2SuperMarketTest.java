package test;

import Counter.StubProxy;
import CounterUI.BarCodeReaderUI;
import CounterUI.CounterFrame;
import Market.BasicServer;
import Market.MarketServer;
import MarketDB.PersistentDB;

public class P2SuperMarketTest {
	@SuppressWarnings({ "deprecation", "unused" })
	public static void main(String [] args) {
	    CounterFrame counter = new CounterFrame(new StubProxy());
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
