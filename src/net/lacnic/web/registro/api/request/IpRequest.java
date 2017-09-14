package net.lacnic.web.registro.api.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonDeserialize
@JsonSerialize
public class IpRequest extends GenericRequest implements Serializable {

	private static final long serialVersionUID = -1334380375665712492L;
	private OrgRequest orgRequest;
	private String roid; // opcional solo para edicion
	private IPNetworkRange ipnetwork_range;
	private TipoAlocacion type;
	private String asn;
	private List<Contact> contacts;
	private List<ReverseDNS> ipnetwork_reverses_dns; // sólo al crear
	private List<ReverseDNS> ipnetwork_reverses_dns_add; // solo para edicion
	private List<ReverseDNS> ipnetwork_reverses_dns_rem; // solo para edicion
	private List<DsData> ipnetwork_dsdata_dns; // sólo al crear
	private List<DsData> ipnetwork_dsdata_dns_add; // solo para edicion
	private List<DsData> ipnetwork_dsdata_dns_rem; // solo para edicion

	public IpRequest(String user, String ip) {
		super(user, ip);
		this.roid = "";
		this.orgRequest = new OrgRequest(user, ip);
		this.type = TipoAlocacion.NOAPPLY;
		this.ipnetwork_range = new IPNetworkRange();
		this.contacts = new ArrayList<Contact>();
		this.ipnetwork_reverses_dns = new ArrayList<ReverseDNS>();
		this.ipnetwork_reverses_dns_add = new ArrayList<ReverseDNS>();
		this.ipnetwork_reverses_dns_rem = new ArrayList<ReverseDNS>();
		this.ipnetwork_dsdata_dns = new ArrayList<DsData>();
		this.ipnetwork_dsdata_dns_add = new ArrayList<DsData>();
		this.ipnetwork_dsdata_dns_rem = new ArrayList<DsData>();
	}

	public IpRequest(String user, String ip, OrgRequest orgRequest, String roid, String asn, IPNetworkRange ipnetwork_range, TipoAlocacion type, List<Contact> contacts, List<ReverseDNS> ipnetwork_reverses_dns, List<ReverseDNS> ipnetwork_reverses_dns_add, List<ReverseDNS> ipnetwork_reverses_dns_rem) {
		super(user, ip);
		this.orgRequest = orgRequest;
		this.roid = roid;
		this.asn = asn;
		this.type = type;
		this.ipnetwork_range = ipnetwork_range;
		this.contacts = contacts;
		this.ipnetwork_reverses_dns = ipnetwork_reverses_dns;
		this.ipnetwork_reverses_dns_add = ipnetwork_reverses_dns_add;
		this.ipnetwork_reverses_dns_rem = ipnetwork_reverses_dns_rem;
		this.ipnetwork_dsdata_dns = new ArrayList<DsData>();
		this.ipnetwork_dsdata_dns_add = new ArrayList<DsData>();
		this.ipnetwork_dsdata_dns_rem = new ArrayList<DsData>();
	}
	
	public IpRequest(String user, String ip, String roid, TipoAlocacion type, List<DsData> ipnetwork_dsdata_dns_add, List<DsData> ipnetwork_dsdata_dns_rem) {
		super(user, ip);
		this.orgRequest = new OrgRequest(user, ip);
		this.roid = roid;
		this.asn = "";
		this.type = type;
		this.ipnetwork_range = new IPNetworkRange();
		this.contacts = new ArrayList<Contact>();;
		this.ipnetwork_reverses_dns = new ArrayList<ReverseDNS>();
		this.ipnetwork_reverses_dns_add = new ArrayList<ReverseDNS>();
		this.ipnetwork_reverses_dns_rem = new ArrayList<ReverseDNS>();
		this.ipnetwork_dsdata_dns_add = ipnetwork_dsdata_dns_add;
		this.ipnetwork_dsdata_dns_rem = ipnetwork_dsdata_dns_rem;
	}


