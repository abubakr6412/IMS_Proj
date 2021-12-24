package storage;
import application.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DatabaseHandler implements PersistentHandler {

	public Connection St() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sda", "root", "admin");
			return con;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public ArrayList<Department> importDept(ArrayList<Department> data) {

		data = new ArrayList<Department>();
		try {
             
			Connection con = this.St();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from department");

			while (rs.next()) {
				System.out.println(rs.getInt(1));
				data.add(new Department(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			Connection con = this.St();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from inventoryclerk");

			while (rs.next()) {
				for (int j = 0; j < data.size(); j++) {
					if (rs.getInt(5) == data.get(j).getID()) {
						data.get(j).IC = new InventoryClerk(rs.getInt(1), rs.getInt(5), rs.getInt(8), rs.getInt(3),
								rs.getString(7), rs.getString(2), rs.getString(6), rs.getString(4));
					}
				}
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			Connection con = this.St();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee");

			while (rs.next()) {
				for (int j = 0; j < data.size(); j++) {
					if (rs.getInt(5) == data.get(j).getID()) {
						Employee testemp = new Employee(rs.getInt(1), rs.getInt(5), rs.getInt(8), rs.getInt(3),
								rs.getString(7), rs.getString(2), rs.getString(6), rs.getString(4));
						data.get(j).EMP.add(testemp);
					}
				}
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			Connection con = this.St();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from equipment");

			while (rs.next()) {
				for (int j = 0; j < data.size(); j++) {
					if (rs.getInt(3) == data.get(j).getID()) {
						Equipment testeqp = new Equipment(rs.getInt(1), rs.getInt(3), rs.getInt(4), rs.getString(2));
						data.get(j).Equipments.add(testeqp);
					}
				}
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			Connection con = this.St();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from issuancerecord");

			while (rs.next()) {
				for (int j = 0; j < data.size(); j++) {
					for (int k = 0; k < data.get(j).Equipments.size(); k++) {

						if (rs.getInt(3) == data.get(j).Equipments.get(k).getEquipmentID()) {

							IssuanceRecord temp = new IssuanceRecord(rs.getInt(1), rs.getInt(3), rs.getInt(2),
									rs.getString(4), rs.getString(5));

							data.get(j).Equipments.get(k).ISR.add(temp);
						}
					}
				}
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			Connection con = this.St();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from equipmentDescription");

			while (rs.next()) {
				for (int j = 0; j < data.size(); j++) {

					for (int k = 0; k < data.get(j).Equipments.size(); k++) {
						{

							if (rs.getInt(1) == data.get(j).Equipments.get(k).getEquipmentID()) {

								EquipmentDescription testeqpdesc = new EquipmentDescription(rs.getInt(1),rs.getString(3),rs.getString(2));

								data.get(j).Equipments.get(k).EQDescription = (testeqpdesc);

							}

						}

					}
			}
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Connection con = this.St();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from RequisitonApproval");

			while (rs.next()) {
				for (int i = 0; i < data.size(); i++) {
				data.get(i).RequisitionsApproval.add(new RequisitionApproval(rs.getInt(2),rs.getInt(1),rs.getInt(5),rs.getString(4),rs.getString(3)));
				//int EquipID, int ReqID, int SupID, String Stat, String issuedate
				}
				}
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		try {
			Connection con = this.St();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Account");

			while (rs.next()) {
				for (int j = 0; j < data.size(); j++) {

					for (int k = 0; k < data.get(j).EMP.size(); k++) {

						if (rs.getString(1).equals(String.valueOf(data.get(j).EMP.get(k).getEMPID()))) {

							Account empAccount = new Account(rs.getString(3), rs.getString(2), rs.getInt(1));
							data.get(j).EMP.get(k).EMPaccount = empAccount;

						}

					}

					if (rs.getString(1).equals(String.valueOf(data.get(j).IC.getID()))) {
						Account ICAccount = new Account(rs.getString(3), rs.getString(2), rs.getInt(1));
						data.get(j).IC.ICaccount = ICAccount;

					}

				}
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			Connection con = this.St();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from AccountApproval");

			while (rs.next()) {
				for (int j = 0; j < data.size(); j++) {

					if (data.get(j).getID() == rs.getInt(2)) {
						AccountApproval temp = new AccountApproval(rs.getString(4), rs.getString(3), rs.getInt(1),
								rs.getInt(2));

						data.get(j).IC.AccApprovals.add(temp);

					}

				}
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			Connection con = this.St();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Requisiton");

			while (rs.next()) {
				for (int j = 0; j < data.size(); j++) {

					if (data.get(j).getID() == rs.getInt(2)) {
						Requisition temp = new Requisition(rs.getInt(3),rs.getInt(2), rs.getInt(4), rs.getInt(1));
//int empid,int Deptid, int Eqid, int Rqid
						data.get(j).Requisitions.add(temp);

					}

				}
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return data;
	}

	public ArrayList<Supplier> importSupplier(ArrayList<Supplier> supplier) {

		File txt = new File("src/storage/Supplier.txt");
		Scanner scan = null;
		try {
			scan = new Scanner(txt);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> data = new ArrayList<String>();
		while (scan.hasNextLine()) {
			data.add(scan.nextLine());
		}

		String[] simpleArray = data.toArray(new String[] {});

		ArrayList<Supplier> supplier1 = supplier;
		try {
			Connection con = this.St();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from supplier");

			while (rs.next()) {
				Supplier temp = new Supplier(rs.getString(6), rs.getInt(1), rs.getInt(7), rs.getInt(3), rs.getString(4),
						rs.getString(2), rs.getString(5));
				supplier1.add(temp);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			Connection con = this.St();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from product");

			while (rs.next()) {
				for (int j = 0; j < supplier1.size(); j++) {
					int counter = 0;
					if (supplier1.get(j).getSupplierID() == rs.getInt(4)) {
						{
							Product testpdt = new Product(rs.getInt(4),rs.getInt(1),rs.getString(3),rs.getString(2));
							supplier1.get(j).Products.add(testpdt);
							//System.out.println(rs.getInt(2));
						}

					}
			}
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		

		try {
			Connection con = this.St();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from equipmentdelivery");

			while (rs.next()) {
				for (int j = 0; j < supplier1.size(); j++) {

					if (supplier1.get(j).getSupplierID() == rs.getInt(9)) {
						EquipmentDelivery temp = new EquipmentDelivery(rs.getInt(9),rs.getInt(7),rs.getInt(5),rs.getInt(8),rs.getString(3),rs.getString(6),rs.getString(2),rs.getString(4));
						//int SuppiD, int EquipmentiD, int DeptiD, int price, String condition, String description,String company, String date

						supplier1.get(j).Deliveries.add(temp);

					}

				
			}
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			Connection con = this.St();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Account");

			while (rs.next()) {
				for (int j = 0; j < supplier1.size(); j++) {

					if (supplier1.get(j).getSupplierID() == rs.getInt(1)) {
						supplier1.get(j).Supplieraccount = new Account(rs.getString(3), rs.getString(2), rs.getInt(1));

					}

				}
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return supplier1;

	}

	public void populateIC(InventoryClerk data) {

		Configuration con = new Configuration();

		con.configure().addAnnotatedClass(InventoryClerk.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();

		InventoryClerk add = new InventoryClerk();
		add.setAddress(data.getAddress());
		add.setAge(data.getAge());
		add.setDeptID(data.getDeptID());
		add.setDOB(data.getDOB());
		add.setID(data.getID());
		add.setJoinDate(data.getJoinDate());
		add.setName(data.getName());
		add.setPNo(data.getPNo());

		session.save(add);

		trans.commit();
	}
	public void updateIC(InventoryClerk data) {

		Configuration con = new Configuration();

		con.configure().addAnnotatedClass(InventoryClerk.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();

		InventoryClerk add =session.get(InventoryClerk.class, data.getID());
		add.setAddress(data.getAddress());
		add.setAge(data.getAge());
		add.setDeptID(data.getDeptID());
		add.setDOB(data.getDOB());
		
		add.setJoinDate(data.getJoinDate());
		add.setName(data.getName());
		add.setPNo(data.getPNo());

		session.update(add);

		trans.commit();
	}

	public void populateDepartment(Department data) {

		Configuration con = new Configuration();

		con.configure().addAnnotatedClass(Department.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();

		Department add = new Department();
		add.setID(data.getID());
		add.setLocation(data.getLocation());
		add.setName(data.getName());
		add.setPersonnelCount(data.getPersonnelCount());

		session.save(add);

		trans.commit();
	}

	public void  addEmployee(Employee data) {

		Configuration con = new Configuration();

		con.configure().addAnnotatedClass(Employee.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();

		Employee add = new Employee();
		add.setAddress(data.getAddress());
		add.setAge(data.getAge());
		add.setDeptID(data.getDeptID());
		add.setDOB(data.getDOB());
		add.setEMPID(data.getEMPID());
		add.setJoinDate(data.getJoinDate());
		add.setName(data.getName());
		add.setPNo(data.getPNo());

		session.save(add);

		trans.commit();
	}
	public void  updateEmployee(Employee data) {

		Configuration con = new Configuration();

		con.configure().addAnnotatedClass(Employee.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();

		Employee add = session.get(Employee.class, data.getEMPID());
		add.setAddress(data.getAddress());
		add.setAge(data.getAge());
		add.setDeptID(data.getDeptID());
		add.setDOB(data.getDOB());
	
		add.setJoinDate(data.getJoinDate());
		add.setName(data.getName());
		add.setPNo(data.getPNo());

		session.update(add);

		trans.commit();
	}


	public void addEquipment(Equipment data) {

		Configuration con = new Configuration();

		con.configure().addAnnotatedClass(Equipment.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();

		Equipment add = new Equipment();
		add.setCondition(data.getCondition());
		add.setDeptID(data.getDeptID());
		add.setEquipmentID(data.getEquipmentID());
		add.setPrice(data.getPrice());

		session.save(add);

		trans.commit();
	}

	public void addEquipmentDescription(EquipmentDescription data) {

		Configuration con = new Configuration();

		con.configure().addAnnotatedClass(EquipmentDescription.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();

		EquipmentDescription add = new EquipmentDescription();
		add.setCompany(data.getCompany());
		add.setDescription(data.getDescription());
		add.setEquipmentID(data.getEquipmentID());

		session.save(add);

		trans.commit();
	}

	public void populateIssuanceRecord(IssuanceRecord data) {

		Configuration con = new Configuration();

		con.configure().addAnnotatedClass(IssuanceRecord.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();

		IssuanceRecord add = new IssuanceRecord();
		add.setEMPID(data.getEMPID());
		add.setEQID(data.getEQID());
		add.setIssueDate(data.getIssueDate());
		add.setRecordID(data.getRecordID());
		add.setReturnDate(data.getReturnDate());

		session.save(add);

		trans.commit();
	}

	public void addtoAccountProfile(Account data) {

		Configuration con = new Configuration();

		con.configure().addAnnotatedClass(Account.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();

		Account add = new Account();
		add.setID(data.getID());
		add.setPass(data.getPass());
		add.setUsername(data.getUsername());

		session.save(add);

		trans.commit();
	}

	public void addtoAccountApporvalProfile(AccountApproval data) {
		Configuration con = new Configuration();

		con.configure().addAnnotatedClass(AccountApproval.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();

		AccountApproval add = new AccountApproval();
		add.setDeptID(data.getDeptID());
		add.setID(data.getID());
		add.setUsername(data.getUsername());
		add.setPass(data.getPass());
		add.setUsername(data.getUsername());

		session.save(add);

		trans.commit();
	}

	public void populateProduct(Product data) {

		Configuration con = new Configuration();

		con.configure().addAnnotatedClass(Product.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();

		Product add = new Product();
		add.setMaunfacturedDate(data.getMaunfacturedDate());
		add.setProductID(data.getProductID());
		add.setProductDesc(data.getProductDesc());
		add.setSuppID(data.getSuppID());

		session.save(add);

		trans.commit();
	}

	public void populateSupplier(Supplier data) {

		Configuration con = new Configuration();

		con.configure().addAnnotatedClass(Supplier.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();

		Supplier add = new Supplier();
		add.setAddress(data.getAddress());
		add.setAge(data.getAge());
		add.setCompany(data.getCompany());
		add.setJoinDate(data.getJoinDate());
		add.setName(data.getName());

		add.setPNo(data.getPNo());
		add.setSupplierID(data.getSupplierID());
		session.save(add);

		trans.commit();
	}
	public void updateSupplier(Supplier data) {

		Configuration con = new Configuration();

		con.configure().addAnnotatedClass(Supplier.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();

		Supplier add = session.get(Supplier.class,data.getSupplierID());
		add.setAddress(data.getAddress());
		add.setAge(data.getAge());
		add.setCompany(data.getCompany());
		add.setJoinDate(data.getJoinDate());
		add.setName(data.getName());

		add.setPNo(data.getPNo());
		
		session.update(add);

		trans.commit();
	}

	public void addRequisition(Requisition data) {

		Configuration con = new Configuration();

		con.configure().addAnnotatedClass(Requisition.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();

		Requisition add = new Requisition();
		add.setDeptID(data.getDeptID());
		add.setEquipmentID(data.getEquipmentID());
		add.setRequisitionID(data.getRequisitionID());
		add.setEMPID(data.getEMPID());
		session.save(add);

		trans.commit();
	}

	public void addReqApproval(RequisitionApproval data) {

		Configuration con = new Configuration();

		con.configure().addAnnotatedClass(RequisitionApproval.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();

		RequisitionApproval add = new RequisitionApproval();
		add.setEquipmentID(data.getEquipmentID());
		add.setIssueDate(data.getIssueDate());
		add.setRequisitionID(data.getRequisitionID());
		add.setStatus(data.getStatus());
		add.setSuppID(data.getSuppID());
		session.save(add);

		trans.commit();
	}

	public void populateEquipmentDelivery(EquipmentDelivery data) {

		Configuration con = new Configuration();

		con.configure().addAnnotatedClass(EquipmentDelivery.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();

		EquipmentDelivery add = new EquipmentDelivery();
		add.setCompany(data.getCompany());
		add.setCondition(data.getCondition());
		add.setDeliveryDate(data.getDeliveryDate());
		add.setDeptID(data.getDeptID());
		add.setDescription(data.getDescription());
		add.setEquipmentID(data.getEquipmentID());
		add.setPrice(data.getPrice());
		add.setSuppID(data.getSuppID());
		session.save(add);

		trans.commit();
	}
	public void deleteAccountApproval(int id)
	{
		Configuration con = new Configuration();

		con.configure().addAnnotatedClass(AccountApproval.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		AccountApproval Approval1=session.get(AccountApproval.class,id);
		session.delete(Approval1);

		trans.commit();
	
	}
public void updateRequistion(int id) {
	Configuration con = new Configuration();

	con.configure().addAnnotatedClass(AccountApproval.class);

	SessionFactory sf = con.buildSessionFactory();
	Session session = sf.openSession();
	Transaction trans = session.beginTransaction();
			
	RequisitionApproval Approval1=session.get(RequisitionApproval.class,id);
	Approval1.setStatus("Delivered");
	session.update(Approval1);
	
	trans.commit();
}
public void updateIR(IssuanceRecord data) {

	Configuration con = new Configuration();

	con.configure().addAnnotatedClass(IssuanceRecord.class);

	SessionFactory sf = con.buildSessionFactory();
	Session session = sf.openSession();
	Transaction trans = session.beginTransaction();

	IssuanceRecord add =session.get(IssuanceRecord.class,data.getRecordID());
	add.setEMPID(data.getEMPID());
	add.setEQID(data.getEQID());
	add.setIssueDate(data.getIssueDate());
	add.setReturnDate(data.getReturnDate());

	session.update(add);

	trans.commit();
}
}
