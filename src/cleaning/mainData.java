package cleaning;
import java.sql.SQLException;


public class mainData {

 
   
public static String fileNameText = "C:/Users/Mshabab/workspace/TestProject/dataP/ss.txt";
public static String catogery = "art";

	public static void main(String[] args) {
		try {
			new connectorClass();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		//cleaningClass class1= new cleaningClass();
		//writingClass class2= new writingClass();
	}

}
