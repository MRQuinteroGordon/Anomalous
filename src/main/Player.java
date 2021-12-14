package main;
/**
 * This is the player class/object that will be instantiated at the start of the game in order to hold the player's
 * information and track their scores. 
 * @author Michelle Gordon
 */
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
		if(pname.length() > 11) {
			this.name = pname.substring(0, 11);
		}
		else {
			this.name = pname;
		}
		
		
		this.username = puname;
	}
	/**
	 * this method will insert a record containing the player's current data into the database.
	 * @throws SQLException
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
	/**
	 * this method prints out the player's current scores to the console.
	 * This was used to test the accuracy of the data as the player moves through the game.
	 */
	public void printScores() {
		System.out.printf("Current scores are as follows:\nKind:\t%d\nSaddistic:\t%d\nAdventurous:\t%d\n", this.kind, this.saddistic, this.adventurous);
	}
	/**
	 * This method returns a value corresponding to the personality trait that has the highest score. 
	 * In the event of a tie across all scores, the value for the kind trait is returned. 
	 * @return
	 */
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
