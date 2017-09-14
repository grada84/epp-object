package net.lacnic.web.registro.api.request;

import java.io.Serializable;

public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;
	String handle;
	TipoContacto tipoContacto;

	public Contact() {

	}

	public Contact(String handle, TipoContacto tipoContacto) {
		this.handle = handle;
		this.tipoContacto = tipoContacto;
	}

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

	public TipoContacto getTipoContacto() {
		return tipoContacto;
	}

	public void setTipoContacto(TipoContacto tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

}
