package main;
/**
 * This is the node each chunk of the story (and it's respective choices of actions) will be stored in. 
 * @author Michelle Gordon
 *
 */
public class StoryNode2 {
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
