
package Market;

import java.net.ServerSocket;
import java.net.Socket;

public class MarketServer
implements Runnable {

  static Market singleton;
  static void setInstance(Market instance){
    singleton = instance;
  }
  public static Market getInstance() {
    return singleton;
  }

  public void run(){
    try{
      ServerSocket ss= new ServerSocket(Const.SERVER_PORT);
      while(true){
        Socket sk = ss.accept();
        MarketStub stub = new MarketStub(sk,getInstance());
        (new Thread(stub)).start();
      }
    }catch(Exception ex){
      System.out.println("Error: " + ex.getMessage());
    }
  }
}