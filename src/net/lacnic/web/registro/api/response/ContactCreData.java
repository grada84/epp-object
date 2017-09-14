package net.lacnic.web.registro.api.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("contact:creData")
public class ContactCreData {
	
	@XStreamAlias("contact:id")
	String contactId;
	
	@XStreamAlias("contact:crDate")
	String crDate;
	
	@Override
	public String toString() {
		return "ContactCreData [contactId=" + contactId + ", crDate=" + crDate + "]";
	}

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
}
