package maven.demo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class csvdata {

	    public static List<modelclass> readUserDataFromCSV(String filePath) {
	        List<modelclass> userDataList = new ArrayList<>();

	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	        	
	        	br.readLine();
	        	
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] data = line.split(",");
	                int empID = Integer.parseInt(data[0]);
	                String empName = data[1];
	                String designation = data[2];
	                String location = data[3];
	                modelclass userData = new modelclass(empID, empName, location, designation);
	                userDataList.add(userData);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return userDataList;
	    }

	    public static void main(String[] args) {
	        String filePath = "C:\\Book1.csv"; // Change this to your CSV file path
	        List<modelclass> userDataList = readUserDataFromCSV(filePath);

	        // Print the data fetched from CSV
	        for (modelclass userData : userDataList) {
	            System.out.println(userData.getEmpID() + ", " + userData.getEmpName() + ", " + userData.getDesignation() + "," + userData.getLocation());
	        }
	    }
	}