package net.lacnic.web.registro.api.request;

import java.io.Serializable;

public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	private String street_address;
	private String number_address;
	private String complement_address;
	private String city;
	private String state;
	private String pc;
	private String country;

	public Address(String street_address, String number_address, String complement_address, String city, String state, String pc, String country) {
		this.street_address = street_address;
		this.number_address = number_address;
		this.city = city;
		this.state = state;
		this.country = country;

		if (complement_address == null || "".equals(complement_address))
			this.complement_address = "-";
		else
			this.complement_address = complement_address;

		if (pc == null || "".equals(pc))
			this.pc = "-";
		else
			this.pc = pc;
	}

	public Address(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [street_address=" + street_address + ", number_address=" + number_address + ", complement_address=" + complement_address + ", city=" + city + ", state=" + state + ", pc=" + pc + ", country=" + country + "]";
	}

	public Address() {

	}

	public String getStreet_address() {
		return street_address;
	}

	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}

	public String getNumber_address() {
		return number_address;
	}

	public void setNumber_address(String number_address) {
		this.number_address = number_address;
	}

	public String getComplement_address() {
		return complement_address;
	}

	public void setComplement_address(String complement_address) {
		this.complement_address = complement_address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPc() {
		return pc;
	}

	public void setPc(String pc) {
		this.pc = pc;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
