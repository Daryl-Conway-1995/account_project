package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import accounts.Account_Manager;
import accounts.Account;

public class Account_Test {

	Account_Manager accountManager = new Account_Manager();
	Account firstAccount = new Account("1234","Bob","Smith");
	Account secondAccount = new Account("4321","John","Johnson");
	
	@Test
	public void testAddAccount() {
		assertEquals("account added",accountManager.addAccount(0, firstAccount));
		assertEquals("invalid key entry.",accountManager.addAccount(0, firstAccount));
	}
	
	@Test
	public void testGetAccount() {
		assertEquals("",accountManager.getAccount(0).getAccountNumber());
		assertEquals("",accountManager.getAccount(1).getAccountNumber());
		
		accountManager.addAccount(0, firstAccount);
		assertEquals(firstAccount,accountManager.getAccount(0));
		assertEquals("",accountManager.getAccount(1).getAccountNumber());
		
		accountManager.addAccount(1, secondAccount);
		assertEquals(secondAccount,accountManager.getAccount(1));
	}
	
	@Test
	public void testEditAccounts() {
		accountManager.addAccount(0, firstAccount);
		assertEquals(firstAccount,accountManager.getAccount(0));
		assertEquals("account was not found at index 2",accountManager.editAccount(2, "fname", "lname", "number"));
		assertEquals("account has been updated.",accountManager.editAccount(0, "Bob", "Smith", "1234567890"));
		assertNotEquals("1234",accountManager.getAccount(0).getAccountNumber());
	}
	
	@Test
	public void testDeleteAccount() {
		accountManager.addAccount(0, firstAccount);
		accountManager.addAccount(1, secondAccount);
		assertEquals("account not found at index 2",accountManager.deleteAccount(2));
		assertEquals("account has been removed.",accountManager.deleteAccount(0));
		assertEquals("account has been removed.",accountManager.deleteAccount(1));
		assertEquals("account not found at index 0",accountManager.deleteAccount(0));
	}
}
