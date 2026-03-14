package cg.demo.Assessment1;

import java.util.List;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class OrdersDaoImp implements IOrders{
	

	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
	 EntityManager em = emf.createEntityManager();

	@Override
	public boolean addOrder(Orders order, int custId) {
		 em.getTransaction().begin();

		    Customer c = em.find(Customer.class, custId);

		    if (c == null) {
		        em.getTransaction().rollback();
		        return false;
		    }

		    order.setCustomer(c);
		    em.persist(order);

		    em.getTransaction().commit();

		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Orders getOrder(int orderId) {
		em.getTransaction().begin();
		Orders ord = em.find(Orders.class,orderId);
		em.getTransaction().commit();
		// TODO Auto-generated method stub
		return ord;
	}

	@Override
	public List<Orders> getOrders(String custName) {
		 List<Orders> list = em.createQuery(
			        "SELECT o FROM Orders o WHERE o.customer.Customer_name = :name",
			        Orders.class)
			        .setParameter("name", custName)
			        .getResultList();
	
		// TODO Auto-generated method stub
		return list;
	}
}

