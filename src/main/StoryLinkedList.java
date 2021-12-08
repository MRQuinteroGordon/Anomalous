package main;

import java.sql.*;

public class StoryLinkedList {
	
	static StoryNode head;
//	StoryNode head;
	private String dbLogin = "javauser";
	private String dbPassword = "j4v4us3r?";
	private String ConnectionString = "jdbc:mysql://127.0.0.1:3306/anomalous?serverTimezone=UTC";
	int counter = 0;
	
	public StoryLinkedList() throws SQLException {
		loadList(this.ConnectionString, this.dbLogin, this.dbPassword);
	}
	
	
	public static void append(int storyPart, String[] storyTxt, String[] actionTxt) {
//	public void append(int storyPart, String[] storyTxt, String[] actionTxt) {
		System.out.println("Part: " + storyPart);
		if (head == null) {
			head = new StoryNode(storyPart, storyTxt, actionTxt);
			System.out.println("[head[" + head + "]] ");
			//System.out.println("\n\nHead node: ");
			//printNode(head);
			return;
		}
		StoryNode current = head;
		//System.out.println("\n\ncurrent node: "); 
		//printNode(current);
		while (current.next != null) {
			current = current.next;
			//System.out.println("\n\ncurrent node in while loop: ");
			//printNode(current);
		}
		current.next = new StoryNode(storyPart, storyTxt, actionTxt);
		//printNode(current.next);	
		System.out.println("[current[" + current.next + "]] ");
	}
	
	public static void printNode(StoryNode story) {
		System.out.print("\n");
		System.out.print("Story Part # " + story.storyPart + "\n"); 
		for (int i = 0; i<story.storyTxt.length; i++){
			System.out.println(story.storyTxt[i]);
			
		}
		for (int i = 0; i<story.actionTxt.length; i++) {
			System.out.println(story.actionTxt[i]);
		}

	}
	
	public void loadList (String connString, String dbLogin, String dbPw) throws SQLException {
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
               
                    System.out.printf("Number of Array Rows: %d%n", dbResults.length);
                    System.out.printf("Number of Array Columns: %d%n", dbResults[0].length);
                    System.out.println();
                    
                    
                    //THIS MIGHT BE THE F-ED UP LOOP YOU NEED TO CHECK ON
                    for (int i = 0; i < dbResults.length; i++) 
                    {
						
						  storyPart = Integer.valueOf(dbResults[i][0]); storyTxt[0] = dbResults[i][1];
						  storyTxt[1] = dbResults[i][2]; storyTxt[2] = dbResults[i][3]; actionTxt[0] =
						  dbResults[i][4]; actionTxt[1] = dbResults[i][5]; actionTxt[2] =
						  dbResults[i][6];
						  
						  System.out.println("\nThe values being sent to the append method are: ");
						  System.out.println("story part is:" + storyPart);
						  System.out.println("story text 1 is: " + storyTxt[0]);
						  System.out.println("story text 2 is: " + storyTxt[1]);
						  System.out.println("story text 3 is: " + storyTxt[2]);
						  System.out.println("action text 1 is: " + actionTxt[0]);
						  System.out.println("action text 2 is: " + actionTxt[1]);
						  System.out.println("action text 3 is: " + actionTxt[2]);
						                     	
                    	
//                    	for (int j = 0; j < storyTxt.length; j++) 
//                    	{
//                    		storyTxt[j] = dbResults[i][j+1];
//                    	}
//                    	for (int k = 0; k < actionTxt.length; k++) 
//                    	{
//                    		actionTxt[k] = dbResults[i][k+4];
//                    	}
//                    	append(storyPart, storyTxt, actionTxt);
                    	append(storyPart, storyTxt, actionTxt);
                    	//System.out.println("\nthe head after the append is:");
                    	//printNode(head);
                    }
                    //printArray(dbResults);
            		
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
		//printList();
		
		int stuffNum = 6;
		String[] stuffTxt = new String[3];
		String[] stuffTxt2 = new String[3];
		stuffTxt[0] = "hello";
		stuffTxt[1] = "my";
		stuffTxt[2] = "baby";
		stuffTxt2[0] = "henlo";
		stuffTxt2[1] = "mah";
		stuffTxt2[2] = "darlin'";
		//append(stuffNum, stuffTxt, stuffTxt2);
//		append(stuffNum, null, null);

		stuffNum = 44;
		stuffTxt[0] = "Yo";
		stuffTxt[1] = "Mo";
		stuffTxt[2] = "Go";
		stuffTxt2[0] = "No";
		stuffTxt2[1] = "Zo";
		stuffTxt2[2] = "Hoe";
		//append(stuffNum, stuffTxt, stuffTxt2);
//		append(stuffNum, null, null);

		System.out.println();
		printList();
		
		//printArray(dbResults);
		
//		System.out.println("The head node is: " + head.storyPart + ": " + head.storyTxt[0] + "action: " + head.actionTxt[0]);
//		System.out.println("The next node is: " + head.next.storyPart + ": " + head.next.storyTxt[0] + "action: " + head.next.actionTxt[0]);
//		System.out.println("The next node is: " + head.next.next.storyPart + ": " + head.next.next.storyTxt[0]);
	}
	
	public void printList(){
		if (head == null) {
			System.out.println("List is empty.");
			return;
		}
		//System.out.println("\n\nprinting list...\n\n");
		StoryNode current = head;
		System.out.print("Head: [" + current + "] " + current.storyPart + " " /*+ current.storyTxt[0]*/);
		//printNode(current);
		while (current.next != null) {
			current = current.next;
			System.out.print("[" + current + "] ");
			System.out.print(current.storyPart + current.storyTxt[0] + " > ");
			//printNode(current);
		}
		System.out.println("null");
	}
	
	public StoryNode traverseList() {
		if (head == null) {
			System.out.println("List is empty.");
			return null;
		}
		StoryNode current = head;
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
	
	
	
	public void printArray(String[][] results) {
		for (int i = 0; i < results.length; i++) {
			System.out.println("\n\n" + results[i][0]);
			for (int j = 1; j <7; j++) {
				System.out.println(results[i][j]);
			}
//			for (int k = 4; k < 8; k++) {
//				System.out.println(results[i][k]);
//			}
		}
	}
//	}

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

