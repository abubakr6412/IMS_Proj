package application;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="RequisitonApproval")
public class RequisitionApproval {
	private int EquipmentID;
	@Id
	private int RequisitionID;
private int	SuppID;
	private String Status,IssueDate;

	public RequisitionApproval(int EquipID, int ReqID, int SupID, String Stat, String issuedate)
	{
		EquipmentID = EquipID;
		RequisitionID = ReqID;
		SuppID = SupID;
		Status = Stat;
		IssueDate = issuedate;
	}
    
	public RequisitionApproval()
	{
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

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getIssueDate() {
		return IssueDate;
	}

	public void setIssueDate(String issueDate) {
		IssueDate = issueDate;
	}

	public int getSuppID() {
		return SuppID;
	}

	public void setSuppID(int suppID) {
		SuppID = suppID;
	}
	public RequisitionApproval getRA()
	{return this;}
	
	public void DisplayReqApproval()
	{
		System.out.println(EquipmentID + " " + RequisitionID + " " + SuppID +" " + Status+" " +IssueDate);
	}
	
	public String DisplayReqApprovalUI()
	{
		return(EquipmentID + "," + RequisitionID + "," + SuppID +"," + Status+"," +IssueDate);
	}
	
}
