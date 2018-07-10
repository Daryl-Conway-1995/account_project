package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import accounts.Account_Manager;
import accounts.Account;
import constants.constants;

public class Account_Test {

	Account_Manager accountManager = new Account_Manager();
	Account firstAccount = new Account("1234","Bob","Smith");
	Account secondAccount = new Account("4321","John","Johnson");
	
	@Test
	public void testAddAccount() {
		assertEquals(constants.ADDED_LOG,accountManager.addAccount(0, firstAccount));
		assertEquals(constants.INVALID_KEY_LOG,accountManager.addAccount(0, firstAccount));
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
		assertEquals(constants.INVALID_LOG+"2",accountManager.editAccount(2, "fname", "lname", "number"));
		assertEquals(constants.UPDATE_LOG,accountManager.editAccount(0, "Bob", "Smith", "1234567890"));
		assertNotEquals("1234",accountManager.getAccount(0).getAccountNumber());
	}
	
	@Test
	public void testDeleteAccount() {
		accountManager.addAccount(0, firstAccount);
		accountManager.addAccount(1, secondAccount);
		assertEquals(constants.INVALID_LOG+"2",accountManager.deleteAccount(2));
		assertEquals(constants.REMOVE_LOG,accountManager.deleteAccount(0));
		assertEquals(constants.REMOVE_LOG,accountManager.deleteAccount(1));
		assertEquals(constants.INVALID_LOG+"0",accountManager.deleteAccount(0));
	}
	
	@Test 
	public void searchFirstNameTest()
	{
		Account_Manager accountmanager = new Account_Manager();
		Account account1 = new Account("1234","Bob","Smith");
		Account account2 = new Account("4321","Bob","Johnson");
		Account account3 = new Account("6666","Bob","Abcd");
		Account account4 = new Account("1111","John","Smith");
		Account account5 = new Account("2222","Jo","Smith");
		Account account6 = new Account("4444","John","Cena");
		accountmanager.addAccount(1, account1);
		accountmanager.addAccount(2, account2);
		accountmanager.addAccount(3, account3);
		accountmanager.addAccount(4, account4);
		accountmanager.addAccount(5, account5);
		accountmanager.addAccount(6, account6);
		assertEquals(3,accountmanager.searchFirstName("Bob")); 
		assertEquals(2,accountmanager.searchFirstName("John")); 
		assertEquals(1,accountmanager.searchFirstName("Jo")); 
		assertEquals(0,accountmanager.searchFirstName("kjewnbfiuewbfkuewhfiu"));
	}
}
