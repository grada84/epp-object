package net.lacnic.web.registro.api.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonDeserialize
@JsonSerialize
public class OrgRequest extends GenericRequest implements Serializable {

	private static final long serialVersionUID = 3047224172170708146L;

	private String id;// ORG-ID
	private String name;
	private String responsible;
	private Address address;
	private Phone phone;
	private TipoOrg type;
	private TipoEPPStatus epp_status;
	private String epp_password;
	private List<String> epp_ip_authorized;
	private List<TipoCategoria> category;
	private TipoResourcesClass resources_class;
	private String legacy;
	private String renewal_date;
	private List<Contact> contacts;

	public OrgRequest(String user, String ip) {
		super(user, ip);
	}

	public OrgRequest() {
		super("", "");
	}

	public OrgRequest(String user, String ip, String pais, String countryCodeNumber) {
		super(user, ip);
		this.contacts = new ArrayList<Contact>();
		this.contacts.add(new Contact(user, TipoContacto.ADMIN));
		this.contacts.add(new Contact(user, TipoContacto.BILLING));
		this.contacts.add(new Contact(user, TipoContacto.MEMBER));
		this.phone = new Phone(countryCodeNumber);
		this.address = new Address(pais);
		this.type = TipoOrg.NORMAL;
		this.epp_status = TipoEPPStatus.BLOCKED;
		this.epp_password = "";
		this.epp_ip_authorized = new ArrayList<String>();
		this.category = new ArrayList<TipoCategoria>();
		this.category.add(TipoCategoria.END_USER);
		this.resources_class = TipoResourcesClass.ALL_RESOURCES;
		this.legacy = "false";
		this.renewal_date = new Date().toString();
	}

	private OrgRequest(String user, String ip, String id, String name, String admin_contact, String cob_contact, String mem_contact, String responsible, Address address, Phone phone, TipoOrg type, String epp_password, List<String> epp_ip_authorized, List<TipoCategoria> category, TipoResourcesClass resources_class, TipoEPPStatus epp_status, String legacy, String renewal_date) {
		super(user, ip);
		this.name = name;
		this.id = id;
		contacts = new ArrayList<Contact>();
		contacts.add(new Contact(admin_contact, TipoContacto.ADMIN));
		contacts.add(new Contact(cob_contact, TipoContacto.BILLING));
		contacts.add(new Contact(mem_contact, TipoContacto.MEMBER));
		this.responsible = responsible;
		this.address = address;
		this.phone = phone;
		this.type = type;
		this.epp_status = epp_status;
		this.epp_password = epp_password;
		this.epp_ip_authorized = epp_ip_authorized;
		this.category = category;
		this.resources_class = resources_class;
		this.legacy = legacy;
		this.renewal_date = renewal_date;
	}

	// PARA CREACION
	public OrgRequest(String user, String ip, String name, String admin_contact, String cob_contact, String mem_contact, String responsible, Address address, Phone phone, TipoOrg type, String epp_password, List<String> epp_ip_authorized, List<TipoCategoria> category, TipoResourcesClass resources_class, TipoEPPStatus epp_status, String legacy, String renewal_date) {
		this(user, ip, "", name, admin_contact, cob_contact, mem_contact, responsible, address, phone, type, epp_password, epp_ip_authorized, category, resources_class, epp_status, legacy, renewal_date);
	}

	// PARA EDICION
	public OrgRequest(String user, String ip, String id, String name, String responsible, Address address, Phone phone, TipoOrg type, String epp_password, List<String> epp_ip_authorized, List<TipoCategoria> category, TipoResourcesClass resources_class, TipoEPPStatus epp_status, String legacy, String renewal_date) {
		this(user, ip, id, name, "", "", "", responsible, address, phone, type, epp_password, epp_ip_authorized, category, resources_class, epp_status, legacy, renewal_date);
	}

	/**
	 * Constructor usado únicamente en el caso de querer hacer una
	 * {@link IpRequest}. Esta {@link OrgRequest} deberá estar dentro de la
	 * {@link IpRequest} Sirve para transportar el ORG-ID (id)
	 * 
	 * @param id
	 *            (ORG-ID)
	 */
	public OrgRequest(String user, String ip, String id) {
		this(user, ip, id, "", "", "", "", "", new Address(), new Phone(), null, "", new ArrayList<String>(), new ArrayList<TipoCategoria>(), null, TipoEPPStatus.ACTIVE, "", "");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}

	public TipoOrg getType() {
		return type;
	}

	public void setType(TipoOrg type) {
		this.type = type;
	}

	public TipoEPPStatus getEpp_status() {
		return epp_status;
	}

	public void setEpp_status(TipoEPPStatus epp_status) {
		this.epp_status = epp_status;
	}

	public String getEpp_password() {
		return epp_password;
	}

	public void setEpp_password(String epp_password) {
		this.epp_password = epp_password;
	}

	public List<String> getEpp_ip_authorized() {
		return epp_ip_authorized;
	}

	public void setEpp_ip_authorized(List<String> epp_ip_authorized) {
		this.epp_ip_authorized = epp_ip_authorized;
	}

	public List<TipoCategoria> getCategory() {
		return category;
	}

	public void setCategory(List<TipoCategoria> category) {
		this.category = category;
	}

	public TipoResourcesClass getResources_class() {
		return resources_class;
	}

	public void setResources_class(TipoResourcesClass resources_class) {
		this.resources_class = resources_class;
	}

	public String getLegacy() {
		return legacy;
	}

	public void setLegacy(String legacy) {
		this.legacy = legacy;
	}

	public String getRenewal_date() {
		return renewal_date;
	}

	public void setRenewal_date(String renewal_date) {
		this.renewal_date = renewal_date;
	}

	@Override
	public String toString() {
		String admin_contact = "";
		for (Contact contact : contacts) {
			if (contact.getTipoContacto().equals(TipoContacto.ADMIN))
				admin_contact = contact.getHandle();
		}
		return "OrgRequest [name=" + name + "address" + address + ", phone=" + phone + ", admin_contact=" + admin_contact + ", responsible=" + responsible + ", type=" + type + ", epp_status=" + epp_status + ", epp_password=" + epp_password + ", epp_ip_authorized=" + epp_ip_authorized + ", category=" + category + ", resources_class=" + resources_class + ", legacy=" + legacy + ", renewal_date=" + renewal_date + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id.toUpperCase();
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

}
