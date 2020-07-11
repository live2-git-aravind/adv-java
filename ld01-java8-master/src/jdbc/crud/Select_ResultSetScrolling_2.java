package jdbc.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.util.DatabaseType;
import jdbc.util.DatabaseUtil;

public class Select_ResultSetScrolling_2 {
	public static void main(String[] args) {
//		fetchAllRecords();
//		fetchAllRecordsTryWithResources();
		scrollOperations();
	}

	private static void scrollOperations() {
		try ( // Establish a connection
				Connection connection = DatabaseUtil.getConnection(DatabaseType.ORACLEDB);
				// Create a statement
//			The object used for executing a static SQL statement and returning the results it produces. 
//				Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
				Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				// Execute the query
//			A table of data representing a database result set, which is usually generated by executing a statement that queries the database. 
				ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEES where employee_id < 105");) {
			
			while (resultSet.next()) {
				int employeeId = resultSet.getInt("EMPLOYEE_ID");
				String firstName = resultSet.getString("FIRST_NAME");
				System.out.println(employeeId + "   " + firstName);
			}
			
			System.out.println("REVERSE ITERATION");
			while (resultSet.previous()) {
				int employeeId = resultSet.getInt("EMPLOYEE_ID");
				String firstName = resultSet.getString("FIRST_NAME");
				System.out.println(employeeId + "   " + firstName);
			}	
			
			System.out.println("MOVING TO A SPECIFIC RECORD ABSOLUTELY");
			resultSet.absolute(3);
			int employeeId = resultSet.getInt("EMPLOYEE_ID");
			String firstName = resultSet.getString("FIRST_NAME");
			System.out.println(employeeId + "   " + firstName);
		
			System.out.println("MOVING TO A SPECIFIC RECORD RELATIVELY");
			resultSet.relative(2);
			 employeeId = resultSet.getInt("EMPLOYEE_ID");
			 firstName = resultSet.getString("FIRST_NAME");
			System.out.println(employeeId + "   " + firstName);
			
			resultSet.relative(-1);
			 employeeId = resultSet.getInt("EMPLOYEE_ID");
			 firstName = resultSet.getString("FIRST_NAME");
			System.out.println(employeeId + "   " + firstName);

		} catch (Exception e) {
			System.out.println("EXCEPTION :>> " + e);
		}
	}
	
	private static void fetchAllRecords() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			// Establish a connection
			connection = DatabaseUtil.getConnection(DatabaseType.ORACLEDB);
			// Create a statement
//			The object used for executing a static SQL statementand returning the results it produces. 
			statement = connection.createStatement();
			// Execute the query
//			A table of data representing a database result set, which is usually generated by executing a statement that queries the database. 
			resultSet = statement.executeQuery("SELECT * FROM EMPLOYEES");

			// Print out a few columns from the table
			while (resultSet.next()) {
				int employeeId = resultSet.getInt("EMPLOYEE_ID");
				String firstName = resultSet.getString("FIRST_NAME");
				System.out.println(employeeId + "   " + firstName);
			}

		} catch (Exception e) {
			System.out.println("EXCEPTION :>> " + e);
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				DatabaseUtil.processError(e);
			}
		}
	}

	private static void fetchAllRecordsTryWithResources() {
		try ( // Establish a connection
				Connection connection = DatabaseUtil.getConnection(DatabaseType.ORACLEDB);
				// Create a statement
//			The object used for executing a static SQL statement and returning the results it produces. 
				Statement statement = connection.createStatement();
				// Execute the query
//			A table of data representing a database result set, which is usually generated by executing a statement that queries the database. 
				ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEES");) {

			// Print out a few columns from the table
			while (resultSet.next()) {
				int employeeId = resultSet.getInt("EMPLOYEE_ID");
				String firstName = resultSet.getString("FIRST_NAME");
				System.out.println(employeeId + "   " + firstName);
			}

		} catch (Exception e) {
			System.out.println("EXCEPTION :>> " + e);
		}
	}
}