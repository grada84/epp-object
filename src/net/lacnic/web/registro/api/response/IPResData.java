package net.lacnic.web.registro.api.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("resData")
public class IPResData extends ResData {
	@XStreamAlias("ipnetwork:creData")
	IPNetworkCreData ipnetworkCreData;
	
	public IPResData(){
		
		
	}

	public IPNetworkCreData getCreData() {
		return ipnetworkCreData;
	}
}
