package net.lacnic.web.registro.api.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("extension")
public class Extension {

	@XStreamAlias("brorg:creData")
	OrgCreData orgCreData;

	@Override
	public String toString() {
		return "Extension [orgCreData=" + orgCreData + "]";
	}

	public Extension() {
		
	}

	public OrgCreData getOrgCreData() {
		return orgCreData;
	}

	public void setOrgCreData(OrgCreData orgCreData) {
		this.orgCreData = orgCreData;
	}
}
