package application;

import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
import accounts.*;
import com.thoughtworks.xstream.XStream;

public class app {

	public static void main(String[] args) {
		Account_Manager accountManager = new Account_Manager();
		Account account1 = new Account("1234","Daryl","Conway");
		ObjectMapper mapper = new ObjectMapper();
		XStream xstream = new XStream();
		
		accountManager.addAccount(0, account1);
		
		try {
			String jsonStr = mapper.writeValueAsString(accountManager.getAccount(0));
			System.out.println(jsonStr);
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		String XMLStr = xstream.toXML(accountManager.getAccount(0));
		System.out.println(XMLStr);
	}
}