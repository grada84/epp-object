package net.lacnic.web.registro.api.request;

import java.io.Serializable;

public enum TipoAlocacion implements Serializable {
	ASSIGNMENT, ALLOCATION, NOAPPLY;

	@Override
	public String toString() {
		return name().toLowerCase();
	}
}
