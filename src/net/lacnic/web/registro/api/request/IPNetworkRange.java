package net.lacnic.web.registro.api.request;

import java.io.Serializable;

public class IPNetworkRange implements Serializable {

	private static final long serialVersionUID = 1L;
	private String start_address;
	private String end_address;
	private String version;

	public IPNetworkRange(String start_address, String end_address, String version) {
		this.start_address = start_address;
		this.end_address = end_address;
		this.version = version;
	}

	public IPNetworkRange(String start_address, String end_address, int version) {
		this(start_address, end_address, "v" + version);

	}

	public IPNetworkRange() {

	}

	public String getStart_address() {
		return start_address;
	}

	public void setStart_address(String start_address) {
		this.start_address = start_address;
	}

	public String getEnd_address() {
		return end_address;
	}

	public void setEnd_address(String end_address) {
		this.end_address = end_address;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
