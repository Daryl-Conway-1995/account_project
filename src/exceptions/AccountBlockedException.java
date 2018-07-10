package exceptions;

public class AccountBlockedException extends Exception{
	public AccountBlockedException() {}
	public AccountBlockedException(String message){
	    super(message);
	}
}
