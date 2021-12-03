package main;

public class StoryNode {
	//updated version of node
	StoryNode next;
	int storyPart = 0;
	String[] storyTxt = new String[3];{
	storyTxt[0] = "Part " + storyPart + "version A.";
	storyTxt[1] = "Part " + storyPart + "version B.";
	storyTxt[2] = "Part " + storyPart + "version C.";
	}
	String[] actionTxt = new String[3];{
		actionTxt[0] = "Part " + storyPart + "version A.";
		actionTxt[1] = "Part " + storyPart + "version B.";
		actionTxt[2] = "Part " + storyPart + "version C.";
	}
	
	public StoryNode(int storyPart, String[] storyTxt, String[] actionTxt) {
		this.storyPart = storyPart;
		this.storyTxt = storyTxt;
		this.actionTxt = actionTxt;
	}
	

}
