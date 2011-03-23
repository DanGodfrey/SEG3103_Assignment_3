
package Market;

import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.StringTokenizer;

public class MarketStub
implements Runnable {
  Socket socket;
  Market market;
  MarketStub(Socket sk, Market mk){
    socket = sk;
    market = mk;
  }

  public void run(){
    try{
      InputStream in = socket.getInputStream();
      OutputStream out = socket.getOutputStream();
      byte [] buffer=new byte[1024];
      int len;
      long customer=0;
      long transaction=0;
      long employee=0;
      while((len=in.read(buffer)) != -1){
        String request = new String(buffer,0,len);

        System.out.println(">" + request);
        StringTokenizer parser = new StringTokenizer(request);

        String command = parser.nextToken();
        String param="";
        String response;
        if(parser.hasMoreTokens()){
          param = parser.nextToken();
        }
        try{
        if(command.equals(Const.GET_NAME)){
          String result = market.getName(Long.parseLong(param));
          if(result==null){
            response = Const.ERROR + " Item not found";
          }else{
            response = Const.OK + " " + result;
          }
        }else if(command.equals(Const.GET_PRICE)){
          double result = market.getPrice(Long.parseLong(param));
          if(result < 0 ){
            response = Const.ERROR + " Item not found";
          }else{
            response = Const.OK + " " + result;
          }
        }else if(command.equals(Const.GET_CUSTOMER)){
          customer = Long.parseLong(param);
          String result = market.getCustomer(customer);
          if(result==null){
            response = Const.ERROR + " Customer not found";
          }else{
            response = Const.OK + " " + result;
          }
        }else if(command.equals(Const.AUTHENTICATE)){
          String password = parser.nextToken();
          employee = Long.parseLong(param);
          String result = market.authenticate(employee,password);
          if(result==null){
            response = Const.ERROR + " Wrong employee or password";
          }else{
            response = Const.OK + " " + result;
          }
        }else if(command.equals(Const.BUY)){
          String quantity = parser.nextToken();
          if(transaction == 0){
            transaction = market.startTransaction(customer,employee);
          }
          market.buy(Long.parseLong(param),Long.parseLong(quantity),transaction);
          response = Const.OK;
        }else if(command.equals(Const.END)){
          market.endTransaction(transaction);
          transaction = 0;
          response = Const.OK;
        }else if(command.equals(Const.ABORT)){
          market.abortTransaction(transaction);
          transaction = 0;
          response = Const.OK;
        }else if(command.equals(Const.QUIT)){
          break;
        }else{
          response = Const.ERROR + " Unknown command";
        }
        }catch(Exception e){
          response = Const.ERROR + " " + e.getMessage();
        }
        System.out.println("<" + response);
        out.write((response).getBytes());
        out.flush();
      }
    }catch(Exception ex){

    }

  }
}