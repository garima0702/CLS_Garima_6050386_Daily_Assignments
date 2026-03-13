package cg.demo.jpahibernate.entities;

import java.util.Set;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
	    private String name;
	    private int salary;
	    private String department;
	    @ElementCollection
	    private Set<Long> phone;

	    @Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department
					+ ", phone=" + phone + "]";
		}

		public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }


	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }


	    public int getSalary() {
	        return salary;
	    }

	    public void setSalary(int salary) {
	        this.salary = salary;
	    }


	    public String getDepartment() {
	        return department;
	    }

	    public void setDepartment(String department) {
	        this.department = department;
	    }


	    public Set<Long> getPhone() {
	        return phone;
	    }

	    public void setPhone(Set<Long> l) {
	        this.phone = l;
	    }


}
