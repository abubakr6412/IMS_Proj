package application;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Requisiton")
public class Requisition {

	private int DeptID, EquipmentID;
	@Id
	private int	RequisitionID;
    private int EMPID;
	public Requisition(int empid,int Deptid, int Eqid, int Rqid) {
		DeptID = Deptid;
		setEMPID(empid);
		EquipmentID = Eqid;
		RequisitionID = Rqid;
	}

	public Requisition() {
		// TODO Auto-generated constructor stub
	}

	public int getDeptID() {
		return DeptID;
	}

	public void setDeptID(int deptID) {
		DeptID = deptID;
	}

	public int getEquipmentID() {
		return EquipmentID;
	}

	public void setEquipmentID(int equipmentID) {
		EquipmentID = equipmentID;
	}

	public int getRequisitionID() {
		return RequisitionID;
	}

	public void setRequisitionID(int requisitionID) {
		RequisitionID = requisitionID;
	}
	
	
	public void DisplayRequisitions() {
		System.out.println(EMPID+" "+RequisitionID+" "+EquipmentID+" "+DeptID);
	}
	
	public String DisplayRequisitionsUI() {
		return(EMPID+","+RequisitionID+","+EquipmentID+","+DeptID);
	}
	
	public Requisition getReq() {
		return this;
	}

	public int getEMPID() {
		return EMPID;
	}

	public void setEMPID(int eMPID) {
		EMPID = eMPID;
	}
}
