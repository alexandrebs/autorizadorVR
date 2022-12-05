package br.com.api.autorizadorVR;

import java.security.*;
import java.math.*;

public class Teste {

	public static void main(String[] args) throws Exception {
	
		 String senha1 ="1234";
		 String senha2 ="1234";
	       MessageDigest m = MessageDigest.getInstance("MD5");
	       m.update(senha1.getBytes(),0,senha1.length());
	       System.out.println("MD5: "+new BigInteger(1,m.digest()).toString(16));
	       m.reset();
	       m.update(senha2.getBytes(),0,senha1.length());
	       System.out.println("MD5: "+new BigInteger(1,m.digest()).toString(16));

	}

}
