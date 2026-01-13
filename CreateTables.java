import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTables {
    public static void main(String[] args) {
        try {
            // Load HSQLDB driver
            Class.forName("org.hsqldb.jdbcDriver");
            
            // Connect to database
            Connection conn = DriverManager.getConnection(
                "jdbc:hsqldb:hsql://localhost:9001/broadleaf", "sa", "");
            
            // Create table query execution
            Statement stmt = conn.createStatement();
            
            String createTableSQL = "CREATE TABLE BLC_SYSTEM_PROPERTY (" +
                "BLC_SYSTEM_PROPERTY_ID BIGINT NOT NULL, " +
                "FRIENDLY_GROUP VARCHAR(255), " +
                "FRIENDLY_NAME VARCHAR(255), " +
                "FRIENDLY_TAB VARCHAR(255), " +
                "PROPERTY_NAME VARCHAR(255) NOT NULL, " +
                "PROPERTY_TYPE VARCHAR(255), " +
                "PROPERTY_VALUE VARCHAR(255), " +
                "TOOL_TIP VARCHAR(255), " +
                "PRIMARY KEY (BLC_SYSTEM_PROPERTY_ID))";
            
            stmt.executeUpdate(createTableSQL);
            System.out.println("BLC_SYSTEM_PROPERTY table has been created.");
            
            // Create index
            String createIndexSQL = "CREATE INDEX BLC_SYS_PROP_NAME_INDEX ON BLC_SYSTEM_PROPERTY (PROPERTY_NAME)";
            stmt.executeUpdate(createIndexSQL);
            System.out.println("BLC_SYS_PROP_NAME_INDEX index has been created.");
            
            // Create sequence
            String createSequenceSQL = "CREATE SEQUENCE BLC_SYSTEM_PROPERTY_SEQ START WITH 1 INCREMENT BY 50";
            stmt.executeUpdate(createSequenceSQL);
            System.out.println("BLC_SYSTEM_PROPERTY_SEQ sequence has been created.");
            
            // Close connection
            stmt.close();
            conn.close();
            
            System.out.println("All operations have been completed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}