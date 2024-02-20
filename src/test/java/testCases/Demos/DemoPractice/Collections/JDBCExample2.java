package testCases.Demos.DemoPractice.Collections;

import java.sql.*;

/*1) Create a connection
2) Create a query/statement
3) Execute statement/query
4) close connection
 * 
 */
public class JDBCExample2 {

	public static void main(String[] args) throws SQLException {
	
		//1)Create a connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/pdborcl","hr","hr");
		
		//2) Create a query/statement
		Statement stmt=con.createStatement();
		String s="select * from employees";
		
			
		//3) Execute statement/query
		ResultSet rs=stmt.executeQuery(s);
		
		while(rs.next())
		{
			int eid=rs.getInt("EMPLOYEE_ID");
			String fname=rs.getString("FIRST_NAME");
			String lname=rs.getString("LAST_NAME");
			
			System.out.println(eid+"    "+fname+"   "+lname);
		}
		
		
		//4) close connection
		con.close();
		
		System.out.println("Program compelted");
	}

}
