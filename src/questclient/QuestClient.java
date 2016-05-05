package questclient;

import processing.core.PApplet;
import processing.net.*;

public class QuestClient extends PApplet {

	public static void main(String _args[]) {
		PApplet.main(new String[] { questclient.QuestClient.class.getName() });
	}

	Client myClient;
	int myClientID = -1;

	public void settings() {
		size(600, 400);
	}

	public void setup() {
		myClient = new Client(this, "127.0.0.1", 7835);
		myClient.run();
	}

	public void draw() {
		if (myClient.available() > 0) {
			String inFS = myClient.readString();
			if (myClientID == -1) {
				if (inFS.substring(0, 2).equals("nc")) {
					myClientID = Integer.parseInt(inFS.substring(3));
				}
			}else{
				if (Integer.parseInt(inFS.substring(3, 4))==myClientID){
					
				}
			}
		}
		
		
		
		background(0);
		
	}

	public void keyPressed() {
		if(key=='q'||key=='Q'){
			myExit();
		}
	}
	
	public void myExit() {
		sendToServer("qq", "good bay");
		myClient.stop();
		exit();
	}
	
	private void sendToServer(String type,String messge) {
		myClient.write(type+" "+myClientID+" "+messge);
	}
}
