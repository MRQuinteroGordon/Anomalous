package main;

//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
import java.sql.*;

public class StoryLinkedList {
	
	StoryNode head;
	private String dbLogin = "javauser";
	private String dbPassword = "j4v4us3r?";
	private String ConnectionString = "jdbc:mysql://127.0.0.1:3306/game_scores?serverTimezone=UTC";
	
	public StoryLinkedList() {
		loadList(this.ConnectionString, this.dbLogin, this.dbPassword);
	}
	
	
	public void append(int storyPart, String[] storyTxt, String[] actionTxt) {
		if (head == null) {
			head = new StoryNode(storyPart, storyTxt, actionTxt);
			return;
		}
		StoryNode current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new StoryNode(storyPart, storyTxt, actionTxt);
	}
	
	public void printNode(StoryNode story) {
		System.out.print("\n\n");
		System.out.print("Current Node:\nStory Part # " + story.storyPart + "\nStory Content: " + story.storyTxt + "\navailable actions: " + story.actionTxt);
	}
	
	private static void loadList (String connString, String dbLogin, String dbPw) {
		Connection conn = null;
		String sql = "SELECT * FROM "
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
