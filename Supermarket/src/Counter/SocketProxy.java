
package Counter;

import java.net.Socket;
import Market.Const;
import java.io.InputStream;
import java.io.OutputStream;

public class SocketProxy
implements MarketProxy {
  Socket socket;
  InputStream in;
  OutputStream out;
  public String connect(long employee, String password) throws Exception{
    socket = new Socket(Const.SERVER_HOST,Const.SERVER_PORT);
    in = socket.getInputStream();
    out = socket.getOutputStream();

    String request = Const.AUTHENTICATE + " " + employee + " " + password + "\n";
    out.write(request.getBytes());
    out.flush();
    byte [] buffer=new byte[1024];
    int len;
    len = in.read(buffer);
    String reply = new String(buffer,0,len);
    if(reply.startsWith(Const.OK)){
      return reply.substring(Const.OK.length());
    }else{
      return null;
    }
  }

  public String getName(long item) throws Exception {
    String request = Const.GET_NAME + " " + item + "\n";
    out.write(request.getBytes());
    out.flush();
    byte [] buffer=new byte[1024];
    int len;
    len = in.read(buffer);
    String reply = new String(buffer,0,len);
    if(reply.startsWith(Const.OK)){
      return reply.substring(Const.OK.length());
    }else{
      return reply.substring(Const.ERROR.length());
    }
  }
  public double getPrice(long item) throws Exception {
    String request = Const.GET_PRICE + " " + item + "\n";
    out.write(request.getBytes());
    out.flush();
    byte [] buffer=new byte[1024];
    int len;
    len = in.read(buffer);
    String reply = new String(buffer,0,len);
    if(reply.startsWith(Const.OK)){
      return Double.parseDouble(reply.substring(Const.OK.length()));
    }else{
      return Double.parseDouble(reply.substring(Const.ERROR.length()));
    }
  }

  public String getCustomer(long code) throws Exception{
    String request = Const.GET_CUSTOMER + " " + code + "\n";
    out.write(request.getBytes());
    out.flush();
    byte [] buffer=new byte[1024];
    int len;
    len = in.read(buffer);
    String reply = new String(buffer,0,len);
    if(reply.startsWith(Const.OK)){
      return reply.substring(Const.OK.length());
    }else{
      return reply.substring(Const.ERROR.length());
    }
  }

  public void startTransaction(long customer, long employee) throws Exception{

  }
  public void buy(long item, long quantity) throws Exception {
    String request = Const.BUY + " " + item + " " + quantity + "\n";
    out.write(request.getBytes());
    out.flush();
    byte [] buffer=new byte[1024];
    int len;
    len = in.read(buffer);
    String reply = new String(buffer,0,len);
    if(reply.startsWith(Const.ERROR)){
      throw new Exception(reply.substring(Const.ERROR.length()));
    }
  }

  public void endTransaction() throws Exception {
    String request = Const.END + "\n";
    out.write(request.getBytes());
    out.flush();
    byte [] buffer=new byte[1024];
    int len;
    len = in.read(buffer);
    String reply = new String(buffer,0,len);
    if(reply.startsWith(Const.ERROR)){
      throw new Exception(reply.substring(Const.ERROR.length()));
    }
  }

  public void abortTransaction() throws Exception {
    String request = Const.ABORT + "\n";
    out.write(request.getBytes());
    out.flush();
    byte [] buffer=new byte[1024];
    int len;
    len = in.read(buffer);
    String reply = new String(buffer,0,len);
    if(reply.startsWith(Const.ERROR)){
      throw new Exception(reply.substring(Const.ERROR.length()));
    }
  }


  public void disconnect() {
    try{
      out.write((Const.QUIT + "\n").getBytes());
      out.flush();
    }catch(Exception e){

    }
    socket = null;
    in = null;
    out = null;
  }
}