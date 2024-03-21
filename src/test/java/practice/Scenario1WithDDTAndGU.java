package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;

public class Scenario1WithDDTAndGU {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		//Step 1:Create objects of Utility classes
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		/* Read data Common Data - property file */
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME =pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");

		/* Read Test Data - Excel File */
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);

		// Step 1: Launch the browser
		WebDriver driver = new EdgeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitelyWait(driver);

		driver.get(URL);

		// Step 2: Login To Application
		
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		LoginPage lp = new LoginPage(driver);
	    
		lp.loginToApp(USERNAME, PASSWORD);
	
//		lp.getUserNameEdt().sendKeys(USERNAME);
//		lp.getPasswordEdt().sendKeys(PASSWORD);
//		lp.getLoginBtn().click();
		
		
		
		
		
		

		// Step 3: Navigate to Contacts link
		driver.findElement(By.linkText("Contacts")).click();

		// Step 4: Click ON Create Contact Look up Image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		// Step 5: Create Contact With Mandatory Information and save
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Step 6: Validate for the Contact
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(contactHeader);

		if (contactHeader.contains(LASTNAME)) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}

		// Step 7: Logout of Application
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

		sUtil.mouseOverAction(driver, ele);
		
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Logout successsful");

		// Step 8: Close the browser
		driver.quit();

	}

		
	}


