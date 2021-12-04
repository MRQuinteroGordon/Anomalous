package main;

//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
import java.sql.*;

public class StoryLinkedList {
	
	static StoryNode head;
	private String dbLogin = "javauser";
	private String dbPassword = "j4v4us3r?";
	private String ConnectionString = "jdbc:mysql://127.0.0.1:3306/anomalous?serverTimezone=UTC";
	
	public StoryLinkedList() {
		loadList(this.ConnectionString, this.dbLogin, this.dbPassword);
	}
	
	
	public static void append(int storyPart, String[] storyTxt, String[] actionTxt) {
		if (head == null) {
			head = new StoryNode(storyPart, storyTxt, actionTxt);
			printNode(head);
			return;
		}
		StoryNode current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new StoryNode(storyPart, storyTxt, actionTxt);
		printNode(current.next);
	}
	
	public static void printNode(StoryNode story) {
		System.out.print("\n\n");
		System.out.print("Current Node:\nStory Part # " + story.storyPart + "\nStory Content: " + story.storyTxt + "\navailable actions: " + story.actionTxt);
	}
	
	public void loadList (String connString, String dbLogin, String dbPw) {
		int storyPart;
		String[] storyTxt = new String[3];
		String[] actionTxt = new String[3];
		
		
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
                    //THIS IS WHERE YOU LEFT OFF!
                    //THIS IS WHERE YOU LEFT OFF!!!!!!!!!
                    System.out.printf("Number of Array Rows: %d%n", dbResults.length);
                    
                    for (int i = 0; i < dbResults.length; i++) {
                    	storyPart = Integer.valueOf(dbResults[i][0]);
                    	for (int j = 0; j < storyTxt.length; j++) {
                    		storyTxt[j] = dbResults[i][j+1];
                    	}
                    	for (int k = 0; k < actionTxt.length; k++) {
                    		actionTxt[k] = dbResults[i][k+4];
                    	}
                    	append(storyPart, storyTxt, actionTxt);
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
	}

	//if you decide to use a csv file instead of database for storing the story parts
//	private static void csv2nodes(File fileName, GamerLinkedList game) throws IOException {
//		if (fileName.exists()) {
//			BufferedReader br = null;
//			String line = "";
//			String csvSplitBy = ",";
//			br = new BufferedReader(new FileReader(fileName));
//			while ((line = br.readLine()) != null) {
//				String[] gamer = line.split(csvSplitBy);
//				game.append(Integer.valueOf(gamer[0]), gamer[1], gamer[2], gamer[3], gamer[4], Double.valueOf(gamer[5]), Integer.valueOf(gamer[6]));	
//			}
//		br.close();	
//		}
	
}
