package application;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EquipmentDelivery")
public class EquipmentDelivery {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int SuppID, EquipmentID;
	private int DeptID, Price;
	private String Conditiona;
	private String Description, Company, DeliveryDate;

	public EquipmentDelivery(int SuppiD, int EquipmentiD, int DeptiD, int price, String condition, String description,String company, String date) {
		SuppID = SuppiD;
		EquipmentID = EquipmentiD;
		DeptID = DeptiD;
		Price = price;
		Conditiona = condition;
		Description = description;
		Company = company;
		setDeliveryDate(date);
	}

	public EquipmentDelivery() {
		// TODO Auto-generated constructor stub
	}

	public int getSuppID() {
		return SuppID;
	}

	public void setSuppID(int suppID) {
		SuppID = suppID;
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

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	public String getDeliveryDate() {
		return DeliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		DeliveryDate = deliveryDate;
	}

	public void DisplayDelivery() {
//		SuppID = SuppiD;
//		EquipmentID = EquipmentiD;
//		DeptID = DeptiD;
//		Price = price;
//		Condition = condition;
//		Description = description;
//		Company = company;
//		setDeliveryDate(date);
		
		
		System.out.println(SuppID+" "+EquipmentID+" "+DeptID+" "+Price+" "+Conditiona+" "+Description+" "+Company+" "+DeliveryDate);
	}
	public EquipmentDelivery getED()
	{
		return this;
	}

}
