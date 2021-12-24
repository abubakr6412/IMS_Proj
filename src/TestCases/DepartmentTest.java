package TestCases;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import application.Department;
import application.Global;
import application.Store;

public class DepartmentTest {
	@Before
	public void populate(){
		Global.store.PopulateSystem();
	}
	
	@Test
	public void DepartmentID() {
	assertEquals(Global.store.Depts.get(0).getID(),1391);
	}
	@Test
	public void DepartmentName() {
		assertEquals(Global.store.Depts.get(0).getName(),"Medicene");
	}
	@Test
	public void DepartmentPersonelCount() {
		assertEquals(Global.store.Depts.get(0).getPersonnelCount(),46);
	}
	@Test
	public void DepartmentIC()
	{
		assertEquals(Global.store.Depts.get(0).IC.getID(),2175);
	}

	@Test
	public void DeptTest1() {

		int deptid = Global.store.Depts.get(0).getID();
		assertEquals(deptid, 1391);

	}

	@Test
	public	void DeptTest2() {

		assertEquals("1391,Medicene,Plot No.8 Israr Road,46", Global.store.Depts.get(0).DisplayDepartment());

	}

	@Test
	public void DeptIDTEST() {
		int deptid =1391;
		for (int i = 0; i < Global.store.Depts.size(); i++) {
			assertEquals(deptid, Global.store.Depts.get(i).getID());
		}

	}
	
	
	
	@Test
	public void DeptFailTest2() {
		Global.store.SystemLL("Hay529","5299");

		assertEquals(Global.store.ActiveLoginID(),5299);
		
		
	}


	
	
}
