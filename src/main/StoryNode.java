package main;
/** DO NOT USE THIS CLASS, IT DOES NOT WORK!
 * 
 * @author michelle
 *
 */
public class StoryNode {
	//updated version of node
	StoryNode next;
	int storyPart;
	String[] storyTxt = new String[3];
	String[] actionTxt = new String[3];
	
	public StoryNode(int storyPart, String[] storyTxt, String[] actionTxt) {
		this.storyPart = storyPart;
		this.storyTxt = storyTxt;
		this.actionTxt = actionTxt;
	}
	

}
