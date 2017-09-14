package net.lacnic.web.registro.api.request;

import java.io.Serializable;

public enum TipoEPPStatus implements Serializable {
	ACTIVE, BLOCKED;
	@Override
	public String toString() {
		return this.name().toLowerCase();
	}
}
