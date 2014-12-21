package controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
	public static Pattern pattern;
	public static Matcher matcher;
	
	public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public static boolean validate(String email){
		
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		if(matcher.matches())
				return true;
		return false;
	}

}
