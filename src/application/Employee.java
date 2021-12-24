package application;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@Entity
@Table(name="Employee")
public class Employee {
	@Id
	private int EMPID;
	private int PNo,Age,DeptID;
	private String Name,Address,JoinDate,DOB;
	boolean isLoggedIn=false;
	@Transient
	public
	Account EMPaccount;
	public Employee(int empid,int deptid,int pno,int age,String name,String address,String joindate,String dob){
		DeptID=deptid;
		EMPID=empid;
		PNo=pno;
		Age=age;
		Name=name;
		Address=address;
		JoinDate=joindate;
		DOB=dob;
		
	}
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}


	public int getEMPID() {
		return EMPID;
	}
	public void setEMPID(int eMPID) {
		EMPID = eMPID;
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
	
	public void DisplayEmployee() {
		//(int id,int deptid,int pno,int age,String name,String address,String joindate,String dob)
		System.out.println(EMPID+" "+DeptID+" "+PNo+" "+Age+" "+Name+" "+Address+" "+JoinDate +" "+DOB);
	}
	
	public String DisplayEmployee1() {
		return(EMPID+","+DeptID+","+PNo+","+Age+","+Name+","+Address+","+JoinDate +","+DOB);
	}
	int SystemLogin(String username,String password) {
		String strNew = JoinDate.replace("-", "");
		
		
		if(username.equals(EMPaccount.getUsername())&& password.equals(EMPaccount.getPass())) {
			return 3;
		}
		return 0;
	}
	public Employee getEmployee()
	{
		return this;
	}

	
	
}
