package application;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javafx.scene.control.CheckBox;
@Entity
@Table(name="Product")
public class Product {
	public int getSuppID() {
		return SuppID;
	}

	public void setSuppID(int suppID) {
		SuppID = suppID;
	}

	public int getProductID() {
		return ProductID;
	}

	public void setProductID(int productID) {
		ProductID = productID;
	}

	public String getProductDesc() {
		return ProductDesc;
	}

	public void setProductDesc(String productDesc) {
		ProductDesc = productDesc;
	}

	public String getMaunfacturedDate() {
		return MaunfacturedDate;
	}

	public void setMaunfacturedDate(String maunfacturedDate) {
		MaunfacturedDate = maunfacturedDate;
	}

private	int SuppID;
@Id
private	int ProductID;
private	String ProductDesc,MaunfacturedDate;

	
	
	public Product(int SID,int PID,String PDS,String ManufDate){
		SuppID=SID;
		ProductID=PID;
		ProductDesc=PDS;
		MaunfacturedDate=ManufDate;
	
	}
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	void DisplayProduct() {
		System.out.println(SuppID+" "+ProductID+" "+ProductDesc+" "+MaunfacturedDate);
	}
	
	String DisplayProductUI() {
		return (SuppID+","+ProductID+","+ProductDesc+","+MaunfacturedDate);
	}

	public Product getProduct()
	{
		return this;
	}


	
}
