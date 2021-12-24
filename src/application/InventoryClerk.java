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
@Table(name="InventoryClerk")
public class InventoryClerk {
	@Id
	private int ID;
	private int PNo,Age,DeptID;
	private String Name,Address,JoinDate,DOB;
	boolean isLoggedIn=false;
	@Transient
	public
	ArrayList<AccountApproval> AccApprovals = new ArrayList<AccountApproval>();
	@Transient
	public
	Account ICaccount;
	public InventoryClerk(int id,int deptid,int pno,int age,String name,String address,String joindate,String dob){
		setDeptID(deptid);
		setID(id);
		setPNo(pno);
		setAge(age);
		setName(name);
		setAddress(address);
		setJoinDate(joindate);
		setDOB(dob);
		
	}

	public InventoryClerk() {
		// TODO Auto-generated constructor stub
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getJoinDate() {
		return JoinDate;
	}

	public void setJoinDate(String joinDate) {
		JoinDate = joinDate;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public int getDeptID() {
		return DeptID;
	}

	public void setDeptID(int deptID) {
		DeptID = deptID;
	}
	
	public void DisplayIC() {
		System.out.println(ID+" "+DeptID+" "+PNo+" "+Age+" "+Name+" "+Address+" "+JoinDate +" "+DOB);
	}
	
	public String InventoryClerkUI() {
		return(ID+","+DeptID+","+PNo+","+Age+","+Name+","+Address+","+JoinDate +","+DOB);
	}
	
	int SystemLogin(String username,String password) {
		String strNew = JoinDate.replace("-", "");
		
		if(username.equals(String.valueOf(ID)) && strNew.equals(password)) {
			return 2;
		}
		return 0;
	}
	
	public InventoryClerk getIC()
	{
		return this;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
