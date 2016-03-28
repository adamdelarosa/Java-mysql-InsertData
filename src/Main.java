import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ROSA on 3/28/16.
 */
public class Main {

    static final String JDBC_DRIVER_USE = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/STUDENTS";
    static final String USERNAME = "username";
    static final String PASSWORD = "password";


    public static void main(String args[]){
        printer();
        mysqlInsert();
    }

    public static void printer(){
        System.out.println("Hello");
    }
    public static void mysqlInsert(){
        Connection conn = null;
        Statement stmt = null;
        try{
            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            //Execute a query
            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();

            String sql = null;

            sql = "CREATE TABLE REGISTRATION " +
                    "(id INTEGER not NULL, " +
                    " first VARCHAR(255), " +
                    " last VARCHAR(255), " +
                    " age INTEGER, " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);

            System.out.println("Database.");


            sql = "INSERT INTO Registration " + "VALUES (100, 'Adam', 'Delarosa', 18)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Registration " + "VALUES (101, 'Asaf', 'Shlomyan', 25)";
            stmt.executeUpdate(sql);



            System.out.println("Inserted records into the table...");

        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
