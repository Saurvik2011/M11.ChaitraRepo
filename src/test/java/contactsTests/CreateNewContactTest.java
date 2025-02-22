package contactsTests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;


@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateNewContactTest extends BaseClass{

	@Test(groups = "SmokeSuite")
	public void createNewContactWithMandatoryFields() throws IOException, InterruptedException
	{
		/* Read Test Data - Excel File */
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);

		// Step 3: Navigate to Contacts link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();

		// Step 4: Click ON Create Contact Look up Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();

		// Step 5: Create Contact With Mandatory Information and save
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME);
		
		// Step 6: Validate for the Contact
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.captureContactHeader();
		 
        Assert.assertTrue(contactHeader.contains(LASTNAME));
        System.out.println(contactHeader);
	}
	
	
	@Test
	public void sample()
	{
		System.out.println("Demo");
	}

}
