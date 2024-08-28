package day16;

public class Message {
	//field
	private String command;
	private String to;
	
	//constructor
	public Message(String command, String to) {
		super();
		this.command = command;
		this.to = to;
	}
	
	//getter method
	public String getCommand() {
		return command;
	}


	public String getTo() {
		return to;
	}
	
	//setter method
	public void setCommand(String command) {
		this.command = command;
	}


	public void setTo(String to) {
		this.to = to;
	}
	
	
}
