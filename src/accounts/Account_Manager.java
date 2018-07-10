package accounts;
import java.util.HashMap;
import java.util.Map;

import constants.constants;
import accounts.Account;

public class Account_Manager {
	 HashMap<Integer, Account> hmap = new HashMap<>();
	 
	 public int lengthOfMap() {
		 return hmap.size();
	 }
	 public String addAccount(int key, Account account) {
		 if(hmap.containsKey(key)) {
			 return constants.INVALID_KEY_LOG;
		 }
		 else {
			 hmap.put(key, account);
			 return constants.ADDED_LOG;
		 }
	 }
	 public String deleteAccount(int key) {
		 if(hmap.containsKey(key)) {
			 hmap.remove(key);
			 return constants.REMOVE_LOG;
		 }
		 else {
			 return constants.INVALID_LOG+key;
		 }
	 }

	public Account getAccount(int key) {

		if (hmap.containsKey(key)) {
			return hmap.get(key);
		} else {
			Account failAccount = new Account();
			return failAccount;
		}

	}
	 public String editAccount(int key,String firstName, String lastName,String accountNumber) {
		 if(hmap.containsKey(key)) {
			 hmap.get(key).setFirstName(firstName);
			 hmap.get(key).setLastName(lastName);
			 hmap.get(key).setAccountNumber(accountNumber);
			 return constants.UPDATE_LOG;
		 }
		 else {
			 return constants.INVALID_LOG+key;
		 }
	 }
	 public String accountFail() {
		 for (Map.Entry<Integer, Account> entry : hmap.entrySet()) {
			    if (entry.getValue().getAccountNumber()=="123456")
			    {
			    	return constants.ILLIGAL_ACCOUNT_LOG;
			    }
			}
		 return constants.NON_ILLIGAL_ACCOUNT_LOG;
	 
	 }
	 
	public int searchFirstName(String string) {
		int count = 0;
		for (Map.Entry<Integer, Account> entry : hmap.entrySet()) {
		    if (entry.getValue().getFirstName().equals(string))
		    {
		    	count++;
		    }
		}
	 return count;
	}
}