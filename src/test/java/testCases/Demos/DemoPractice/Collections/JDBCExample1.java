package testCases.Demos.DemoPractice.Collections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*1) Create a connection
2) Create a query/statement
3) Execute statement/query
4) close connection
 * 
 */
public class JDBCExample1 {

	public static void main(String[] args) throws SQLException {
	
		//1)Create a connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/pdborcl","hr","hr");
		
		//2) Create a query/statement
		Statement stmt=con.createStatement();
		//String s="insert into student values(105,'JOHN')";
		//String s="update student set sname='SMITH' where sid=103";
		String s="delete from student where sid=103";
		
			
		//3) Execute statement/query
		stmt.executeQuery(s);
		
		//4) close connection
		con.close();
		
		System.out.println("Program compelted");
	}

}