	public IpRequest(String user, String ip, OrgRequest orgRequest, long status, IPNetworkRange ipnetwork_range, String contacto) {
		super(user, ip);
		this.orgRequest = orgRequest;
		this.ipnetwork_range = ipnetwork_range;
		this.contacts = new ArrayList<Contact>();
		this.contacts.add(new Contact(contacto, TipoContacto.TECH));
		this.contacts.add(new Contact(contacto, TipoContacto.ABUSE));
		this.roid = "";
		this.asn = "";
		this.type = getTypeAllocations(status);
		this.ipnetwork_reverses_dns = new ArrayList<ReverseDNS>();
		this.ipnetwork_reverses_dns_add = new ArrayList<ReverseDNS>();
		this.ipnetwork_reverses_dns_rem = new ArrayList<ReverseDNS>();
		this.ipnetwork_dsdata_dns = new ArrayList<DsData>();
		this.ipnetwork_dsdata_dns_add = new ArrayList<DsData>();
		this.ipnetwork_dsdata_dns_rem = new ArrayList<DsData>();
	}

	public IpRequest(String user, String ip, OrgRequest orgRequest, IPNetworkRange ipnetwork_range, List<Contact> contacts, List<ReverseDNS> ipnetwork_reverses_dns) {
		this(user, ip, orgRequest, "", "", ipnetwork_range, TipoAlocacion.ALLOCATION, contacts, ipnetwork_reverses_dns, new ArrayList<ReverseDNS>(), new ArrayList<ReverseDNS>());
	}

	public IpRequest(String user, String ip, String roid, TipoAlocacion type, List<Contact> contacts, List<ReverseDNS> ipnetwork_reverses_dns_add, List<ReverseDNS> ipnetwork_reverses_dns_rem) {
		this(user, ip, new OrgRequest(user, ip), roid, "", new IPNetworkRange(), type, contacts, new ArrayList<ReverseDNS>(), ipnetwork_reverses_dns_add, ipnetwork_reverses_dns_rem);
	}

	public IpRequest(String user, String ip, String roid, List<Contact> contacts) {
		this(user, ip, null, roid, "", null, TipoAlocacion.NOAPPLY, contacts, new ArrayList<ReverseDNS>(), new ArrayList<ReverseDNS>(), new ArrayList<ReverseDNS>());
	}

	public IpRequest(String user, String ip, String roid) {
		this(user, ip, new OrgRequest(user, ip), roid, "", new IPNetworkRange(), TipoAlocacion.NOAPPLY, new ArrayList<Contact>(), new ArrayList<ReverseDNS>(), new ArrayList<ReverseDNS>(), new ArrayList<ReverseDNS>());
	}

	public IpRequest(String user, String ip, OrgRequest orgRequest, IPNetworkRange ipnetwork_range, TipoAlocacion type, List<Contact> contacts, List<ReverseDNS> ipnetwork_reverses_dns) {
		this(user, ip, orgRequest, "", "", ipnetwork_range, type, contacts, ipnetwork_reverses_dns, new ArrayList<ReverseDNS>(), new ArrayList<ReverseDNS>());
	}

	public static TipoAlocacion getTypeAllocations(long status) {
		if (status == 0 || status == 2)
			return TipoAlocacion.ALLOCATION;
		else
			return TipoAlocacion.ASSIGNMENT;
	}

	public IPNetworkRange getIpnetwork_range() {
		return ipnetwork_range;
	}

