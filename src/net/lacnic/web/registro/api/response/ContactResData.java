package net.lacnic.web.registro.api.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("resData")
public class ContactResData extends ResData {
	@XStreamAlias("contact:creData")
	ContactCreData contactCreData;
	
	public ContactResData(){
		
		
	}
}
