package application;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@Entity
@Table(name = "Equipment")
public class Equipment {

	@Id
	@Column(name = "EqpId")
	private int EquipmentID;
	private int DeptID, Price;
	private String Conditiona;
	@Transient
	public
	ArrayList<IssuanceRecord> ISR = new ArrayList<IssuanceRecord>();
	@Transient
	public
	EquipmentDescription EQDescription;
	
	
	
	

	public Equipment() {

	};

	public Equipment(int EQID, int DID, int price, String condition) {
		EquipmentID = EQID;
		DeptID = DID;
		Price = price;
		Conditiona = condition;

		
	}

	public int getEquipmentID() {
		return EquipmentID;
	}

	public void setEquipmentID(int equipmentID) {
		EquipmentID = equipmentID;
	}

	public int getDeptID() {
		return DeptID;
	}

	public void setDeptID(int deptID) {
		DeptID = deptID;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public String getCondition() {
		return Conditiona;
	}

	public void setCondition(String condition) {
		Conditiona = condition;
	}

	public String DisplayEquipment() {
		return (EquipmentID + "," + DeptID + "," + Price + "," + Conditiona);
	}
	
	public void DisplayEquipment1() {
		System.out.println (EquipmentID + " " + DeptID + " " + Price + " " + Conditiona);
	}

	public Equipment getEquipment()
	{
	return this;	
	}
}
