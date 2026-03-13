package cg.demo.AssociationMapping;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Did;
	
	private String name;
	
	private String managername;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy= "dept")
	private List<Employee> emp;

	public List<Employee> getEmp() {
		return emp;
	}

	public void setEmp(List<Employee> emp) {
	    this.emp = emp;
	}

	public int getDid() {
		return Did;
	}

	public void setDid(int did) {
		Did = did;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}

	@Override
	public String toString() {
		return "Department [Did=" + Did + ", name=" + name + ", managername=" + managername + ", emp=" + emp + "]";
	}
	
	

}
