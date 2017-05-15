package io.swagger.util;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Validacao {
	
	public static boolean EmailInvalido(String email) {
	   try {
	      InternetAddress emailAddr = new InternetAddress(email);
	      emailAddr.validate();
	      
	      return false;
	   } catch (AddressException ex) {
	      return true;
	   }
	}

}
