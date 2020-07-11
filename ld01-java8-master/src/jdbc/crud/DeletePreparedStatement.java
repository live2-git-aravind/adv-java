package jdbc.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.util.DatabaseType;
import jdbc.util.DatabaseUtil;

public class DeletePreparedStatement {
	public static void main(String[] args) {
		Connection connection = DatabaseUtil.getConnection(DatabaseType.ORACLEDB);
		
//		int employeeId = 1011;
//		String employeeName = "Great";
//		Date hireDate = Date.valueOf("2020-3-21");
//		double salary = 55.5d;	
		
		String queryString = "delete from Empolyee1  where employee_id = ?";
		System.out.println(queryString);
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(queryString);
			
			//ASSIGN VALUES FOR THE PARAMETERS

			preparedStatement.setInt(1, 1013);

			int noOfRowsDeleted = preparedStatement.executeUpdate();
			System.out.println("Rows Deleted :> " +noOfRowsDeleted );

		} catch (SQLException e) {
			System.out.println("EXCEPTION :>> " + e);
		}

	}
}