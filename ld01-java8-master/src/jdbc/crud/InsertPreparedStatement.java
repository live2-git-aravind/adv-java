package jdbc.crud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.util.DatabaseType;
import jdbc.util.DatabaseUtil;

public class InsertPreparedStatement {
	public static void main(String[] args) {
		Connection connection = DatabaseUtil.getConnection(DatabaseType.ORACLEDB);
		
		int employeeId = 1011;
		String employeeName = "Great";
		Date hireDate = Date.valueOf("2020-3-21");
		double salary = 55.5d;	
		
		String queryString = "insert into Empolyee1 values (?,?,?,?)";
		System.out.println(queryString);
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(queryString);
			
			//ASSIGN VALUES FOR THE PARAMETERS
			for(int rows = 0; rows<5; rows++) {
			preparedStatement.setInt(1, employeeId+rows);
			preparedStatement.setString(2, employeeName+rows);
			preparedStatement.setDate(3, hireDate);
			preparedStatement.setDouble(4, salary);
			int noOfRowsInserted = preparedStatement.executeUpdate();
			System.out.println("Rows Inserted :> " + noOfRowsInserted);
			}
		} catch (SQLException e) {
			System.out.println("EXCEPTION :>> " + e);
		}

	}
}