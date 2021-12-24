package application;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Account")
public class Account {

	
	
	private String Username,Pass;
	@Id
	private int ID;
	
	public Account(String username,String pass,int id){
		Username=username;
		Pass=pass;
		ID=id;
	}
	public Account() {
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
	void DisplayAccount()
	{
		System.out.println(Username+ " " + Pass + " "+ ID);
	}
	public Account getAccount()
	{
		return this;
	}
}
