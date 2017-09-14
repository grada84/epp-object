package net.lacnic.web.registro.api.request;

import java.io.Serializable;
import java.util.List;

public class ReverseDNS implements Serializable {

	private static final long serialVersionUID = 1L;
	private IPNetworkRange ipnetwork_range;
	private List<String> hostnames;

	public ReverseDNS() {
	}
	
	public ReverseDNS(IPNetworkRange ipnetwork_range, List<String> hostnames) {
		this.ipnetwork_range = ipnetwork_range;
		this.hostnames = hostnames;
	}

	public List<String> getHostnames() {
		return hostnames;
	}

	public void setHostnames(List<String> hostnames) {
		this.hostnames = hostnames;
	}

	public IPNetworkRange getIpnetwork_range() {
		return ipnetwork_range;
	}

	public void setIpnetwork_range(IPNetworkRange ipnetwork_range) {
		this.ipnetwork_range = ipnetwork_range;
	}
}
