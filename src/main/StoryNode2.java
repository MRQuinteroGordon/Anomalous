package main;

public class StoryNode2 {
	//testing out making a node without arrays
	StoryNode2 next;
	int storyPart;
	String storyTxta;
	String storyTxtb;
	String storyTxtc;
	String actionTxta;
	String actionTxtb;
	String actionTxtc;
	
	
	public StoryNode2(int storyPart, String storya, String storyb, String storyc, String actiona, String actionb, String actionc) {
		this.storyPart = storyPart;
		this.storyTxta = storya;
		this.storyTxtb = storyb;
		this.storyTxtc = storyc;
		this.actionTxta = actiona;
		this.actionTxtb = actionb;
		this.actionTxtc = actionc;
	}
}
