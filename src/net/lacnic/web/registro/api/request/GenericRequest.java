package net.lacnic.web.registro.api.request;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonDeserialize
@JsonSerialize
public class GenericRequest implements Serializable {

	private static final long serialVersionUID = -1334380375665712492L;
	private String user;
	private String ip;
//	private String modificador;

//	public String getModificador() {
//		return modificador;
//	}
//
//	public void setModificador(String modificador) {
//		this.modificador = modificador;
//	}

	public GenericRequest(String user, String ip) {
		super();
		this.user = user;
		this.ip = ip;
//		this.modificador = modificador;
	}
	
//	public GenericRequest(String user, String ip, String modificador) {
//		super();
//		this.user = user;
//		this.ip = ip;
//		this.modificador = modificador;
//	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

//	public void setModificadorAsUserExterno() {
//		setModificador("e");
//	}
//	public void setModificadorAsADMIN() {
//		setModificador("a");
//	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
