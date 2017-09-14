package net.lacnic.web.registro.api.request;

import java.io.Serializable;

public class Phone implements Serializable {

	private static final long serialVersionUID = -4438840176269450794L;

	private String country_code;
	private String area_code;
	private String phone_number;
	private String phone_extension;

	public Phone(String country_code) {
		this.country_code = country_code;
		this.area_code = "";
	}

	public Phone(String country_code, String area_code, String phone_number, String phone_extension) {
		this.country_code = country_code;
		this.area_code = area_code;
		this.phone_number = phone_number;
		if (phone_extension == null || "".equals(phone_extension))
			this.phone_extension = "0000";
		else
			this.phone_extension = phone_extension;
	}

	public Phone() {
		this.area_code = "";
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public String getArea_code() {
		return area_code == null ? "" : area_code;
	}

	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getPhone_extension() {
		return phone_extension;
	}

	public void setPhone_extension(String phone_extension) {
		this.phone_extension = phone_extension;
	}
}
