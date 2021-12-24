package TestCases;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import application.Employee;
import application.Global;

public class EmployeeTest {

	@Before
	public void populate1(){
		Global.store.PopulateSystem();
	}
	@Test
	public void EmployeeTest1() {
		int a=Global.store.Depts.get(0).EMP.get(0).getDeptID();
		assertEquals(a, 1391);
		
	}

	@Test
	public void EmployeeTest2() {

		String EmployeeName = "Hayiqa Fatima";
		assertEquals(Global.store.Depts.get(0).EMP.get(0).getName(), EmployeeName);
	}

	@Test
	public void EmployeeTest4() {
		Global.store.SystemLL("Hay529","5299");
		Global.store.LogoutID();
		assertNotEquals(Global.store.ActiveLoginID(),529);
		
	}
	@Test
	public void EmployeeFailTest1() {
		for(int i=0;i<Global.store.Depts.size();i++) {
			for(int j=0;j<Global.store.Depts.get(i).EMP.size();j++) {
				assertEquals(Global.store.Depts.get(i).EMP.get(j).getEMPID(),428);
			}
		}
	}
	
	@Test
	public	void EmployeeFailTest2() {
		Global.store.SystemLL("abu6412","2175");
		
	assertEquals(Global.store.ActiveLoginID(),4130);
	}
	
	
}
