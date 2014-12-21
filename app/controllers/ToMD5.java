package controllers;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ToMD5 {

	
	public static String convertToMD5(String plaintext) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] array = md.digest(plaintext.getBytes("UTF-8"));
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<array.length;i++)
		{
			sb.append(Integer.toHexString(( array[i] & 0xFF) | 0x100).substring(1,3));
		}
		return sb.toString();

	}
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		System.out.println(new ToMD5().convertToMD5("1234"));
	}
}
