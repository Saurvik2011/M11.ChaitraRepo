package contactsTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
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

public class CreateContactWithLeadSourceTest extends BaseClass {

	@Test(groups = "RegressionSuite")
	public void createContactWithLeadSource() throws IOException, InterruptedException
	{
	
		/* Read Test Data - Excel File */
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 2);
		String LEADSOURCE = eUtil.readDataFromExcel("Contacts", 4, 3);

		// Step 3: Navigate to Contacts link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();

		// Step 4: Click ON Create Contact Look up Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();

		// Step 5: Create Contact With Mandatory Information and save
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME, LEADSOURCE);

		// Step 6: Validate for the Contact
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.captureContactHeader();
        Assert.assertTrue(contactHeader.contains(LASTNAME));
		System.out.println(contactHeader);

		

	}

}
