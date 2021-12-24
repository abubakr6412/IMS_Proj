package application;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
@Entity
@Table(name="supplier")
public class Supplier {

	private String Name,JoinDate,Company,Address;
	@Id
	private int SupplierID;
	private int PNo,Age;
	
	
	boolean isLoggedIn=false;
	@Transient
	public
	ArrayList<Product> Products = new ArrayList<Product>();
	@Transient
	public
	Account Supplieraccount;
	@Transient
	public
	ArrayList<EquipmentDelivery> Deliveries = new ArrayList<EquipmentDelivery>();
	
	public Supplier(String name,int suppid,int pno,int age,String company,String address,String joindate){
		Name=name;
		SupplierID=suppid;
		PNo=pno;
		Age=age;
		Company=company;
		Address=address;
		JoinDate=joindate;
		
	}
	public Supplier() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getJoinDate() {
		return JoinDate;
	}
	public void setJoinDate(String joinDate) {
		JoinDate = joinDate;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getSupplierID() {
		return SupplierID;
	}
	public void setSupplierID(int supplierID) {
		SupplierID = supplierID;
	}
	public int getPNo() {
		return PNo;
	}
	public void setPNo(int pNo) {
		PNo = pNo;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	
	int SystemLogin(String username,String password) {
		String strNew = JoinDate.replace("-", "");

		if(username.equals(String.valueOf(this.getSupplierID()))&& strNew.equals(password)) {
			return 1;
		}
		return 0;
		
		
		
	}
	
	public void DisplaySupplier() {
		System.out.println(Name+" "+SupplierID+" "+PNo+" "+Age+" "+Company+" "+Address+" "+JoinDate);
	}
	
	public String DisplaySupplier1() {
		return(Name+","+SupplierID+","+PNo+","+Age+","+Company+","+Address+","+JoinDate);
	}
	public Supplier getSup() {return this;}

}
