package jdbc.crud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.util.DatabaseType;
import jdbc.util.DatabaseUtil;

public class BatchUpdateStatement {
	public static void main(String[] args) {
		Connection connection = DatabaseUtil.getConnection(DatabaseType.ORACLEDB);
		
		int employeeId = 555;
		String employeeName = "Great";
		double salary = 55.5d;	
		Date hireDate = Date.valueOf("2020-3-21");
		String queryString = "insert into Empolyee1  values (" + employeeId + ",'" + employeeName + "',to_date('" + hireDate + "','YY-MM-DD')," + salary + ")";
		System.out.println(queryString);
		Statement statement;
		try {
			statement = connection.createStatement();
			for(int rows = 0; rows<100; rows++) {
				statement.addBatch(queryString);	
			}

			int[] rowsInserted = statement.executeBatch();
			for(int rowInserted : rowsInserted) {
				System.out.print(rowInserted + " ");
			}
			//System.out.println("Rows Inserted :> " + 1);
		} catch (SQLException e) {
			System.out.println("EXCEPTION :>> " + e);
		}

	}
}