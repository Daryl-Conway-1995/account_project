package accounts;
import java.util.HashMap;
import accounts.Account;

public class account_Manager {
	 HashMap<Integer, Account> hmap = new HashMap<>();
	 
	 public String addAccount(int key, Account account) {
		 if(hmap.containsKey(key)) {
			 return "invalid key entry.";
		 }
		 else {
			 hmap.put(key, account);
			 return "account added";
		 }
	 }
	 
	 public String deleteAccount(int key) {
		 if(hmap.containsKey(key)) {
			 hmap.remove(key);
			 return "account has been removed.";
		 }
		 else {
			 return "account not found at index "+key;
		 }
	 }
	 
	 public Account getAccount(int key) {
		 if(hmap.containsKey(key)) {
			 return hmap.get(key);
		 }
		 else {
			 Account failAccount = new Account();
			 return failAccount;
		 }
	 }
	 
	 public String editAccount(int key,String firstName, String lastName,String accountNumber) {
		 if(hmap.containsKey(key)) {
			 hmap.get(key).setFirstName(firstName);
			 hmap.get(key).setLastName(lastName);
			 hmap.get(key).setAccountNumber(accountNumber);
			 return "account has been updated.";
		 }
		 else {
			 return "account was not found at index "+key;
		 }
	 }
}