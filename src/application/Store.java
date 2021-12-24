package application;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import storage.DatabaseHandler;
import storage.Filehandler;
import storage.PersistenceFactory;
import storage.PersistentHandler;

public class Store  {

	// ArrayList<String> cars = new ArrayList<String>();

	public ArrayList<Department> Depts = new ArrayList<Department>();
	public ArrayList<Supplier> Supp = new ArrayList<Supplier>();
	ArrayList<AuditReport> AuditRP = new ArrayList<AuditReport>();
	PersistentHandler FL = PersistenceFactory.createPersistenceHandler();


	public void PopulateSystem() {
		Depts = FL.importDept(Depts);
		Supp = FL.importSupplier(Supp);

	}

	public void DisplayDepartments() throws NullValueException {
		
		for (int i = 0; i < Depts.size(); i++) {
			Depts.get(i).DisplayDepartment1();
			if(Depts.get(i) == null)
			{
				throw new NullValueException("Null Value");
			}
		}

	}

	public void DisplayIC() throws NullValueException {
		for (int i = 0; i < Depts.size(); i++) {
			Depts.get(i).IC.DisplayIC();
			if(Depts.get(i).IC == null)
			{
				throw new NullValueException("Null Value");
			}

		}

	}

	public void DisplayEmployee() throws NullValueException {
		for (int i = 0; i < Depts.size(); i++) {
			for (int j = 0; j < Depts.get(i).EMP.size(); j++) {
				Depts.get(i).EMP.get(j).DisplayEmployee();
				if(Depts.get(i).EMP == null)
				{
					throw new NullValueException("Null Value");
				}
			}
		}

	}

	public void DisplaySupplier() throws NullValueException {
		for (int i = 0; i < Supp.size(); i++) {
			Supp.get(i).DisplaySupplier();
			if(Supp.get(i) == null)
			{
				throw new NullValueException("Null Value");
			}
		}
	}

	public void DisplayProducts() throws NullValueException {
		for (int i = 0; i < Supp.size(); i++) {

			for (int j = 0; j < Supp.get(i).Products.size(); j++) {
				Supp.get(i).Products.get(j).DisplayProduct();
				if(Supp.get(i) == null)
				{
					throw new NullValueException("Null Value");
				}
			}
		}
	}

	public void DisplayEquipments() throws NullValueException {
		for (int i = 0; i < Depts.size(); i++) {
			for (int j = 0; j < Depts.get(i).Equipments.size(); j++) {
				Depts.get(i).Equipments.get(j).DisplayEquipment1();
				if(Depts.get(i) == null)
				{
					throw new NullValueException("Null Value");
				}

			}
		}

	}

	public void DisplayAccounts() {

		for (int i = 0; i < Depts.size(); i++) {
			for (int j = 0; j < Depts.get(i).EMP.size(); j++) {
				if (Depts.get(i).EMP.get(j).EMPaccount != null) {
					Depts.get(i).EMP.get(j).EMPaccount.DisplayAccount();
				
				}

			}
			Depts.get(i).IC.ICaccount.DisplayAccount();
		

		}

		for (int i = 0; i < Supp.size(); i++) {
			Supp.get(i).Supplieraccount.DisplayAccount();
		
		}

	}

	public void DisplayAccountApprovals() {
		for (int i = 0; i < Depts.size(); i++) {
			for (int j = 0; j < Depts.get(i).IC.AccApprovals.size(); j++) {
				Depts.get(i).IC.AccApprovals.get(j).DisplayAccountApprovals();
				
			}
		}
	}

	public void DisplayDeliveries() {
		for (int i = 0; i < Supp.size(); i++) {
			for (int j = 0; j < Supp.get(i).Deliveries.size(); j++) {
				Supp.get(i).Deliveries.get(j).DisplayDelivery();
		
			}
		}
	}

	public void DisplayEquipmentDescriptions() {
		for (int i = 0; i < Depts.size(); i++) {
			for (int j = 0; j < Depts.get(i).Equipments.size(); j++) {

				Depts.get(i).Equipments.get(j).EQDescription.DisplayEQDescription();
				

			}
		}
	}

