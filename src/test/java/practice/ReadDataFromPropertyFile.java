package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	
	public static void main(String[] args) throws IOException {
		
		//Step 1: Open the document in Java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Step 2: Create object of Properties class from Java.util
		Properties p = new Properties();
		
		//Step 3: LOad the document to properties class
		p.load(fis);
		
		//Step 4: provide the key and fetch the value
		String value = p.getProperty("username");
		System.out.println(value);
		
		String value1 = p.getProperty("url");
		System.out.println(value1);
		
	}

}
