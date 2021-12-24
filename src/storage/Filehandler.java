package storage;
import application.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Filehandler implements PersistentHandler {

	public ArrayList<Department> importDept(ArrayList<Department> depts) {

		File txt = new File("src/storage/Dept.txt");
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

		ArrayList<Department> Depts1 = depts;

		for (int i = 0; i < simpleArray.length; i++) {

			String pipeDelimited = simpleArray[i];
			String[] arguments = pipeDelimited.split(",");
			Department temp = new Department(Integer.parseInt(arguments[0]), arguments[1], arguments[2],
					Integer.parseInt(arguments[3]));
			Depts1.add(temp);
		}

		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("src/storage/InventoryClerk.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String str;

		List<String> list = new ArrayList<String>();
		try {
			while ((str = in.readLine()) != null) {
				list.add(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String[] stringArr = list.toArray(new String[0]);

		for (int i = 0; i < stringArr.length; i++) {
			String[] tokens = stringArr[i].split(",");

			for (int j = 0; j < Depts1.size(); j++) {
				if (Integer.parseInt(tokens[1]) == Depts1.get(j).getID()) {
					Depts1.get(j).IC = new InventoryClerk(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]),
							Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), tokens[4], tokens[5], tokens[6],
							tokens[7]);
				}
			}

		}

		BufferedReader in1 = null;
		try {
			in1 = new BufferedReader(new FileReader("src/storage/Employee.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String str1;

		List<String> list1 = new ArrayList<String>();
		try {
			while ((str1 = in1.readLine()) != null) {
				list1.add(str1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String[] stringArr1 = list1.toArray(new String[0]);

		for (int i = 0; i < stringArr1.length; i++) {
			String[] tokens1 = stringArr1[i].split(",");

			for (int j = 0; j < Depts1.size(); j++) {
				int counter = 0;
				if (Depts1.get(j).getID() == Integer.parseInt(tokens1[1])) {
					{
						Employee testemp = new Employee(Integer.parseInt(tokens1[0]), Integer.parseInt(tokens1[1]),
								Integer.parseInt(tokens1[2]), Integer.parseInt(tokens1[3]), tokens1[4], tokens1[5],
								tokens1[6], tokens1[7]);
						Depts1.get(j).EMP.add(testemp);

					}

				}

			}

		}

		BufferedReader in11 = null;
		try {
			in11 = new BufferedReader(new FileReader("src/storage/Equipment.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String str11;

		List<String> list11 = new ArrayList<String>();
		try {
			while ((str11 = in11.readLine()) != null) {
				list11.add(str11);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String[] stringArr11 = list11.toArray(new String[0]);

		for (int i = 0; i < stringArr11.length; i++) {
			String[] tokens1 = stringArr11[i].split(",");
			for (int j = 0; j < Depts1.size(); j++) {

				if (Depts1.get(j).getID() == Integer.parseInt(tokens1[1])) {
					{

						Equipment testeqp = new Equipment(Integer.parseInt(tokens1[0]), Integer.parseInt(tokens1[1]),
								Integer.parseInt(tokens1[2]), tokens1[3]);
						Depts1.get(j).Equipments.add(testeqp);

					}

				}

			}

		}

		BufferedReader in111 = null;
		try {
			in111 = new BufferedReader(new FileReader("src/storage/EquipmentDescription.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String str111;

		List<String> list111 = new ArrayList<String>();
		try {
			while ((str111 = in111.readLine()) != null) {
				list111.add(str111);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String[] stringArr111 = list111.toArray(new String[0]);

		for (int i = 0; i < stringArr111.length; i++) {
			String[] tokens1 = stringArr111[i].split(",");
			for (int j = 0; j < Depts1.size(); j++) {

				for (int k = 0; k < Depts1.get(j).Equipments.size(); k++) {
					{

						if (Integer.parseInt(tokens1[0]) == Depts1.get(j).Equipments.get(k).getEquipmentID()) {

							EquipmentDescription testeqpdesc = new EquipmentDescription(Integer.parseInt(tokens1[0]),
									tokens1[1], tokens1[2]);

							Depts1.get(j).Equipments.get(k).EQDescription = (testeqpdesc);

						}

					}

				}

			}

		}
		BufferedReader in1111 = null;
		try {
			in1111 = new BufferedReader(new FileReader("src/storage/IssuanceRecord.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String str1111;

		List<String> list1111 = new ArrayList<String>();
		try {
			while ((str1111 = in1111.readLine()) != null) {
				list1111.add(str1111);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String[] stringArr1111 = list1111.toArray(new String[0]);

		for (int i = 0; i < stringArr1111.length; i++) {
			String[] tokens1 = stringArr1111[i].split(",");
			for (int j = 0; j < Depts1.size(); j++) {

				for (int k = 0; k < Depts1.get(j).Equipments.size(); k++) {

					if (Integer.parseInt(tokens1[1]) == Depts1.get(j).Equipments.get(k).getEquipmentID()) {

						IssuanceRecord temp = new IssuanceRecord(Integer.parseInt(tokens1[0]),
								Integer.parseInt(tokens1[1]), Integer.parseInt(tokens1[2]), tokens1[3], tokens1[4]);

						Depts1.get(j).Equipments.get(k).ISR.add(temp);
					}

				}

			}

		}

		// Populating Accounts of Personnel
		BufferedReader in11111 = null;
		try {
			in11111 = new BufferedReader(new FileReader("src/storage/Account.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String str11111;

		List<String> list11111 = new ArrayList<String>();
		try {
			while ((str11111 = in11111.readLine()) != null) {
				list11111.add(str11111);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String[] stringArr11111 = list11111.toArray(new String[0]);

		for (int i = 0; i < stringArr11111.length; i++) {
			String[] tokens12 = stringArr11111[i].split(",");

			for (int j = 0; j < Depts1.size(); j++) {

				for (int k = 0; k < Depts1.get(j).EMP.size(); k++) {

					if (tokens12[2].equals(String.valueOf(Depts1.get(j).EMP.get(k).getEMPID()))) {

						Account empAccount = new Account(tokens12[0], tokens12[1], Integer.parseInt(tokens12[2]));
						Depts1.get(j).EMP.get(k).EMPaccount = empAccount;

					}

				}

				if (tokens12[2].equals(String.valueOf(Depts1.get(j).IC.getID()))) {
					Account ICAccount = new Account(tokens12[0], tokens12[1], Integer.parseInt(tokens12[2]));
					Depts1.get(j).IC.ICaccount = ICAccount;

				}

			}

		}

		BufferedReader in111111 = null;
		try {
			in111111 = new BufferedReader(new FileReader("src/storage/AccApprovals.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String str111111;

		List<String> list111111 = new ArrayList<String>();
		try {
			while ((str111111 = in111111.readLine()) != null) {
				list111111.add(str111111);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String[] stringArr111111 = list111111.toArray(new String[0]);

		for (int i = 0; i < stringArr111111.length; i++) {
			String[] tokens12 = stringArr111111[i].split(",");

			for (int j = 0; j < Depts1.size(); j++) {

				if (Depts1.get(j).getID() == Integer.parseInt(tokens12[3])) {
					AccountApproval temp = new AccountApproval(tokens12[0], tokens12[1], Integer.parseInt(tokens12[2]),
							Integer.parseInt(tokens12[3]));

					Depts1.get(j).IC.AccApprovals.add(temp);

					DatabaseHandler DBtemp = new DatabaseHandler();

				}

			}

		}

		BufferedReader in1111111 = null;
		try {
			in1111111 = new BufferedReader(new FileReader("src/storage/Requisitions.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String str1111111;

		List<String> list1111111 = new ArrayList<String>();
		try {
			while ((str1111111 = in1111111.readLine()) != null) {
				list1111111.add(str1111111);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String[] stringArr1111111 = list1111111.toArray(new String[0]);

		for (int i = 0; i < stringArr1111111.length; i++) {
			String[] tokens12 = stringArr1111111[i].split(",");

			for (int j = 0; j < Depts1.size(); j++) {

				if (Depts1.get(j).getID() == Integer.parseInt(tokens12[1])) {
					Requisition temp = new Requisition(Integer.parseInt(tokens12[0]), Integer.parseInt(tokens12[1]), Integer.parseInt(tokens12[2]),
							Integer.parseInt(tokens12[3]));
					//System.out.println(tokens12[2]);

					Depts1.get(j).Requisitions.add(temp);
				}

			}

		}

		return Depts1;

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

		for (int i = 0; i < simpleArray.length; i++) {

			String pipeDelimited = simpleArray[i];
			String[] arguments = pipeDelimited.split(",");
			Supplier temp = new Supplier(arguments[0], Integer.parseInt(arguments[1]), Integer.parseInt(arguments[2]),
					Integer.parseInt(arguments[3]), arguments[4], arguments[5], arguments[6]);
			supplier1.add(temp);
		}

		BufferedReader in1 = null;
	
		try {
			in1 = new BufferedReader(new FileReader("src/storage/Product.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String str1;

		List<String> list1 = new ArrayList<String>();
		try {
			while ((str1 = in1.readLine()) != null) {
				list1.add(str1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String[] stringArr1 = list1.toArray(new String[0]);

		for (int i = 0; i < stringArr1.length; i++) {
			String[] tokens1 = stringArr1[i].split(",");

			for (int j = 0; j < supplier1.size(); j++) {
				int counter = 0;
				if (supplier1.get(j).getSupplierID() == Integer.parseInt(tokens1[0])) {
					{
						Product testpdt = new Product(Integer.parseInt(tokens1[0]), Integer.parseInt(tokens1[1]),
								tokens1[2], tokens1[3]);
						supplier1.get(j).Products.add(testpdt);
						System.out.println(Integer.parseInt(tokens1[0]));
					}

				}

			}

		}

		// Adding from accounts
		BufferedReader in11 = null;
		try {
			in11 = new BufferedReader(new FileReader("src/storage/Account.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String str11;

		List<String> list11 = new ArrayList<String>();
		try {
			while ((str11 = in11.readLine()) != null) {
				list11.add(str11);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String[] stringArr11 = list11.toArray(new String[0]);

		for (int i = 0; i < stringArr11.length; i++) {
			String[] tokens1 = stringArr11[i].split(",");

			for (int j = 0; j < supplier1.size(); j++) {

				if (supplier1.get(j).getSupplierID() == Integer.parseInt(tokens1[2])) {
					supplier1.get(j).Supplieraccount = new Account(tokens1[0], tokens1[1],
							Integer.parseInt(tokens1[2]));

				}

			}

		}

		BufferedReader in111 = null;
		try {
			in111 = new BufferedReader(new FileReader("src/storage/Deliveries.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String str111;

		List<String> list111 = new ArrayList<String>();
		try {
			while ((str111 = in111.readLine()) != null) {
				list111.add(str111);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String[] stringArr111 = list111.toArray(new String[0]);

		for (int i = 0; i < stringArr111.length; i++) {
			String[] tokens1 = stringArr111[i].split(",");

			for (int j = 0; j < supplier1.size(); j++) {

				if (supplier1.get(j).getSupplierID() == Integer.parseInt(tokens1[0])) {
					EquipmentDelivery temp = new EquipmentDelivery(Integer.parseInt(tokens1[0]),
							Integer.parseInt(tokens1[1]), Integer.parseInt(tokens1[2]), Integer.parseInt(tokens1[3]),
							tokens1[4], tokens1[5], tokens1[6], tokens1[7]);

					supplier1.get(j).Deliveries.add(temp);

				}

			}

		}

		return supplier1;

	}
	public void addtoAccountApporvalProfile(AccountApproval account) {};
	public void deleteAccountApproval(int id) {};
	public void addtoAccountProfile(Account data) {};
	public void addEmployee(Employee A) {};
	public void addReqApproval(RequisitionApproval data) {};
	public void updateRequistion(int id) {};	
	public void addEquipmentDescription(EquipmentDescription data) {};
	public void addEquipment(Equipment data) {};
	public void updateIR(IssuanceRecord data) {};
	public void  updateEmployee(Employee data) {};
	public void updateIC(InventoryClerk data) {};
	public void updateSupplier(Supplier data) {};
	public void addRequisition(Requisition data) {};
}
