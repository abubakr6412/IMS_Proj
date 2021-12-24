package storage;
import application.*;
import java.util.ArrayList;

public interface PersistentHandler {
	ArrayList<Department> importDept(ArrayList<Department> data);
	ArrayList<Supplier> importSupplier(ArrayList<Supplier> supplier);
	void addtoAccountApporvalProfile(AccountApproval account);
	void deleteAccountApproval(int id);
	void addtoAccountProfile(Account A);
	void addEmployee(Employee data);
	void addReqApproval(RequisitionApproval data);
	void updateRequistion(int id);
	void addEquipmentDescription(EquipmentDescription data);
	void addEquipment(Equipment data);
	void updateIR(IssuanceRecord data);
	void  updateEmployee(Employee data);
	void updateIC(InventoryClerk data);
	void updateSupplier(Supplier data);
	void addRequisition(Requisition data);
	
}
