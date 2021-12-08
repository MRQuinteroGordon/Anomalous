package main;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Player {
	String name;
	String username;
	String date;
	String avatar;
	int kind;
	int saddistic;
	int adventurous;
	
	public Player(String pname, String puname) {
		LocalDate myObj = LocalDate.now(); // Create a date object
		this.date = myObj.toString();
//	    System.out.println(myObj); // Display the current date
//		System.out.println("today's date is: " + this.date);
		if(pname.length() > 11) {
			this.name = pname.substring(0, 11);
		}
		else {
			this.name = pname;
		}
		
		
		this.username = puname;
	}
	
	/*
	 *       conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/business", "Manish", "123456");
      System.out.println("Connection is created successfully:");
      stmt = (Statement) conn.createStatement();
      String query1 = "INSERT INTO InsertDemo " + "VALUES (1, 'John', 34)";
      stmt.executeUpdate(query1);
      query1 = "INSERT INTO InsertDemo " + "VALUES (2, 'Carol', 42)";
      stmt.executeUpdate(query1);
      System.out.println("Record is inserted in the table successfully..................");
	 */
	
	public void saveData() throws SQLException {
		String connectionString = "jdbc:mysql://127.0.0.1:3306/anomalous?serverTimezone=UTC";
        String dbLogin = "javauser";
        String dbPassword = "j4v4us3r?";
        Connection conn = null;
        String sql = "INSERT INTO game_scores (date_played, player_name, username, k_score, s_score, a_score) VALUES('" + this.date + "', '" +  this.name + "', '" + this.username + "', '" + this.kind + "', '" + this.saddistic + "', '" + this.adventurous + "')";
        //game_id, date_played, player_name, username, k_score, s_score a_score
        try 
        {
            conn = DriverManager.getConnection(connectionString, dbLogin, dbPassword);
            if (conn != null) 
            {
            	System.out.println("Database connection successful.");
            	try 
                {
            		Statement stmt = conn.createStatement();
            		stmt.executeUpdate(sql);
                	System.out.println("player data loaded into database.");
                }
                catch (SQLException ex) 
                {
                    System.out.println(ex.getMessage());
                }
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Database connection failed.");
            e.printStackTrace();
        }
        conn.close();
	}
	
	public void printScores() {
		System.out.printf("Current scores are as follows:\nKind:\t%d\nSaddistic:\t%d\nAdventurous:\t%d\n", this.kind, this.saddistic, this.adventurous);
	}
	
	public int max() {
		//PUT IN CODE TO SEE WHICH SCORE IS HIGHEST
		if(this.kind > this.saddistic && this.kind > this.adventurous) {
			return 0;
		}
		else if (this.saddistic > this.kind && this.saddistic > this.adventurous) {
			return 1;
		}
		else if (this.adventurous > this.saddistic && this.adventurous > this.kind) {
			return 2;
		}
		else {
			return 0;
		}
	}
	
} 