	public void DisplayEquipmentIssuanceRecord() {
		for (int i = 0; i < Depts.size(); i++) {
			for (int j = 0; j < Depts.get(i).Equipments.size(); j++) {

				for (int k = 0; k < Depts.get(i).Equipments.get(j).ISR.size(); k++) {
					Depts.get(i).Equipments.get(j).ISR.get(k).DisplayIssuanceRecord1();

				}

			}
		}

	}

	public void DisplayRequisitions() {

		for (int i = 0; i < Depts.size(); i++) {
			for (int j = 0; j < Depts.get(i).Requisitions.size(); j++) {
				System.out.print("h");
				Depts.get(i).Requisitions.get(j).DisplayRequisitions();
				
			}
		}
	}

	public void DisplayDeptISR() {
		for (int i = 0; i < Depts.size(); i++) {
			for (int j = 0; j < Depts.get(i).DeptIssuanceRecord.size(); j++) {
				Depts.get(i).DeptIssuanceRecord.get(j).DisplayIssuanceRecord1();
			}
		}
	}

	public int ActiveLoginID() {

		for (int i = 0; i < Depts.size(); i++) {
			for (int j = 0; j < Depts.get(i).EMP.size(); j++) {
				if (Depts.get(i).EMP.get(j).isLoggedIn == true) {
					return Depts.get(i).EMP.get(j).getEMPID();
				}
			}
		}

		for (int i = 0; i < Depts.size(); i++) {
			{
				if (Depts.get(i).IC.isLoggedIn == true) {
					return Depts.get(i).IC.getID();
				}
			}
		}

		for (int i = 0; i < Supp.size(); i++) {
			if (Supp.get(i).isLoggedIn == true) {
				return Supp.get(i).getSupplierID();
			}
		}
		return 0;
	}

	public void LogoutID() {

		for (int i = 0; i < Depts.size(); i++) {
			for (int j = 0; j < Depts.get(i).EMP.size(); j++) {
				if (Depts.get(i).EMP.get(j).isLoggedIn == true) {
					Depts.get(i).EMP.get(j).isLoggedIn = false;
				}
			}
		}

		for (int i = 0; i < Depts.size(); i++) {
			{
				if (Depts.get(i).IC.isLoggedIn == true) {
					Depts.get(i).IC.isLoggedIn = false;
				}
			}
		}

		for (int i = 0; i < Supp.size(); i++) {
			if (Supp.get(i).isLoggedIn == true) {
				Supp.get(i).isLoggedIn = false;
			}
		}

	}

	public int SystemLogin(String username, String password) {

		for (int i = 0; i < Depts.size(); i++) {
			for (int j = 0; j < Depts.get(i).EMP.size(); j++) {
				if (Depts.get(i).EMP.get(j).isLoggedIn == true) {
					return 3;
				}
			}
		}

		for (int i = 0; i < Depts.size(); i++) {
			{
				if (Depts.get(i).IC.isLoggedIn == true) {
					return 2;
				}
			}
		}

		for (int i = 0; i < Supp.size(); i++) {
			if (Supp.get(i).isLoggedIn == true) {
				return 1;
			}
		}

		return 0;

	}

	public void SystemLL(String Username, String Password) {

		for (int i = 0; i < Depts.size(); i++) {
			for (int j = 0; j < Depts.get(i).EMP.size(); j++) {
				if (Depts.get(i).EMP.get(j).EMPaccount != null) {

					if (Depts.get(i).EMP.get(j).EMPaccount.getUsername().equals(Username)
							&& Depts.get(i).EMP.get(j).EMPaccount.getPass().equals(Password)) {
						Depts.get(i).EMP.get(j).isLoggedIn = true;
					}
				}
			}
		}

		for (int i = 0; i < Depts.size(); i++) {

			if (Depts.get(i).IC.ICaccount.getUsername().equals(Username)
					&& Depts.get(i).IC.ICaccount.getPass().equals(Password)) {
				Depts.get(i).IC.isLoggedIn = true;
			}

		}

		for (int i = 0; i < Supp.size(); i++) {
			System.out.println(Supp.get(i).Supplieraccount.getUsername() + " " + Supp.get(i).Supplieraccount.getPass());
			System.out.println(Username + " " + Password);

			if (Supp.get(i).Supplieraccount.getUsername().equals(Username)
					&& Supp.get(i).Supplieraccount.getPass().equals(Password)) {
				Supp.get(i).isLoggedIn = true;
				System.out.println("Yes");

			}
		}

	}

