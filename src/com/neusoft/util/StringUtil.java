package com.neusoft.util;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class StringUtil {
	public static String nvlTOString(Object inObject,String defaultString){
		String retString = "";
		if(inObject!=null){
			retString=String.valueOf(inObject).toString();
		}else{
			retString=defaultString;
		}
		return retString;
	}
	public static String getValueByKey(Map inObject,String key){
		String valueStr = "";
		try{
			valueStr=nvlTOString(inObject.get(key),"");
		}catch(Exception e){
			valueStr = "";
		}
		return valueStr;
	}
	public static void main(String args[]){
		Map map =new HashMap();
		System.out.print(StringUtil.nvlTOString(null, "131"));
		
	}
	public static int getInt(String a, int b) {

		try {
			return Integer.parseInt(a);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public static Document transStr2Doc(String str) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
        factory.setNamespaceAware(false);  
        DocumentBuilder builder = factory.newDocumentBuilder();  
        InputSource is = new InputSource();  
        is.setCharacterStream(new StringReader(str));  
        Document doc = builder.parse(is);
        return doc;
	}
}
