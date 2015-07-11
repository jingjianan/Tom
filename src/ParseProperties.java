

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class ParseProperties {
	private Properties p = new Properties();
	String value = null;
	
    public ParseProperties(String propertiespath){
    	this.load(propertiespath);
    }
    
    public void load(String path){
    	try {
		//	FileInputStream fis = new FileInputStream(path);
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			try {
				p.load(br);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
    public String getValue(String key){
    	value = p.getProperty(key).trim();
    	try {
			value = new String(value.getBytes("UTF-8"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
    	
    }
    
	public static void main(String[] args) {
		ParseProperties pp = new ParseProperties(System.getProperty("user.dir")+"/tool/test.properties");
		ParseProperties pt = new ParseProperties(System.getProperty("user.dir")+"/tool/locator.properties");
	    System.out.println(pp.getValue("url"));
	    System.out.println(pp.getValue("username"));
	    System.out.println(pp.getValue("password"));
	    System.out.println(pt.getValue("loc_username"));
	    System.out.println(pt.getValue("loc_password"));
	    System.out.println(pt.getValue("loc_submit"));
	}

}
