package main;
/**
 * this is the class that connects to the database to retrieve all of the historical player data. 
 * @author Michelle Gordon
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class History {
	
	private static String dbLogin = "javauser";
	private static String dbPassword = "j4v4us3r?";
	private static String ConnectionString = "jdbc:mysql://127.0.0.1:3306/anomalous?serverTimezone=UTC";
	
	/**
	 * this is the method that connects to the database and loads the query results into an array
	 * to then print each record out on the screen.
	 * @return
	 * @throws SQLException
	 */
	public static String[][] loadList () throws SQLException{
		String dbLogin = getDbLogin();
		String dbPw = getDbPassword();
		String connString = getConnectionString();
		String[][] dbResults = null;
		
		Connection conn = null;
		String sql = "SELECT date_played, player_name, username, k_score, s_score, a_score FROM game_scores ORDER BY date_played;";
		try {
			conn = DriverManager.getConnection(connString, dbLogin, dbPw);
            if (conn != null) 
            {
            	System.out.println("Database connection successful.");
            	try (Statement stmt = conn.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery(sql)) {
            		int numRows;
            		int numCols = 6;
            		rs.last();
            		numRows = rs.getRow();
            		System.out.printf("Number of Records: %d%n", numRows);
                    rs.first();
                    dbResults = new String[numRows][numCols];
                    for (int i = 0; i < numRows; i++) {
                    	dbResults[i][0] = rs.getString("date_played");
                    	dbResults[i][1] = rs.getString("player_name");
                        dbResults[i][2] = rs.getString("username");
                        dbResults[i][3] = rs.getString("k_score");
                        dbResults[i][4] = rs.getString("s_score");
                        dbResults[i][5] = rs.getString("a_score");
                        rs.next();
                    
                    }
               
                    System.out.printf("Number of Array Rows: %d%n", dbResults.length);
                    System.out.printf("Number of Array Columns: %d%n", dbResults[0].length);
                    System.out.println();
                    
                    for (int i = 0; i < numRows; i++) {
                    	System.out.print("\nGamer History Array:\n");
                    	for (int j = 0; j < numCols; j++) {
                    		System.out.println(dbResults[i][j]);
                    	}
                    	System.out.print("\n");
                    }
                    
                    return dbResults;          	
                }
            	catch (SQLException ex){
            		System.out.println(ex.getMessage());
            	}
            }
		}
		catch (Exception e){
			System.out.println("Database connection failed.");
            e.printStackTrace();			
		}
		conn.close();
		return dbResults;
		
	}


	private static String getDbLogin() {
		return dbLogin;
	}


	private static String getDbPassword() {
		return dbPassword;
	}


	private static String getConnectionString() {
		return ConnectionString;
	}
	
}
