import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QueryAdminUsers {
    // Connection pool settings
    private static final String DB_URL = "jdbc:hsqldb:hsql://localhost:9001/broadleaf";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";
    private static final int PAGE_SIZE = 100; // Page size for pagination
    
    public static void main(String[] args) {
        try {
            // Load HSQLDB driver
            Class.forName("org.hsqldb.jdbcDriver");
            
            // Process all admin users with pagination
            processAllAdminUsers();
            
            System.out.println("Query completed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Process all admin users with pagination
     */
    private static void processAllAdminUsers() throws SQLException {
        int offset = 0;
        int rowCount;
        
        do {
            rowCount = processAdminUsersPage(offset, PAGE_SIZE);
            offset += PAGE_SIZE;
            // Optional: Add delay between pages to reduce database load
            // try { Thread.sleep(10); } catch (InterruptedException e) {}
        } while (rowCount == PAGE_SIZE);
    }
    
    /**
     * Process a page of admin users
     * @param offset The offset for the query
     * @param limit The limit for the query
     * @return The number of rows processed
     */
    private static int processAdminUsersPage(int offset, int limit) throws SQLException {
        String querySQL = "SELECT ADMIN_USER_ID, LOGIN, EMAIL, PASSWORD, ACTIVE_STATUS_FLAG FROM BLC_ADMIN_USER ORDER BY ADMIN_USER_ID LIMIT ? OFFSET ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(querySQL)) {
            
            pstmt.setInt(1, limit);
            pstmt.setInt(2, offset);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                // Print header only for the first page
                if (offset == 0) {
                    System.out.println("Admin users:");
                    System.out.println("ID\tLogin\t\tEmail\t\t\tPassword\tActive");
                    System.out.println("--\t-----\t\t-----\t\t\t--------\t------");
                }
                
                int rowCount = 0;
                while (rs.next()) {
                    rowCount++;
                    System.out.println(
                        rs.getLong("ADMIN_USER_ID") + "\t" +
                        rs.getString("LOGIN") + "\t\t" +
                        rs.getString("EMAIL") + "\t\t" +
                        rs.getString("PASSWORD") + "\t" +
                        rs.getBoolean("ACTIVE_STATUS_FLAG")
                    );
                }
                
                return rowCount;
            }
        }
    }
}