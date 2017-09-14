package net.lacnic.web.registro.api.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class OrgCreExtension extends Extension {

	@XStreamAlias("brorg:creData")
	OrgCreData orgCreData;
	
	public OrgCreExtension() {
		
		
		}
}
