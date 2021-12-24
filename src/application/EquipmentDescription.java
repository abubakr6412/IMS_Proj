package application;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@Entity
@Table(name="EquipmentDescription")
public class EquipmentDescription {


	@Id
	@Column(name="EqpId")
	private int EquipmentID;
	private String Description,Company;
	
	public EquipmentDescription(int EQID,String Desc,String Comp){
		EquipmentID=EQID;
		Description=Desc;
		Company=Comp;
	}
	public EquipmentDescription() {
		// TODO Auto-generated constructor stub
	}
	public int getEquipmentID() {
		return EquipmentID;
	}
	public void setEquipmentID(int equipmentID) {
		EquipmentID = equipmentID;
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
	
public void DisplayEQDescription() {
	System.out.println(EquipmentID+" "+Description+" "+Company );
}

public String EQDescriptionUI() {
	return(EquipmentID+","+Description+","+Company );
}
public EquipmentDescription getED()
{
	return this;
}
	
}