	// Approve Requisition

	public void ApproveRequisition(int iD) {

		Requisition temp = new Requisition();
		for (int i = 0; i < Depts.size(); i++) {
			for (int j = 0; j < Depts.get(i).Requisitions.size(); j++) {
				if (iD == Depts.get(i).Requisitions.get(j).getRequisitionID()) {
					temp = Depts.get(i).Requisitions.get(j);

				}
			}
		}

		int suppid = 0;
		for (int i = 0; i < Supp.size(); i++) {
			for (int j = 0; j < Supp.get(i).Products.size(); j++) {
				if (temp.getEquipmentID() == Supp.get(i).Products.get(j).getProductID()) {
					suppid = Supp.get(i).getSupplierID();
				}

			}
		}

		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

		for (int i = 0; i < Depts.size(); i++) {
			if (Depts.get(i).getID() == temp.getDeptID()) {
				RequisitionApproval Apptemp = new RequisitionApproval(temp.getEquipmentID(), temp.getRequisitionID(),
						suppid, "Pending", date);
				Depts.get(i).RequisitionsApproval.add(Apptemp);
				FL.addReqApproval(Apptemp);
				Depts.get(i).RequisitionsApproval.get(0).DisplayReqApproval();

			}
		}

	}

	public void AddtoAccountApproval(int ID, String username, String password, int deptID) {

		for (int i = 0; i < Depts.size(); i++) {

			if (Depts.get(i).getID() == deptID) {
				AccountApproval accApproval = new AccountApproval(username, password, ID, deptID);
				Depts.get(i).IC.AccApprovals.add(accApproval);
				FL.addtoAccountApporvalProfile(accApproval);

			}
		}
	}

	public void AddtoEquipment(int reqId, int EquipID, int price, String company, String description, String condition,
			String status) {
		int dept = 0;
		for (int i = 0; i < Depts.size(); i++) {
			for (int j = 0; j < Depts.get(i).Requisitions.size(); j++) {

				if (reqId == Depts.get(i).Requisitions.get(j).getRequisitionID()
						&& EquipID == Depts.get(i).Requisitions.get(j).getEquipmentID()) {
					dept = Depts.get(i).Requisitions.get(j).getDeptID();
					// Depts.get(i).Requisitions.remove(j);
				}
			}
		}

		for (int i = 0; i < Depts.size(); i++) {
			for (int j = 0; j < Depts.get(i).RequisitionsApproval.size(); j++) {
				if (Depts.get(i).RequisitionsApproval.get(j).getRequisitionID() == reqId) {
					Depts.get(i).RequisitionsApproval.get(j).setStatus("Delivered");
					FL.updateRequistion(Depts.get(i).RequisitionsApproval.get(j).getRequisitionID());
					;
				}
			}
		}

		for (int i = 0; i < Depts.size(); i++) {
			if (dept == Depts.get(i).getID()) {
				EquipmentDescription tempdes = new EquipmentDescription(EquipID, description, company);
				Equipment tempeqp = new Equipment(EquipID, dept, price, condition);
				tempeqp.EQDescription = tempdes;
				Depts.get(i).Equipments.add(tempeqp);
				FL.addEquipmentDescription(tempdes);
				FL.addEquipment(tempeqp);
			}
		}

	}

