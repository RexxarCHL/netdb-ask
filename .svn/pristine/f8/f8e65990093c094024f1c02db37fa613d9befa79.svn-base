package netdb.courses.softwarestudio.asksite.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Service {
	MessageDigest m;
	
	public MD5Service(){
		try {
			m = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
		}
	}
	
	public byte[] digestMD5(String input){
		m.reset();
		try {
			m.update(input.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			return null;
		}
		return m.digest();
	}
}
