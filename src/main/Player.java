package main;

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
		this.name = pname;
		this.username = puname;
		
		
	}
	
} 
