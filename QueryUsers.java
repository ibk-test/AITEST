import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryUsers {
    public static void main(String[] args) {
        try {
            // Load HSQLDB driver
            Class.forName("org.hsqldb.jdbcDriver");
            
            // Connect to database
            Connection conn = DriverManager.getConnection(
                "jdbc:hsqldb:hsql://localhost:9001/broadleaf", "sa", "");
            
            // Query to find admin users
            Statement stmt = conn.createStatement();
            
            String querySQL = "SELECT ADMIN_USER_ID, LOGIN, EMAIL, PASSWORD, ACTIVE_STATUS_FLAG FROM BLC_ADMIN_USER";
            
            ResultSet rs = stmt.executeQuery(querySQL);
            
            System.out.println("Admin users:");
            System.out.println("ID\tLogin\t\tEmail\t\t\tPassword\tActive");
            System.out.println("--\t-----\t\t-----\t\t\t--------\t------");
            while (rs.next()) {
                System.out.println(
                    rs.getLong("ADMIN_USER_ID") + "\t" +
                    rs.getString("LOGIN") + "\t\t" +
                    rs.getString("EMAIL") + "\t\t" +
                    rs.getString("PASSWORD") + "\t" +
                    rs.getBoolean("ACTIVE_STATUS_FLAG")
                );
            }
            
            // Close admin user result set
            rs.close();
            
            // Now check for customer users
            querySQL = "SELECT CUSTOMER_ID, USER_NAME, EMAIL_ADDRESS, PASSWORD, IS_REGISTERED FROM BLC_CUSTOMER";
            
            rs = stmt.executeQuery(querySQL);
            
            System.out.println("\nCustomer users:");
            System.out.println("ID\tUsername\tEmail\t\t\tPassword\tRegistered");
            System.out.println("--\t--------\t-----\t\t\t--------\t---------");
            while (rs.next()) {
                System.out.println(
                    rs.getLong("CUSTOMER_ID") + "\t" +
                    rs.getString("USER_NAME") + "\t\t" +
                    rs.getString("EMAIL_ADDRESS") + "\t\t" +
                    rs.getString("PASSWORD") + "\t" +
                    rs.getBoolean("IS_REGISTERED")
                );
            }
            
            // Close connection
            rs.close();
            stmt.close();
            conn.close();
            
            System.out.println("\nQuery completed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}