package copeTables;
/* this class with his main function is to computer the number of days between one rating to another. The days column
 *  in new table helps to find the covariance between all rating behavior.     */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;


public class computDays {
    static String sql1,sql2, sql3, sql4 ,sql5, sql6;
    private static int total ,total1, total2, total3;;
    private static String category  = "";
    private static PreparedStatement stat;
    private static PreparedStatement stat2;
    private static Connection conn = null;
    private static ResultSet result;
    private static String tableName = "kindle_store";
    private static String tableName2 = "movies_tv";
    private static String tableName3 = " ";
    



    public static void main(String[] args) throws SQLException {
        Q3();
        long heapSize = Runtime.getRuntime().totalMemory();
        System.out.println("Heap Size = " + heapSize);
        category = tableName;
       // sqlquery(sql1, sql2);
        total1=total;
        category = tableName2;
        sqlquery(sql3, sql4);
        total2=total;
        category = tableName3;
       // sqlquery(sql5, sql6);
        total3=total;
        System.out.print("\n\n");
        System.out.println(total1 + "\t" + tableName );
        System.out.println(total2 + "\t" + tableName2 );
        System.out.println(total3 + "\t" + tableName3 );
    }


    /****************************( 3 )*********************************/

    public static void Q3() {
          sql1 = "select Pid,Uid,name, helpN, helpD, rate, time  from  xx_"+ tableName +" ;";

        sql2 =
                 "INSERT INTO " + tableName + " (Pid,Uid,nameU, helpN, helpD, rate, timeP, days, catog ) VALUES(?,?,?,?,?,?,?,?,?);";
  
        sql3 = "select Pid,Uid,name, helpN, helpD, rate, time  from  xx_"+ tableName2 +" ;";

       sql4 =
                "INSERT INTO " + tableName2 + " (Pid,Uid,nameU, helpN, helpD, rate, timeP, days, catog ) VALUES(?,?,?,?,?,?,?,?,?);";
 
   
       sql5 = "select Pid,Uid,name, helpN, helpD, rate, time  from  xx_"+ tableName3 +" ;";

      sql6 =
               "INSERT INTO " + tableName3 + " (Pid,Uid,nameU, helpN, helpD, rate, timeP, days, catog ) VALUES(?,?,?,?,?,?,?,?,?);";

    }

    
    
    
    
    

    public static void sqlquery(String sqlinput, String sqloutput) throws SQLException {
        System.out.println("-------- you have in your table  ------------\n");
        try {
            int days1 = 0;
            int time1, time2 = 0;
            int rate1;
            int helpD1;
            int helpN1;
            String uid1;
            String pid1, pid2 = "xx";
            String name1;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/amazon", "root", "123456");
            stat = conn.prepareStatement(sqlinput);
            stat.setFetchSize(10);
            result = stat.executeQuery(sqlinput);
            stat2 = conn.prepareStatement(sqloutput);
            int mm = 0;

            while (result.next()) {
                pid1 = result.getString("Pid");
                uid1 = result.getString("Uid");
                name1 = result.getString("name");
                helpN1 = result.getInt("helpN");
                helpD1 = result.getInt("helpD");
                rate1 = result.getInt("rate");
                time1 = result.getInt("time");

                stat2.setString(1, pid1);
                stat2.setString(2, uid1);
                stat2.setString(3, name1);
                stat2.setInt(4, helpN1);
                stat2.setInt(5, helpD1);
                stat2.setInt(6, rate1);
                stat2.setInt(7, time1);
                stat2.setString(9, category);

                if (pid1.equalsIgnoreCase(pid2)) {
                    days1 = ((((time1 - time2) / 60) / 60) / 24);
                    stat2.setInt(8, days1);
                } else {
                    days1 = 0;
                    stat2.setInt(8, days1);
                }
                mm++;
            	stat2.executeUpdate();
                System.out.println(mm+"|\t"+pid1+"|\t"+uid1+"|\t"+days1+"|\t"+ category);

                time2 = time1;
                pid2 = pid1;
            }
            
          total = mm;
        } catch (ClassNotFoundException e) {
            System.out.println("Hi mshabab, your drive not found");
            return;
        } catch (SQLException ef) {
            System.out.println(ef);
            System.err.println("There is problem in the sql query and reslut set");
            return;
        } finally {
            for (SQLWarning w = stat.getWarnings(); w != null; w = w.getNextWarning())
                System.err.println("WARNING: " + w.getMessage());
            result.close();
            stat.close();
            conn.close();
        }        
    }

    
    
}

