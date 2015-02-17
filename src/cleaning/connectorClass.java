package cleaning;

// this clas is to make connection to the database
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class connectorClass {
        public static String reslut= null; 

        private static String sql;
        private static Statement stat;
        private static Connection conn = null; 
    
    public connectorClass() throws SQLException {             
    		new sqlStat();

            System.out.println("-------- MySQL JDBC Connection Testing ------------");
            sql= sqlStat.sql1;
            System.out.print(sql);
                      try {
                    	  		Class.forName("com.mysql.jdbc.Driver");// this juast load for the dirver
                    	  		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","123456");
                    	  	//	stat = conn.createStatement();
                    	  	stat = conn.prepareStatement(sql);
                    	  		stat.executeUpdate(sql);
                       	  		reslut = "you did your sql correctely";

                    	  			
                       } catch (ClassNotFoundException e) {
                    	   		System.out.println("Hi mshabab, your drive not found");
                          		e.printStackTrace();
                                return;
                      } catch (SQLException e) {
                         System.out.println(e);
                                e.printStackTrace();
                                return;
                      } finally{                    	  		
                    	  		stat.close();
                    	  		conn.close();
                      }
              
 
     }
       
}

