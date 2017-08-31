package fr.gtm.projetwebservice.domaine;

public class Client {
	
	private int idConseiller;
	private String surname;
	private String name;
	private String adress;
	private String zipCode;
	private String city;
	private String telephone;
	private String email;
	
	public Client(int idConseiller, String surname, String name, String adress, String zipCode, String city,
			String telephone, String email) {
		super();
		this.idConseiller = idConseiller;
		this.surname = surname;
		this.name = name;
		this.adress = adress;
		this.zipCode = zipCode;
		this.city = city;
		this.telephone = telephone;
		this.email = email;
	}

	public Client() {
		super();
	}

	public int getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	
}
