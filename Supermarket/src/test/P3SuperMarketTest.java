package test;

import Counter.SocketProxy;
import CounterUI.BarCodeReaderUI;
import CounterUI.CounterFrame;
import Market.BasicServer;
import Market.MarketServer;
import MarketDB.DBManagerStub;

public class P3SuperMarketTest {
	@SuppressWarnings({ "unused", "deprecation" })
	public static void main(String [] args) {
	    CounterFrame counter = new CounterFrame(new SocketProxy());
	    MarketServer market=new MarketServer();
	    (new Thread(market)).start();
	    BasicServer server = new BasicServer(new DBManagerStub());
	    counter.show();
	    BarCodeReaderUI reader = new BarCodeReaderUI();
	    reader.setLocation(100,300);
	    reader.show();
	    reader.setListener(counter);
	  }
}
