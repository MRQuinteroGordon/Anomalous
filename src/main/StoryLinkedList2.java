package main;
import java.sql.*;

public class StoryLinkedList2 {
	StoryNode2 head;
	private String dbLogin = "javauser";
	private String dbPassword = "j4v4us3r?";
	private String ConnectionString = "jdbc:mysql://127.0.0.1:3306/anomalous?serverTimezone=UTC";
	int counter = 0;
	
	public StoryLinkedList2() throws SQLException {
		loadList(this.ConnectionString, this.dbLogin, this.dbPassword);
	}

	
	public void loadList (String connString, String dbLogin, String dbPw) throws SQLException{
		int partNum;
		String storyA;
		String storyB;
		String storyC;
		String actionA;
		String actionB;
		String actionC;
		
		Connection conn = null;
		String sql = "SELECT * FROM story_parts";
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
            		int numCols = 7;
            		rs.last();
            		numRows = rs.getRow();
            		System.out.printf("Number of Records: %d%n", numRows);
                    rs.first();
                    String[][] dbResults = new String[numRows][numCols];
                    for (int i = 0; i < numRows; i++) {
                    	dbResults[i][0] = rs.getString("part_id");
                    	dbResults[i][1] = rs.getString("story_a");
                        dbResults[i][2] = rs.getString("story_b");
                        dbResults[i][3] = rs.getString("story_c");
                        dbResults[i][4] = rs.getString("action_a");
                        dbResults[i][5] = rs.getString("action_b");
                        dbResults[i][6] = rs.getString("action_c");
                        rs.next();
                    
                    }
               
                    System.out.printf("Number of Array Rows: %d%n", dbResults.length);
                    System.out.printf("Number of Array Columns: %d%n", dbResults[0].length);
                    System.out.println();
                    
                    
                    //THIS MIGHT BE THE F-ED UP LOOP YOU NEED TO CHECK ON
                    for (int i = 0; i < dbResults.length; i++) {
                    	
                    	partNum = Integer.valueOf(dbResults[i][0]);
                    	storyA = dbResults[i][1];
                    	storyB = dbResults[i][2];
                    	storyC = dbResults[i][3];
                    	actionA = dbResults[i][4];
                    	actionB = dbResults[i][5];
                    	actionC = dbResults[i][6];
						  
					    System.out.println("\nThe values being sent to the append method are: ");
					    System.out.println("story part is:" + partNum);
					    System.out.println("story text 1 is: " + storyA);
					    System.out.println("story text 2 is: " + storyB);
					    System.out.println("story text 3 is: " + storyC);
					    System.out.println("action text 1 is: " + actionA);
					    System.out.println("action text 2 is: " + actionB);
					    System.out.println("action text 3 is: " + actionC);
						
					    append(partNum, storyA, storyB, storyC, actionA, actionB, actionC);	                     	
                    }
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
	}


	private void append(int partNum, String storyA, String storyB, String storyC, String actionA, String actionB,	 String actionC) {
		if (head == null) {
			head = new StoryNode2(partNum, storyA, storyB, storyC, actionA, actionB, actionC);
			return;
		}
		StoryNode2 current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new StoryNode2(partNum, storyA, storyB, storyC, actionA, actionB, actionC);
	}

	public StoryNode2 traverseList() {
		if (head == null) {
			System.out.println("List is empty.");
			return null;
		}
		StoryNode2 current = head;
		if (this.counter == 0) {
			this.counter++;
			return current;
		}
		else {
			for (int x = 1; x <= this.counter; x++) {
				current = current.next;
			}
			this.counter++;
			return current;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
