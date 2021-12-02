package main;

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
	
	private void generateUN(String name) {
		char c1 = name.charAt(0);
		char c2 = name.charAt(1);
		char c3 = name.charAt(2);
//		System.out.println(c1 + " " + c2 + " " + c3);
		int charNum1 = (int)c1;
		int charNum2 = (int)c2;
		int charNum3 = (int)c3;
//		System.out.println(charNum1 + " " + charNum2 + " " + charNum3);
		
		this.elem1 = nameElements[0][(charNum1%12)];
		this.elem2 = nameElements[1][(charNum1%10)];
		this.elem3 = nameElements[2][(charNum1%11)];
//		System.out.println(this.elem1 + this.elem2 + this.elem3);
		this.username = this.elem1 + this.elem2 + this.elem3;
		

	}

}
