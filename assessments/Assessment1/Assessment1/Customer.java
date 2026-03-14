package cg.demo.Assessment1;


import java.util.List;

import cg.demo.AssociationMapping.Employee;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name =" abes_customer")
public class Customer {
	@Id
	private int Customer_id;

	private String Customer_name;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Orders> ord;

	public int getCustomer_id() {
		return Customer_id;
	}

	public void setCustomer_id(int customer_id) {
		Customer_id = customer_id;
	}

	public String getCustomer_name() {
		return Customer_name;
	}

	public void setCustomer_name(String customer_name) {
		Customer_name = customer_name;
	}
	
	

}
