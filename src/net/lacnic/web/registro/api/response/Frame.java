package net.lacnic.web.registro.api.response;

import net.lacnic.epp.exceptions.EppException;

public class Frame {

	public String frame;
	private final String SUCCESS = "Command completed successfully";
	
	public Frame(String frame) {
		this.frame = frame;
	}
	
	public void throwException(String text) throws EppException {
		throw new EppException(text);
	}
	
	public boolean isValid() {
		return frame.contains(SUCCESS);
	}
	
	public String getFrame() {
		return frame;
	}

	public void setFrame(String frame) {
		this.frame = frame;
	}
}
