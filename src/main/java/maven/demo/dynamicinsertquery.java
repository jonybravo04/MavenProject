package maven.demo;
import java.sql.*;

public class dynamicinsertquery {
	
	public static void insertmodelclass (modelclass mc) throws ClassNotFoundException {
	
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost/employee";
		String username = "root";
		String password = "Adm!n";
		Class.forName(driver);
		
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Successfull");
			
			String query = "insert into empdetails(empID,empName,designation,location) "
						+ "values(?,?,?,?)";
			PreparedStatement ptsmt = conn.prepareStatement(query);
				
			ptsmt.setInt(1, mc.getEmpID());
			ptsmt.setString(2, mc.getEmpName());
			ptsmt.setString(3, mc.getDesignation());
			ptsmt.setString(4, mc.getLocation());
				
			int affectedRows = ptsmt.executeUpdate();
	        if (affectedRows > 0) {
	        	System.out.println("A user was inserted successfully!");
	        }
			//conn.close();
				
				
		} catch (SQLException e) {
			e.printStackTrace();
			}
			
		}
		public static void main(String[] args) throws ClassNotFoundException {
        modelclass mc = new modelclass (7, "jony", "dev", "UP");
	  /*modelclass mc = new modelclass ();
        mc.setEmpID(25);
        mc.setEmpName("Panchal");
        mc.setDesignation("Driver");
        mc.setLocation("Thane");   */
        System.out.println(mc.getEmpID() + ", " + mc.getEmpName() + ", " + mc.getDesignation() + "," + mc.getLocation());
        dynamicinsertquery.insertmodelclass(mc); //calls the method to insert data in table
		
	    
	}
}

