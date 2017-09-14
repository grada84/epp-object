package net.lacnic.web.registro.api.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class ExtValue {
	@XStreamAlias("value")
	String value;
	@XStreamAlias("reason")
	String reason;

	@Override
	public String toString() {
		return "ExtValue [value=" + value + ", reason=" + reason + "]";
	}

	public ExtValue() {
		
	}
}
