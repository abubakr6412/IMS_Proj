package TestCases;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import application.Global;

public class StoreTest {
	@Before
	public void populate1(){
		Global.store.PopulateSystem();
	}
	@Test
	public void storeUsecase1Login(){
//	Global.store.DisplayEquipmentIssuanceRecordUI();
//	Global.store.DisplayEquipmentsUI();
	Global.store.SystemLL("abu6412", "2175");
	assertEquals(Global.store.SystemLogin("abu6412", "2175"),2);
	Global.store.LogoutID();
	}
	@Test
	public void storeUsecase2Login(){
//	Global.store.DisplayEquipmentIssuanceRecordUI();
//	Global.store.DisplayEquipmentsUI();
	Global.store.SystemLL("Hay529", "5299");
	assertEquals(Global.store.SystemLogin("Hay529", "5299"),3);
	Global.store.LogoutID();
	}
	@Test
	public void storeUsecase3Login(){
//		Global.store.DisplayEquipmentIssuanceRecordUI();
//		Global.store.DisplayEquipmentsUI();
		Global.store.SystemLL("asim662", "6626");
		assertEquals(Global.store.SystemLogin("asim662", "6626"),1);
		Global.store.LogoutID();
		}
	@Test
	public void storeUsecase4LoginFail(){
//		Global.store.DisplayEquipmentIssuanceRecordUI();
//		Global.store.DisplayEquipmentsUI();
		Global.store.SystemLL("662", "6626");
		assertEquals(Global.store.SystemLogin("662", "6626"),-1);
		Global.store.LogoutID();
		}	
	
	
	
	
	
}
