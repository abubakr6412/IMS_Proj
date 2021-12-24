package application;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
@Entity
@Table(name="IssuanceRecord")
public class IssuanceRecord {
	@Id
	private int RecordID;
	private int EMPID,EQID;
	private String IssueDate,ReturnDate;
	
	
	public IssuanceRecord(int rid,int eqid,int empid,String idate,String rdate){
		RecordID=rid;
		EQID=eqid;
		EMPID=empid;
		IssueDate=idate;
		ReturnDate=rdate;
		
	}
	
	public IssuanceRecord() {
		// TODO Auto-generated constructor stub
	}

	public int getRecordID() {
		return RecordID;
	}
	public void setRecordID(int recordID) {
		RecordID = recordID;
	}
	public int getEMPID() {
		return EMPID;
	}
	public void setEMPID(int eMPID) {
		EMPID = eMPID;
	}
	public String getIssueDate() {
		return IssueDate;
	}
	public void setIssueDate(String issueDate) {
		IssueDate = issueDate;
	}
	public String getReturnDate() {
		return ReturnDate;
	}
	public void setReturnDate(String returnDate) {
		ReturnDate = returnDate;
	}

	public int getEQID() {
		return EQID;
	}

	public void setEQID(int eQID) {
		EQID = eQID;
	}
	
	public String DisplayIssuanceRecord() {
		return(RecordID+","+EQID+","+EMPID+","+IssueDate+","+ReturnDate);
	}
	
	
	public void DisplayIssuanceRecord1() {
		System.out.println(RecordID+" "+EQID+" "+EMPID+" "+IssueDate+" "+ReturnDate);
	}
	public IssuanceRecord getIR()
	{
		return this;
	}
	
}
