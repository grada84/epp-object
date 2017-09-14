package net.lacnic.web.registro.api.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("brorg:creData")
public class OrgCreData {
	@XStreamAlias("brorg:organization")
	String brOrgOrganization;

	@Override
	public String toString() {
		return "OrgCreData [brOrgOrganization=" + brOrgOrganization + "]";
	}

	public String getBrOrgOrganization() {
		return brOrgOrganization;
	}

	public void setBrOrgOrganization(String brOrgOrganization) {
		this.brOrgOrganization = brOrgOrganization;
	}
	
	
}
