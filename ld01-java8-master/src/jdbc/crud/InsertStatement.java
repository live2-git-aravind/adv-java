package jdbc.crud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.util.DatabaseType;
import jdbc.util.DatabaseUtil;

public class InsertStatement {
public static void main(String[] args) {
	Connection connection = DatabaseUtil.getConnection(DatabaseType.ORACLEDB);
	int employeeid=1;
	String employeename="Balu";
	Date hireDate=Date.valueOf("2020-3-21");
	Double salary=55.5d;
	
	String queryString = "insert into Empolyee1 values(" +employeeid+",'"+employeename+"',"
			+ "to_date('"+hireDate+"','YY-MM-DD'),"+salary+")";

	System.out.println(queryString);
	Statement statement;
	try {
		statement = connection.createStatement();
		int noOfRowsInserted = statement.executeUpdate(queryString);
		System.out.println("Rows Inserted :> " + noOfRowsInserted);
	} catch (SQLException e) {
		System.out.println("EXCEPTION :>> " + e);
	}


	
}
}