	public String GetStatus(int reqId) {
		String stat = "";
		for (int i = 0; i < Depts.size(); i++) {
			for (int j = 0; j < Depts.get(i).RequisitionsApproval.size(); j++) {
				if (Depts.get(i).RequisitionsApproval.get(j).getRequisitionID() == reqId) {

					stat += Depts.get(i).RequisitionsApproval.get(j).getStatus();
				}
			}
		}
		return stat;
	}

	public void UpdateIssuanceRecord(int equipID, int empID, String issuedate, String returndate) {
		int deptID = 0;

		for (int i = 0; i < Depts.size(); i++) {
			for (int j = 0; j < Depts.get(i).EMP.size(); j++) {

				if (Depts.get(i).EMP.get(j).getEMPID() == empID) {
					deptID = Depts.get(i).getID();
				}
			}

		}

		for (int i = 0; i < Depts.size(); i++) {
			if (deptID == Depts.get(i).getID()) {
				System.out.println(deptID);
				int counter = Depts.get(i).DeptIssuanceRecord.size() + 1;
				IssuanceRecord temprec = new IssuanceRecord(counter, equipID, empID, issuedate, returndate);
				Depts.get(i).DeptIssuanceRecord.add(temprec);
				FL.updateIR(temprec);
			}

		}

	}

	public void AccountApproved(int id) {

		int deptid = 0;
		AccountApproval tempitem = new AccountApproval();
		for (int i = 0; i < Depts.size(); i++) {
			for (int j = 0; j < Depts.get(i).IC.AccApprovals.size(); j++) {

				if (id == Depts.get(i).IC.AccApprovals.get(j).getID()) {
					tempitem = Depts.get(i).IC.AccApprovals.get(j);
					FL.deleteAccountApproval(Depts.get(i).IC.AccApprovals.get(j).getID());
					// FL.deleteAccountApproval(Depts.get(i).IC.AccApprovals.get(j).getDeptID());
					// FL.deleteAccountApproval(2154);
					Depts.get(i).IC.AccApprovals.remove(j);

					deptid = Depts.get(i).getID();
				}

			}

		}

		for (int i = 0; i < Depts.size(); i++) {
			if (deptid == Depts.get(i).getID()) {

				Employee tempemp = new Employee(tempitem.getID(), tempitem.getDeptID(), 0, 0, "", "", "", "");
				tempemp.EMPaccount = new Account(tempitem.getUsername(), tempitem.getPass(), tempitem.getID());
				FL.addEmployee(tempemp);
				FL.addtoAccountProfile(tempemp.EMPaccount);
				Depts.get(i).EMP.add(tempemp);
				// Depts.get(i).Accounts.add();

			}
		}

	}

	public void UpdateEmployeeDetails(int phone, int age, String addre, String dob) {
		for (int i = 0; i < Depts.size(); i++) {
			for (int j = 0; j < Depts.get(i).EMP.size(); j++) {
				if (Depts.get(i).EMP.get(j).getEMPID() == ActiveLoginID()) {

					if (phone != 0) {
						Depts.get(i).EMP.get(j).setPNo(phone);
						FL.updateEmployee(Depts.get(i).EMP.get(j));
					}

					if (age != 0) {
						Depts.get(i).EMP.get(j).setAge(age);
						FL.updateEmployee(Depts.get(i).EMP.get(j));
					}
					if (addre != "") {
						Depts.get(i).EMP.get(j).setAddress(addre);
						FL.updateEmployee(Depts.get(i).EMP.get(j));
					}
					if (dob != "") {
						Depts.get(i).EMP.get(j).setDOB(dob);
						FL.updateEmployee(Depts.get(i).EMP.get(j));
					}

				}
			}
		}
	}

	public void UpdateSupplierDetails(int phone, int age, String addre, String company) {
		for (int i = 0; i < Supp.size(); i++) {

			if (Supp.get(i).getSupplierID() == ActiveLoginID()) {

				if (phone != 0) {
					Supp.get(i).setPNo(phone);
					FL.updateSupplier(Supp.get(i));
				}

				if (age != 0) {
					Supp.get(i).setAge(age);
					FL.updateSupplier(Supp.get(i));
				}
				if (addre != "") {
					Supp.get(i).setAddress(addre);
					FL.updateSupplier(Supp.get(i));
				}
				if (company != "") {
					Supp.get(i).setCompany(company);
					FL.updateSupplier(Supp.get(i));
				}

			}
		}
	}

