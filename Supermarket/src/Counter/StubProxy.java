package Counter;

public class StubProxy implements MarketProxy  {

	@Override
	public String connect(long employee, String password) throws Exception {
		if (employee == 1 && password.equals("one"))
		{
			return "Yee Emplo";
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getName(long item) throws Exception {
		if (item == 1)
		{
			return "Beer";
		}
		else if (item == 2)
		{
			return "Peanuts";
		}
		else if (item == 3)
		{
			return "Cookies";
		}
		else
		{
			return null;
		}
	}

	@Override
	public double getPrice(long item) throws Exception {
		if (item == 1)
		{
			return 1.5;
		}
		else if (item == 2)
		{
			return 0.5;
		}
		else if (item == 3)
		{
			return 2.2;
		}
		else
		{
			return 0.0;
		}
	}

	@Override
	public String getCustomer(long code) throws Exception {
		if (code == 1)
		{
			return "John Doe";
		}
		else if (code == 2)
		{
			return "Jane Doe";
		}
		else
		{
			return null;
		}
	}

	@Override
	public void startTransaction(long customer, long employee) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buy(long item, long quantity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endTransaction() throws Exception {
		
		
	}

	@Override
	public void abortTransaction() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub
		
	}

}
