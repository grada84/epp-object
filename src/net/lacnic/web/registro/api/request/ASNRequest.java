package net.lacnic.web.registro.api.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonDeserialize
@JsonSerialize
public class ASNRequest extends GenericRequest implements Serializable {

	private static final long serialVersionUID = -1334380375665712492L;
	private long number;
	private OrgRequest orgRequest;
	private List<Contact> contacts;

	public ASNRequest(String user, String ip, long number) {
		super(user, ip);
		this.number = number;
		this.orgRequest = new OrgRequest(user, ip);
		this.contacts = new ArrayList<Contact>();
	}
	
	public ASNRequest(String user, String ip, long number,List<Contact> contacts ) {
		super(user, ip);
		this.number = number;
		this.contacts = contacts;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public OrgRequest getOrgRequest() {
		return orgRequest;
	}

	public void setOrgRequest(OrgRequest orgRequest) {
		this.orgRequest = orgRequest;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

}
