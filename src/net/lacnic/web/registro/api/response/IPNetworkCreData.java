package net.lacnic.web.registro.api.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ipnetwork:creData")
public class IPNetworkCreData {
	
	@XStreamAlias("ipnetwork:ipRange")
	IPNetworkIPRange ipRange;
	
	@XStreamAlias("ipnetwork:roid")
	String roid;
	
	@XStreamAlias("ipnetwork:crDate")
	String crDate;
	
//	@XStreamAlias("ipnetwork:ipRangeInfo")// TODO ver si aplica
//	IPNetworkIPRange ipRangeInfo;
	
	public String getRoid() {
		return roid;
	}
}
