package net.lacnic.web.registro.api.request;

import java.io.Serializable;

public class DsData implements Serializable {

	private static final long serialVersionUID = 1L;
	private IPNetworkRange ipnetwork_range;
	private String keyTag;
	private String alg;
	private String digestType;
	private String digest;

	public DsData() {
	}

	public DsData(IPNetworkRange ipnetwork_range, String keyTag, String alg, String digestType, String digest) {
		this.ipnetwork_range = ipnetwork_range;
		this.keyTag = keyTag;
		this.alg = alg;
		this.digestType = digestType;
		this.digest = digest;
	}

	public IPNetworkRange getIpnetwork_range() {
		return ipnetwork_range;
	}

	public void setIpnetwork_range(IPNetworkRange ipnetwork_range) {
		this.ipnetwork_range = ipnetwork_range;
	}

	public String getKeyTag() {
		return keyTag;
	}

	public void setKeyTag(String keyTag) {
		this.keyTag = keyTag;
	}

	public String getAlg() {
		return alg;
	}

	public void setAlg(String alg) {
		this.alg = alg;
	}

	public String getDigestType() {
		return digestType;
	}

	public void setDigestType(String digestType) {
		this.digestType = digestType;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}
	
	
}
