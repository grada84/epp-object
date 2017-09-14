package net.lacnic.web.registro.api.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("trID")
public class TrId {
	@XStreamAlias("clTRID")
	String clTRID;
	@XStreamAlias("svTRID")
	String svTRID;
	
	public TrId() {
	}
}