	public void UpdateInventoryCler_Details(int phone, int age, String addre, String dob) {
		for (int i = 0; i < Depts.size(); i++) {
			if (Depts.get(i).IC.getID() == ActiveLoginID()) {

				if (phone != 0) {
					Depts.get(i).IC.setPNo(phone);
					FL.updateIC(Depts.get(i).IC);
				}

				if (age != 0) {
					Depts.get(i).IC.setAge(age);
					FL.updateIC(Depts.get(i).IC);
				}
				if (addre != "") {
					Depts.get(i).IC.setAddress(addre);
					FL.updateIC(Depts.get(i).IC);
				}
				if (dob != "") {
					Depts.get(i).IC.setDOB(dob);
					FL.updateIC(Depts.get(i).IC);
				}

			}
		}
	}

	public void ProductRequest(int ProdID) {
//Requisition(int empid,int Deptid, int Eqid, int Rqid)

		int deptid = 0;

		for (int i = 0; i < Depts.size(); i++) {
			for (int j = 0; j < Depts.get(i).EMP.size(); j++) {
				if (Depts.get(i).EMP.get(j).getEMPID() == ActiveLoginID()) {
					deptid = Depts.get(i).getID();
				}
			}
		}
		int counter = 0;

		for (int i = 0; i < Depts.size(); i++) {
			for (int j = 0; j < Depts.get(i).Requisitions.size(); j++) {
				if (Depts.get(i).getID() == deptid) {
					counter = Depts.get(i).Requisitions.get(j).getRequisitionID() + 1;
				}
			}
		}

		for (int i = 0; i < Depts.size(); i++) {
			for (int j = 0; j < Depts.get(i).EMP.size(); j++) {
				if (Depts.get(i).EMP.get(j).getEMPID() == ActiveLoginID()) {

					Requisition temp2 = new Requisition(ActiveLoginID(), Depts.get(i).getID(), ProdID, counter);
					Depts.get(i).Requisitions.add(temp2);
					FL.addRequisition(temp2);
				}
			}
		}
	}

	public void AddtoEmployee(int empid, int deptid, int pno, int age, String name, String address, String joindate,
			String dob) {

		for (int i = 0; i < Depts.size(); i++) {
			for (int j = 0; j < Depts.get(i).EMP.size(); j++) {

				if (Depts.get(i).EMP.get(j).getEMPID() == ActiveLoginID()) {
					Depts.get(i).EMP.get(j).setName(name);
					Depts.get(i).EMP.get(j).setAddress(address);
					Depts.get(i).EMP.get(j).setJoinDate(joindate);
					Depts.get(i).EMP.get(j).setDOB(dob);
					Depts.get(i).EMP.get(j).setAge(age);
					Depts.get(i).EMP.get(j).setPNo(pno);
					FL.addEmployee(Depts.get(i).EMP.get(j));
				}

			}
		}

	}

	// --------------------------------------------------UI
	// Functions--------------------------------------------------------
	public String DisplayEquipmentsUI() {
		String equipment = "";
		for (int i = 0; i < Depts.size(); i++) {
			for (int j = 0; j < Depts.get(i).Equipments.size(); j++) {
				Depts.get(i).Equipments.get(j).DisplayEquipment();
				equipment += Depts.get(i).Equipments.get(j).DisplayEquipment() + "\n";
			}
		}
		return equipment;
	}

	public String DisplayDepartments1() {
		String dept = "";
		for (int i = 0; i < Depts.size(); i++) {
			dept += Depts.get(i).DisplayDepartment() + "\n";

		}
		return dept;
	}

