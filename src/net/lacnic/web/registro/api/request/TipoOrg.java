package net.lacnic.web.registro.api.request;

import java.io.Serializable;

public enum TipoOrg implements Serializable {
	NIR, PROVIDER, NORMAL, NIR_PROVIDER;

	@Override
	public String toString() {
		if (this.equals(TipoOrg.NIR_PROVIDER)) {
			return "nir-provider";
		} else
			return this.name().toLowerCase();
	}
}