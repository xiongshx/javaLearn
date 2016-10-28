package com.neusoft.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CommonUtil {

	public static String randomUUID(){
		String uuid = java.util.UUID.randomUUID().toString();
		uuid = uuid.replaceAll("-", "");
		return uuid;
	}
	
	public static long convertStrToDate(String dateStr,String dateFormat){
		java.util.Date date = new java.util.Date();
		try {
			DateFormat format = new SimpleDateFormat(dateFormat);
		
			date = format.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date.getTime();
	}
}
