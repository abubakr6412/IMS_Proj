package application;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AccountApproval")
public class AccountApproval {
	
	
	private String Username,Pass;
	private int DeptID;
	@Id
	private int ID;
	
	public AccountApproval(String username,String pass,int id,int Deptid){
		Username=username;
		Pass=pass;
		ID=id;
		DeptID=Deptid;
	}
	public AccountApproval() {
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}

	public int getDeptID() {
		return DeptID;
	}
	public void setDeptID(int deptID) {
		DeptID = deptID;
	}
	
	void DisplayAccountApprovals()
	{
		System.out.println(Username+ " " + Pass + " "+ ID +" "+DeptID);
	}
	String DisplayAccountApprovalsUI()
	{
		return(Username+ "," + Pass + ","+ ID +","+DeptID);
	}
	public AccountApproval getApproval()
	{
		return this;
	}
}
