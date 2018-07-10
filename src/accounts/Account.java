package accounts;



public class Account {
	private String AccountNumber;
	private String firstName;
	private String lastName;
	
	public Account()
	{
		this.AccountNumber = "";
		this.firstName = "";
		this.lastName = "";
	}
	
	public Account(String accountNumber, String firstName, String lastName) {
		this.AccountNumber = accountNumber;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}
	@Override
	public String toString() {
		return "account [AccountNumber=" + AccountNumber + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
