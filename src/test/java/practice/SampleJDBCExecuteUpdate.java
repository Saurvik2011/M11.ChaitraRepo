package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {
	
	public static void main(String[] args) throws SQLException {
		
		Driver driverRef = new Driver();
		
		//Step 1: REgister the driver/database
		DriverManager.registerDriver(driverRef);
		
		//Step 2: establish connection with DB
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/m11db", "root", "root");
		
		//Step 3: Issue create statement
		Statement state = con.createStatement();
		
		//Step 4: execute a query
		int result = state.executeUpdate("insert into candidate_info values('spiderman',6,'Newyork');");
		if(result==1)
		{
			System.out.println("Data added");
		}
		
		ResultSet result1 = state.executeQuery("select * from candidate_info;");
		while(result1.next())
		{
			System.out.println(result1.getString(1)+"-"+result1.getInt(2)+"-"+result1.getString(3));
		}
		
		
		//Step 5: close the DB
		con.close();
	}

}
