package MarketDB;

import java.util.ArrayList;

public class DBManagerStub implements DBManager {

	private ArrayList<Transaction> xacts = new ArrayList<Transaction>();
	private Item beer =  new Item(1,"Beer",1.5,1000);
	private Item peanuts = new Item(2,"Peanuts",0.5,1000);
	private Item cookies = new Item(3,"Cookies",2.2,500);
	@Override
	public Item getItem(long code) {
		Item item = null;
		if (code == 1)
		{
			item = beer;
		}
		else if (code == 2)
		{
			item = peanuts;
		}
		else if (code == 3)
		{
			item = cookies;
		}
		return item;
	}

	@Override
	public Employee getEmployee(long code) {
		Employee emp = null;
		if (code == 1)
		{
			emp = new Employee(1,"Yee Emplo","one");
		}
		return emp;
	}

	@Override
	public Customer getCustomer(long code) {
		Customer cust = null;
		if (code == 1)
		{
			cust = new Customer(1,"John Doe");
		}
		else if (code == 2)
		{
			cust = new Customer(2,"Jane Doe");
		}
		return cust;
	}

	@Override
	public long startTransaction(long customer, long employee) throws Exception {
		long lastID = 0;
		if (xacts.size() != 0)
		{
			lastID = xacts.get(xacts.size()-1).code;
		}
		Transaction newXact = new Transaction(lastID +1,employee, customer);
		xacts.add(newXact);
		return newXact.code;
	}

	@Override
	public void abortTransaction(long code) throws Exception {
		for (int i =0; i < xacts.size();i++){
			if (xacts.get(i).code == code){
				xacts.remove(i);
				return;
			}
		}
		throw new Exception("Transaction doesn't exist");
	}

	@Override
	public void closeTransaction(long code) throws Exception {
		for (int i =0; i < xacts.size();i++){
			if (xacts.get(i).code == code){
				xacts.get(i).open = false;
				return;
			}
		}
		throw new Exception("Transaction doesn't exist");
		
	}

	@Override
	public void buy(long item, long quantity, long transaction)
			throws Exception {
		for (int i =0; i < xacts.size();i++){
			if (xacts.get(i).code == transaction){
				if (item == 1)
				{
						beer.quantity = beer.quantity - quantity;	
				}
				else if (item == 2)
				{
						peanuts.quantity = peanuts.quantity - quantity;	
				}
				else if (item ==3)
				{
						cookies.quantity = cookies.quantity - quantity;
				}
				return;
				//no need to create aquisition 
			}
		}
		throw new Exception("Transaction doesn't exist");
		
	}

}
