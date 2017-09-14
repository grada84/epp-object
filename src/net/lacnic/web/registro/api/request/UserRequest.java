package net.lacnic.web.registro.api.request;

import java.io.Serializable;

public class UserRequest extends GenericRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String email;
	// agregado por gerardo para modelar el wizard,no estoy seguro si queda
	private String userId;
	private String password;
	// tambien lo agrego gerardo idem anterior
	private String password2;
	private String reminder_password;

	private String language;

	private Address address;
	private Phone phone;

	public UserRequest(String user, String ip) {
		super(user, ip);
//		init();
	}

	public UserRequest(String user, String ip, String password) {
		this(user, ip, user, password);
	}

	public UserRequest(String user, String ip, String id, String password) {
		super(user, ip);
		this.password = password;
		this.id = id;
//		init();
	}

	public void init() {
		setReminder_password("no-apply");
		setPhone(new Phone());
		setAddress(new Address());
	}

	public UserRequest(String user, String ip, String id, String name, String email, String language, String password, String reminder_password, Address address, Phone phone) {
		super(user, ip);
		this.id = id;
		this.name = name;
		this.email = email;
		this.language = language;
		this.password = password;
		this.reminder_password = reminder_password;
		this.address = address;
		this.phone = phone;
	}

	// public UserRequest(String user, String ip, String modificador) {
	// super(user, ip, modificador);
	// }
	//
	// public void init() {
	// setReminder_password("no-apply");
	// setPhone(new Phone());
	// setAddress(new Address());
	// }
	//
	// public UserRequest(String user, String ip, String modificador, String id,
	// String name, String email, String language, String password, String
	// reminder_password, Address address, Phone phone) {
	// super(user, ip, modificador);
	// this.id = id;
	// this.name = name;
	// this.email = email;
	// this.language = language;
	// this.password = password;
	// this.reminder_password = reminder_password;
	// this.address = address;
	// this.phone = phone;
	// }

	public UserRequest(String user, String ip, String name, String email, String language, String password, String reminder_password, Address address, Phone phone) {
		this(user, ip, "", name, email, language, password, reminder_password, address, phone);
	}

	@Override
	public String toString() {
		return "UserRequest [name=" + name + ", email=" + email + ", address=" + address + ", phone=" + phone + ", password=" + password + ", remainder_password=" + reminder_password + ", language=" + language + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public String getReminder_password() {
		return reminder_password;
	}

	public void setReminder_password(String reminder_password) {
		this.reminder_password = reminder_password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public void setPhoneCode(String phoneCode) {
		this.phone.setCountry_code(phoneCode);
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	/**
	 * Esto hace que el comando epp se ejecute con el id del userRequest como id
	 * el el clrtid es util cuando se ejecuta el cambio clave o alguna otr
	 * aoperación donde no hay nadio logueado al momento de ejecutar alguna
	 * acción
	 */
	public void setUserAsId() {
		setUser(getId());

		// setUser("SERGIO");
		// setModificadorAsADMIN();
	}

}
