package application;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="Department")
public class Department {
	@Id
	@Column(name="DeptId")
	private int ID;
	private int PersonnelCount;
	
	private String Location, Name;
	@Transient
	public InventoryClerk IC;
	@Transient
	public
	ArrayList<Employee> EMP = new ArrayList<Employee>();
	@Transient
	public
	ArrayList<Equipment> Equipments = new ArrayList<Equipment>();
	@Transient
	public
	ArrayList<Requisition> Requisitions = new ArrayList<Requisition>();
	@Transient
	public
	ArrayList<RequisitionApproval> RequisitionsApproval = new ArrayList<RequisitionApproval>();
	@Transient
	ArrayList<IssuanceRecord> DeptIssuanceRecord = new ArrayList<IssuanceRecord>();
	@Transient
	ArrayList<Account> Accounts = new ArrayList<Account>();
	
	public Department(int id,String name,String location,int count){
		
		ID=id;
		Name=name;
		PersonnelCount=count;
		Location=location;
		
	}
	
	public Department() {
		// TODO Auto-generated constructor stub
	}

	public int getPersonnelCount() {
		return PersonnelCount;
	}
	public void setPersonnelCount(int personnelCount) {
		PersonnelCount = personnelCount;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public void DisplayDepartment1() {
		System.out.println(ID +","+ Name+","+Location+","+PersonnelCount);
	}
	public String DisplayDepartment() {
		return(ID +","+ Name+","+Location+","+PersonnelCount);
	}
	public Department getDept()
	{
		return this;
	}
	

}
