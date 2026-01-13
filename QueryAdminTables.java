import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryAdminTables {
    public static void main(String[] args) {
        try {
            // Load HSQLDB driver
            Class.forName("org.hsqldb.jdbcDriver");
            
            // Connect to database
            Connection conn = DriverManager.getConnection(
                "jdbc:hsqldb:hsql://localhost:9001/broadleaf", "sa", "");
            
            // Query to find admin tables
            Statement stmt = conn.createStatement();
            
            String querySQL = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME LIKE '%ADMIN%'";
            
            ResultSet rs = stmt.executeQuery(querySQL);
            
            System.out.println("Admin related tables:");
            while (rs.next()) {
                System.out.println("- " + rs.getString("TABLE_NAME"));
            }
            
            // Close connection
            rs.close();
            stmt.close();
            conn.close();
            
            System.out.println("Query completed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}