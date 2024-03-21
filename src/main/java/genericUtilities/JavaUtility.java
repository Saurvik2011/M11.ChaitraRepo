package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This utility consits of Java specific methods
 * @author Chaitra M
 *
 */
public class JavaUtility {
	
	/**
	 * This method return the current date in format
	 * @return
	 */
	public String getDate()
	{
		Date d = new Date();
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yy hh-mm-ss");
		String date = f.format(d);
		return date;
	}
	

}
