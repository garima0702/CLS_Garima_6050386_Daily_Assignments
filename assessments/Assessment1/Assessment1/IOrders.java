package cg.demo.Assessment1;

import java.util.List;

public interface IOrders {

	public abstract boolean addOrder(Orders order, int custId);
	public abstract Orders getOrder(int orderId);
	public abstract List<Orders> getOrders(String custName);
	
}
