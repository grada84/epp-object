package net.lacnic.web.registro.api.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("ipnetwork:ipRange")
public class IPNetworkIPRange {
	@XStreamAsAttribute
	String version; // attribute
	
	@XStreamAlias("ipnetwork:startAddress")
	String startAddress;
	
	@XStreamAlias("ipnetwork:endAddress")
	String endAddress;
	
	
	

}
