package maven.demo;
//import java.util.*;
import java.sql.*;


public class connectDatabase {
 
	public static void main(String[] args) {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost/employee";
			String username = "root";
			String password = "Adm!n";
			
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);
			
			System.out.println("Connection Successfull");
			
			Statement myStmt = conn.createStatement();
			String sql = "insert into book1 "
					+"(Student, Age, Remarks)"
					+ " values ('jony',45, 'Pass')," + "('jony',54, 'Fail')";
			myStmt.executeUpdate(sql);
			System.out.println("Insert complete.");
			conn.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
