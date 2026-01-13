import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionTest {
    // HSQLDB 연결 정보
    private static final String DB_URL = "jdbc:hsqldb:hsql://localhost:9001/broadleaf";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        Connection connection = null;
        
        try {
            // HSQLDB JDBC 드라이버 로드
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            System.out.println("HSQLDB JDBC 드라이버 로드 성공");
            
            // 데이터베이스 연결
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("데이터베이스 연결 성공: " + DB_URL);
            
        } catch (ClassNotFoundException e) {
            System.err.println("HSQLDB JDBC 드라이버를 찾을 수 없습니다: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("데이터베이스 연결 실패: " + e.getMessage());
        } finally {
            // 연결 종료
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("데이터베이스 연결 종료");
                } catch (SQLException e) {
                    System.err.println("연결 종료 중 오류 발생: " + e.getMessage());
                }
            }
        }
    }
}