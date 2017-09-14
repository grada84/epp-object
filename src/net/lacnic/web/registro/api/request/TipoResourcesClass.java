package net.lacnic.web.registro.api.request;

import java.io.Serializable;

public enum TipoResourcesClass implements Serializable {
	ALL_RESOURCES, NON_LEGACY_ONLY;

	@Override
	public String toString() {
		if (this.equals(TipoResourcesClass.ALL_RESOURCES)) {
			return "all-resources";
		}
		if (this.equals(TipoResourcesClass.NON_LEGACY_ONLY)) {
			return "non-legacy-only";
		} else {
			return this.name().toLowerCase();
		}
	}
}