	public void setIpnetwork_range(IPNetworkRange ipnetwork_range) {
		this.ipnetwork_range = ipnetwork_range;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public TipoAlocacion getType() {
		return type;
	}

	public void setType(TipoAlocacion type) {
		this.type = type;
	}

	public List<ReverseDNS> getIpnetwork_reverses_dns() {
		return ipnetwork_reverses_dns;
	}

	public void setIpnetwork_reverses_dns(List<ReverseDNS> ipnetwork_reverses_dns) {
		this.ipnetwork_reverses_dns = ipnetwork_reverses_dns;
	}

	public String getRoid() {
		return roid;
	}

	public void setRoid(String roid) {
		this.roid = roid;
	}

	public List<ReverseDNS> getIpnetwork_reverses_dns_add() {
		return ipnetwork_reverses_dns_add;
	}

	public void setIpnetwork_reverses_dns_add(List<ReverseDNS> ipnetwork_reverses_dns_add) {
		this.ipnetwork_reverses_dns_add = ipnetwork_reverses_dns_add;
	}

	public List<ReverseDNS> getIpnetwork_reverses_dns_rem() {
		return ipnetwork_reverses_dns_rem;
	}

	public void setIpnetwork_reverses_dns_rem(List<ReverseDNS> ipnetwork_reverses_dns_rem) {
		this.ipnetwork_reverses_dns_rem = ipnetwork_reverses_dns_rem;
	}

	public List<DsData> getIpnetwork_dsdata_dns() {
		return ipnetwork_dsdata_dns;
	}

	public void setIpnetwork_dsdata_dns(List<DsData> ipnetwork_dsdata_dns) {
		this.ipnetwork_dsdata_dns = ipnetwork_dsdata_dns;
	}

	public List<DsData> getIpnetwork_dsdata_dns_add() {
		return ipnetwork_dsdata_dns_add;
	}

	public void setIpnetwork_dsdata_dns_add(List<DsData> ipnetwork_dsdata_dns_add) {
		this.ipnetwork_dsdata_dns_add = ipnetwork_dsdata_dns_add;
	}

	public List<DsData> getIpnetwork_dsdata_dns_rem() {
		return ipnetwork_dsdata_dns_rem;
	}

	public void setIpnetwork_dsdata_dns_rem(List<DsData> ipnetwork_dsdata_dns_rem) {
		this.ipnetwork_dsdata_dns_rem = ipnetwork_dsdata_dns_rem;
	}

	/**
	 * Setea las tres listas de DNS como listas vacías [].
	 */
	// public void vaciarDnss() {
	// final List<ReverseDNS> reversosDnsVacios = new ArrayList<ReverseDNS>();
	// setIpnetwork_reverses_dns(reversosDnsVacios);
	// setIpnetwork_reverses_dns_add(reversosDnsVacios);
	// setIpnetwork_reverses_dns_rem(reversosDnsVacios);
	// }

	/**
	 * Vacia las dos listas de DNS que se usan en el momento de edición del
	 * bloque.
	 */
	public void vaciarDnssDeEdicion() {
		final List<ReverseDNS> reversosDnsVacios = new ArrayList<ReverseDNS>();
		setIpnetwork_reverses_dns_add(reversosDnsVacios);
		setIpnetwork_reverses_dns_rem(reversosDnsVacios);
	}

	/**
	 * Vacia la única lista de DNS que se usa en el momento de creación del
	 * bloque.
	 */
	public void vaciarDnssDeCreacion() {
		final List<ReverseDNS> reversosDnsVacios = new ArrayList<ReverseDNS>();
		setIpnetwork_reverses_dns(reversosDnsVacios);
	}

	/**
	 * Setea las tres listas de DNS como listas vacías [].
	 */
	// public void vaciarDsRegistro() {
	// final List<DsData> dsDataVacios = new ArrayList<DsData>();
	// setIpnetwork_dsdata_dns(dsDataVacios);
	// setIpnetwork_dsdata_dns_add(dsDataVacios);
	// setIpnetwork_dsdata_dns_rem(dsDataVacios);
	// }

	/**
	 * Vacia las dos listas de DNS que se usan en el momento de edición del
	 * bloque.
	 */
	public void vaciarDsRegistroEdicion() {
		final List<DsData> dsDataVacios = new ArrayList<DsData>();
		setIpnetwork_dsdata_dns_add(dsDataVacios);
		setIpnetwork_dsdata_dns_rem(dsDataVacios);
	}

	/**
	 * Vacia la única lista de DNS que se usa en el momento de creación del
	 * bloque.
	 */
	public void vaciarDsRegistroCreacion() {
		final List<DsData> dsDataVacios = new ArrayList<DsData>();
		setIpnetwork_dsdata_dns(dsDataVacios);
	}

	public OrgRequest getOrgRequest() {
		return orgRequest;
	}

	public void setOrgRequest(OrgRequest orgRequest) {
		this.orgRequest = orgRequest;
	}

	public String getAsn() {
		return asn;
	}

	public void setAsn(String asn) {
		this.asn = asn;
	}

}
