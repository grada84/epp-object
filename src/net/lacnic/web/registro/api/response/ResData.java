package net.lacnic.web.registro.api.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class ResData {
	
	@XStreamAlias("contact:creData")
	ContactCreData contactCreData;
	
	@XStreamAlias("ipnetwork:creData")
	IPNetworkCreData ipnetworkCreData;
	
	@Override
	public String toString() {
		return "ResData [contactCreData=" + contactCreData + "]";
	}
	
	public ResData() {
	}
	
	public ContactCreData getContactCreData() {
		return contactCreData;
	}

	public IPNetworkCreData getIpnetworkCreData() {
		return ipnetworkCreData;
	}
}
