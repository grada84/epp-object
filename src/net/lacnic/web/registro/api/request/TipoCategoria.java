package net.lacnic.web.registro.api.request;

import java.io.Serializable;

public enum TipoCategoria implements Serializable {
	LEGACY, MEMBER, END_USER, MICRO, SMALL, MEDIUM, LARGE, EXTRA_LARGE, XX_LARGE, FOUNDING_PARTNER, B_ACTIVE;

	@Override
	public String toString() {
		if (this.equals(TipoCategoria.EXTRA_LARGE)) {
			return "extra-large";
		}
		if (this.equals(TipoCategoria.XX_LARGE)) {
			return "extra-extra-large";
		}
		if (this.equals(TipoCategoria.FOUNDING_PARTNER)) {
			return "founding-partner";
		}
		if (this.equals(TipoCategoria.B_ACTIVE)) {
			return "b-active";
		}
		return this.name().toLowerCase();
	}

}
