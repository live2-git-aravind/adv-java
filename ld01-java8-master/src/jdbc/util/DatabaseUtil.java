package jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
	
private static final String ORACLEUSER = "hr";
private static final String ORACLEPASSWORD = "hr";
private static final String ORACLE_CONNECTION_STRING = "jdbc:oracle:thin:@localhost:1521:xe";

private static final String MYSQLUSER="root";
private static final String MYSQLPASSWORD="mysql";
private static final String MYSQL_CONNECTION_STRING = "jdbc:mysql://localhost:3306/sakila";


public static  Connection getConnection(DatabaseType databaseType) {
	switch(databaseType) {
	case ORACLEDB:{
		Connection connection = null;
			try {
				//loaded the driver for Oracle. 
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// A connection (session) with a specific database
				//sql statements are executed and results are returned within the context of  a connection
				connection = DriverManager.getConnection(ORACLE_CONNECTION_STRING,ORACLEUSER,ORACLEPASSWORD);
				return connection;
			} catch (ClassNotFoundException e) {
				System.out.println("EXCEPTION --> " +e);
			} catch (SQLException e) {
				System.out.println("EXCEPTION --> " +e);
			}
		return connection;
			
		
	}
	case MYSQLDB:{
		
		try {
			//loaded the driver for mysql.
			//class.forname("com.mysql.jdbc.Driver");
			 Class.forName("com.mysql.cj.jdbc.Driver");
			// A connection (session) with a specific database
			//sql statements are executed and results are returned within the context of  a connection
			Connection connection = DriverManager.getConnection(MYSQL_CONNECTION_STRING,MYSQLUSER,MYSQLPASSWORD);
			
			return connection;
		} catch (ClassNotFoundException e) {
			System.out.println("EXCEPTION --> " +e);
		} catch (SQLException e) {
			System.out.println("EXCEPTION --> " +e);
		}
	
		
	
}
	}
	return null;
}
static public void testoracleconnection(){
	Connection connection = null; 
	connection = DatabaseUtil.getConnection(DatabaseType.ORACLEDB);
	if(connection != null) {
	System.out.println("Connection to Oracle Successful!!");
	}
}
static public void testMySQLconnection(){
	Connection connection = null; 
	connection = DatabaseUtil.getConnection(DatabaseType.MYSQLDB);
	if(connection != null) {
	System.out.println("Connection to MySQL Successful!!");
	}
}
public static void processError(SQLException e) {
	System.out.println("Exception: -->"+e.getMessage());
}
}
