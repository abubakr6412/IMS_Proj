package TestCases;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import application.Global;
import application.Supplier;

public class SupplierTest {

	@Before
	public void populate1(){
		Global.store.PopulateSystem();
	}
	@Test
	public void SupplierName()
	{
		assertEquals(Global.store.Supp.get(0).getName(),"Asim Ali");
	}
	@Test
	public void SupplierAge()
	{
		assertEquals(Global.store.Supp.get(0).getAge(),24);
	}
	@Test
	public void Supplierid()
	{
		assertEquals(Global.store.Supp.get(0).getSupplierID(),662);
	}
@Test
public void Failcase()
{
	Supplier e=new Supplier("",620,2,3,"","","");
	Global.store.Supp.add(e);
	assertEquals(Global.store.Supp.get(1).getSupplierID(),620);
}

}
