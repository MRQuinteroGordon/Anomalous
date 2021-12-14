package main;
/**
 * This is the username generator class.  It contains a 2-dimensional array that stores different elements the program
 * will randomly choose from to concatenate into a username. 
 * @author Michelle Gordon
 * 
 */
import javax.swing.JOptionPane;

public class UNGenerator {
	String playername;
	String username;
	String elem1;
	String elem2;
	String elem3;

	String[][] nameElements = new String[][] {
		{"kitty_", "muffin_", "nsync_", "puppy_", "surfer_", "boombox_", "kewl_", "xfiles_", "bsb_", "spicegrl_", "chbullz_", "booty_", "nirvana_"},
		{"luvr", "#1Fan", "dude", "babe", "bro", "chick", "fool", "playa", "sk8tr", "hugz"},
		{"92", "75", "85", "78", "84", "83", "91", "73", "82", "94", "79"}
	};
	
	public UNGenerator(String name) {
		this.playername = name;
		generateUN(this.playername);
	}
	/**
	 * This method converts the first three characters of the player's name into three separate numerical values (based on the
	 * ASCII text codes) and performs a calculation on those values to come up with three numbers that will become the index numbers
	 * chosen for each sub-array.  
	 * @param name
	 */
	private void generateUN(String name) {
		try {
			char c1 = name.charAt(0);
			char c2 = name.charAt(1);
			char c3 = name.charAt(2);
//			System.out.println(c1 + " " + c2 + " " + c3);
			int charNum1 = (int)c1;
			int charNum2 = (int)c2;
			int charNum3 = (int)c3;
//			System.out.println(charNum1 + " " + charNum2 + " " + charNum3);
			
			this.elem1 = nameElements[0][(charNum1%12)];
			this.elem2 = nameElements[1][(charNum2%10)];
			this.elem3 = nameElements[2][(charNum3%11)];
//			System.out.println(this.elem1 + this.elem2 + this.elem3);
			this.username = this.elem1 + this.elem2 + this.elem3;
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid Entry.  Your name must be at least 3 characters long.  Please try again. ");
			e.printStackTrace();
		}

		

	}

}
