package jdbc.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;

import org.apache.ibatis.jdbc.ScriptRunner;

public class ScriptRunnerUtilOracle {
public static void main(String[] args) throws FileNotFoundException {
	Connection connection = DatabaseUtil.getConnection(DatabaseType.MYSQLDB);
	//Instantiating the script runner and associating it with the connection.
	ScriptRunner scriptRunner = new ScriptRunner(connection);
	//Read the script file
	Reader reader = new BufferedReader(new FileReader("C:\\Users\\Aravind\\AdvancedJava\\ld01-java8-master\\src\\jdbc\\util\\scriptrunner-util.sql"));
	//Execute the script
	scriptRunner.runScript(reader);
}
}