	public String DisplayEquipmentIssuanceRecordUI() {
		String record = "";
		for (int i = 0; i < Depts.size(); i++) {
			for (int j = 0; j < Depts.get(i).Equipments.size(); j++) {

				for (int k = 0; k < Depts.get(i).Equipments.get(j).ISR.size(); k++) {
					record += Depts.get(i).Equipments.get(j).ISR.get(k).DisplayIssuanceRecord() + "\n";
				}
			}
		}
		return record;
	}

	public String DisplaySupplierUI() {
		String supp = "";
		for (int i = 0; i < Supp.size(); i++) {
			supp += Supp.get(i).DisplaySupplier1() + "\n";

		}
		System.out.print(supp);
		return supp;

	}

	public String DisplayEmployeeUI() {
		String emp = "";
		for (int i = 0; i < Depts.size(); i++) {
			for (int j = 0; j < Depts.get(i).EMP.size(); j++) {
				emp += Depts.get(i).EMP.get(j).DisplayEmployee1() + "\n";
			}
		}
		System.out.print(emp);
		return emp;
	}

	public String Requisitions() {
		String req = "";
		for (int i = 0; i < Depts.size(); i++) {
			for (int j = 0; j < Depts.get(i).Requisitions.size(); j++) {

				req += Depts.get(i).Requisitions.get(j).DisplayRequisitionsUI() + "\n";
				System.out.print(req);
			}
		}
		return req;
	}

	public String DisplayProductsUI() {
		String prod = "";
		for (int i = 0; i < Supp.size(); i++) {

			for (int j = 0; j < Supp.get(i).Products.size(); j++) {

				prod += Supp.get(i).Products.get(j).DisplayProductUI() + "\n";

			}
		}
		return prod;
	}

	public String ReqAprovals() {
		String apr = "";
		for (int i = 0; i < Depts.size(); i++) {

			for (int j = 0; j < Depts.get(i).RequisitionsApproval.size(); j++) {
				System.out.print(1);
				apr += Depts.get(i).RequisitionsApproval.get(j).DisplayReqApprovalUI() + "\n";
			}
		}
		return apr;
	}

	public String DisplayDeptISRUI() {
		String dept = "";
		for (int i = 0; i < Depts.size(); i++) {
			for (int j = 0; j < Depts.get(i).DeptIssuanceRecord.size(); j++) {
				dept += Depts.get(i).DeptIssuanceRecord.get(j).DisplayIssuanceRecord() + "\n";
			}
		}
		return dept;
	}

	public String DisplayAccountApprovalsUI() {
		String acc = "";
		for (int i = 0; i < Depts.size(); i++) {
			for (int j = 0; j < Depts.get(i).IC.AccApprovals.size(); j++) {
				acc += Depts.get(i).IC.AccApprovals.get(j).DisplayAccountApprovalsUI() + "\n";
			}
		}
		return acc;
	}

	public String invenClerkUI() {
		String IC = "";
		for (int i = 0; i < Depts.size(); i++) {
			IC += Depts.get(i).IC.InventoryClerkUI() + "\n";

		}
		return IC;

	}

	public String EquipmentDescription() {

		String desc = "";
		for (int i = 0; i < Depts.size(); i++) {
			for (int j = 0; j < Depts.get(i).Equipments.size(); j++) {
				if (Depts.get(i).Equipments.get(j).EQDescription != null)
					desc += Depts.get(i).Equipments.get(j).EQDescription.EQDescriptionUI() + "\n";
			}
		}
		return desc;
	}

	public int GetID() {

		int id = 0;
		for (int i = 0; i < Depts.size(); i++) {
			if (ActiveLoginID() == Depts.get(i).IC.getID()) {
				if (Depts.get(i).IC.getDeptID() == Depts.get(i).getID()) {
					id = Depts.get(i).getID();
				}
			}
		}
		return id;

	}

	public int getAccountaprrovalID() {
		int id = 0;
		for (int i = 0; i < Depts.size(); i++) {
			for (int j = 0; j < Depts.get(i).IC.AccApprovals.size(); j++) {
				id = Depts.get(i).IC.AccApprovals.get(j).getID();
			}
		}
		return id;
	}
}
