package net.lacnic.web.registro.api.request;

import java.io.Serializable;

public enum TipoContacto implements Serializable {
	BILLING, ADMIN, MEMBER, ABUSE, TECH, ROUTING, SECURITY;

	public boolean isBilling() {
		return BILLING.equals(this);
	}

	public boolean isAdmin() {
		return ADMIN.equals(this);
	}

	public boolean isMember() {
		return MEMBER.equals(this);
	}

	public boolean isAbuse() {
		return ABUSE.equals(this);
	}

	public boolean isTech() {
		return TECH.equals(this);
	}

	@Override
	public String toString() {
		return name().toLowerCase();
	}
}